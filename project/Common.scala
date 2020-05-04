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
      scalacOptions,
      licenses
    ),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-v"),
    commands += Command.command("updateReadme")(UpdateReadme.updateReadmeTask),
    releaseProcess := Seq[ReleaseStep](
      ReleaseStep { state =>
        assert((Sxr.enableSxr in LocalRootProject).value)
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
      releaseStepCommandAndRemaining("sonatypeBundleRelease"),
      setNextVersion,
      commitNextVersion,
      UpdateReadme.updateReadmeProcess,
      pushChanges
    ),
    credentials ++= PartialFunction
      .condOpt(sys.env.get("SONATYPE_USER") -> sys.env.get("SONATYPE_PASS")) {
        case (Some(user), Some(pass)) =>
          Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass)
      }
      .toList,
    organization := "com.github.xuwei-k",
    homepage := Some(url("https://github.com/xuwei-k/zeroapply")),
    licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")),
    scalacOptions ++= Seq(
      "-deprecation",
      "-unchecked",
      "-Xlint",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
    ),
    scalacOptions ++= unusedWarnings,
    scalacOptions ++= PartialFunction
      .condOpt(CrossVersion.partialVersion(scalaVersion.value)) {
        case Some((2, v)) if v <= 12 => "-Yno-adapted-args"
      }
      .toList,
    scalaVersion := Scala211,
    crossScalaVersions := Scala211 :: "2.12.11" :: "2.13.2" :: Nil,
    scalacOptions in (Compile, doc) ++= {
      val tag =
        if (isSnapshot.value) gitHash
        else {
          "v" + version.value
        }
      Seq(
        "-sourcepath",
        (baseDirectory in LocalRootProject).value.getAbsolutePath,
        "-doc-source-url",
        s"https://github.com/xuwei-k/zeroapply/tree/${tag}€{FILE_PATH}.scala"
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
        <tag>{
        if (isSnapshot.value) gitHash
        else {
          "v" + version.value
        }
      }</tag>
      </scm>
    ),
    fork in Test := true,
    description := "zero cost Apply/Applicative syntax",
    checkGenerate := {
      val _ = generateBoilerplate.value
      val lines = sys.process.Process("git diff").lineStream.toList
      assert(lines.isEmpty, lines.mkString("\n"))
    },
    generateBoilerplate := {
      val dir = (scalaSource in Compile).value
      generateSources.value.foreach { source => IO.write(dir / (source.name + ".scala"), source.code) }
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
  ) ++ Seq(Compile, Test).flatMap(c => scalacOptions in (c, console) ~= { _.filterNot(unusedWarnings.toSet) })
}
