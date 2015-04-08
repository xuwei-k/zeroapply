import sbt._, Keys._
import sbtrelease._
import xerial.sbt.Sonatype._
import ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys
import sbtbuildinfo.Plugin._

object Common {

  def gitHash: String = scala.util.Try(
    sys.process.Process("git rev-parse HEAD").lines_!.head
  ).getOrElse("master")

  val generateBoilerplate = TaskKey[Unit]("generateBoilerplate")
  val generateSources = SettingKey[List[Boilerplate.SourceCode]]("generateSources")
  val checkGenerate = TaskKey[Unit]("checkGenerate")

  val baseSettings = ReleasePlugin.releaseSettings ++ sonatypeSettings ++ buildInfoSettings ++ Seq(
    buildInfoKeys := Seq[BuildInfoKey](
      organization,
      name,
      version,
      scalaVersion,
      sbtVersion,
      scalacOptions,
      licenses
    ),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-v"),
    commands += Command.command("updateReadme")(UpdateReadme.updateReadmeTask),
    ReleasePlugin.ReleaseKeys.releaseProcess := Seq[ReleaseStep](
      ReleaseStep{ state =>
        assert(Sxr.disableSxr == false)
        state
      },
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      UpdateReadme.updateReadmeProcess,
      tagRelease,
      ReleaseStep(
        action = { state =>
          val extracted = Project extract state
          extracted.runAggregated(PgpKeys.publishSigned in Global in extracted.get(thisProjectRef), state)
        },
        enableCrossBuild = true
      ),
      setNextVersion,
      commitNextVersion,
      ReleaseStep(
        action = { state =>
          val extracted = Project extract state
          extracted.runAggregated(SonatypeKeys.sonatypeReleaseAll in Global in extracted.get(thisProjectRef), state)
        },
        enableCrossBuild = false
      ),
      UpdateReadme.updateReadmeProcess,
      pushChanges
    ),
    credentials ++= PartialFunction.condOpt(sys.env.get("SONATYPE_USER") -> sys.env.get("SONATYPE_PASS")){
      case (Some(user), Some(pass)) =>
        Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass)
    }.toList,
    organization := "com.github.xuwei-k",
    homepage := Some(url("https://github.com/xuwei-k/zeroapply")),
    licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")),
    scalacOptions ++= (
      "-deprecation" ::
      "-unchecked" ::
      "-Xlint" ::
      "-language:existentials" ::
      "-language:higherKinds" ::
      "-language:implicitConversions" ::
      Nil
    ),
    scalacOptions in compile ++= (
      "-Ywarn-unused" ::
      "-Ywarn-unused-import" ::
      Nil
    ),
    scalaVersion := "2.11.6",
    crossScalaVersions := scalaVersion.value :: Nil,
    scalacOptions in (Compile, doc) ++= {
      val tag = if(isSnapshot.value) gitHash else { "v" + version.value }
      Seq(
        "-sourcepath", (baseDirectory in LocalRootProject).value.getAbsolutePath,
        "-doc-source-url", s"https://github.com/xuwei-k/zeroapply/tree/${tag}€{FILE_PATH}.scala"
      )
    },
    logBuffered in Test := false,
    pomExtra := (
      <developers>
        <developer>
          <id>xuwei-k</id>
          <name>Kenji Yoshida</name>
          <url>https://github.com/xuwei-k</url>
        </developer>
      </developers>
      <scm>
        <url>git@github.com:xuwei-k/zeroapply.git</url>
        <connection>scm:git:git@github.com:xuwei-k/zeroapply.git</connection>
        <tag>{if(isSnapshot.value) gitHash else { "v" + version.value }}</tag>
      </scm>
    ),
    fork in Test := true,
    incOptions := incOptions.value.withNameHashing(true),
    description := "zero cost Apply/Applicative syntax",
    checkGenerate := {
      val _ = generateBoilerplate.value
      val lines = sys.process.Process("git diff").lines.toList
      assert(lines.isEmpty, lines.mkString("\n"))
    },
    generateBoilerplate := {
      val dir = (scalaSource in Compile).value
      generateSources.value.foreach{ source =>
        IO.write(dir / (source.name + ".scala"), source.code)
      }
    },
    pomPostProcess := { node =>
      import scala.xml._
      import scala.xml.transform._
      def stripIf(f: Node => Boolean) = new RewriteRule {
        override def transform(n: Node) =
          if (f(n)) NodeSeq.Empty else n
      }
      val stripTestScope = stripIf { n => n.label == "dependency" && (n \ "scope").text == "test" }
      new RuleTransformer(stripTestScope).transform(node)(0)
    }
  ) ++ Sxr.subProjectSxr(Compile, "classes.sxr")

}
