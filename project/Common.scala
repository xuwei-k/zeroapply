import sbt._, Keys._
import sbtrelease._
import sbtrelease.ReleasePlugin.autoImport._
import ReleaseStateTransformations._
import com.jsuereth.sbtpgp.PgpKeys
import sbtbuildinfo.BuildInfoKeys._
import xerial.sbt.Sonatype.autoImport.sonatypePublishToBundle

object Common {
  def gitHash: String =
    sys.process.Process("git rev-parse HEAD").lineStream_!.head

  val generateBoilerplate = TaskKey[Unit]("generateBoilerplate")
  val generateSources = SettingKey[List[Boilerplate.SourceCode]]("generateSources")
  val checkGenerate = TaskKey[Unit]("checkGenerate")

  private[this] val unusedWarnings = Seq(
    "-Ywarn-unused",
  )

  private[this] val Scala211 = "2.11.12"

  val baseSettings = Seq(
    fullResolvers ~= { _.filterNot(_.name == "jcenter") },
    publishTo := sonatypePublishToBundle.value,
    buildInfoKeys := Seq(
      organization,
      name,
      version,
      scalaVersion,
      sbtVersion,
      licenses
    ),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-v"),
    commands += Command.command("updateReadme")(UpdateReadme.updateReadmeTask),
    releaseProcess := Seq[ReleaseStep](
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
          extracted.runAggregated(extracted.get(thisProjectRef) / (Global / PgpKeys.publishSigned), state)
        },
        enableCrossBuild = true
      ),
      releaseStepCommandAndRemaining("sonatypeBundleRelease"),
      setNextVersion,
      commitNextVersion,
      UpdateReadme.updateReadmeProcess,
      pushChanges
    ),
    credentials ++= PartialFunction
      .condOpt(sys.env.get("SONATYPE_USER") -> sys.env.get("SONATYPE_PASS")) { case (Some(user), Some(pass)) =>
        Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass)
      }
      .toList,
    organization := "com.github.xuwei-k",
    homepage := Some(url("https://github.com/xuwei-k/zeroapply")),
    licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")),
    scalacOptions ++= Seq(
      "-deprecation",
      "-unchecked",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
    ),
    scalacOptions ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((3, _)) =>
          Nil
        case _ =>
          Seq("-Xlint") ++ unusedWarnings
      }
    },
    scalacOptions ++= PartialFunction
      .condOpt(CrossVersion.partialVersion(scalaVersion.value)) {
        case Some((2, v)) if v <= 12 => "-Yno-adapted-args"
      }
      .toList,
    scalaVersion := Scala211,
    crossScalaVersions := Scala211 :: "2.12.17" :: "2.13.10" :: "3.2.2" :: Nil,
    (Compile / doc / scalacOptions) ++= {
      val tag =
        if (isSnapshot.value) gitHash
        else {
          "v" + version.value
        }
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, _)) =>
          Seq(
            "-sourcepath",
            (LocalRootProject / baseDirectory).value.getAbsolutePath,
            "-doc-source-url",
            s"https://github.com/xuwei-k/zeroapply/tree/${tag}€{FILE_PATH}.scala"
          )
        case _ =>
          Nil
      }
    },
    Test / logBuffered := false,
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
        <tag>{
        if (isSnapshot.value) gitHash
        else {
          "v" + version.value
        }
      }</tag>
      </scm>
    ),
    Test / fork := true,
    description := "zero cost Apply/Applicative syntax",
    checkGenerate := {
      val lines = sys.process.Process("git diff").lineStream.toList
      assert(lines.isEmpty, lines.mkString("\n"))
    },
    generateBoilerplate := {
      val dir = (Compile / scalaSource).value.getParentFile
      generateSources.value.foreach { source =>
        IO.write(
          dir / s"scala-${source.version}" / (source.name + ".scala"),
          source.code
        )
      }
    },
    pomPostProcess := { node =>
      import scala.xml._
      import scala.xml.transform._
      def stripIf(f: Node => Boolean) =
        new RewriteRule {
          override def transform(n: Node) =
            if (f(n)) NodeSeq.Empty else n
        }
      val stripTestScope = stripIf { n => n.label == "dependency" && (n \ "scope").text == "test" }
      new RuleTransformer(stripTestScope).transform(node)(0)
    }
  ) ++ Seq(Compile, Test).flatMap(c => c / console / scalacOptions ~= { _.filterNot(unusedWarnings.toSet) })
}
