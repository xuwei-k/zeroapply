import sbt._, Keys._
import sbtrelease._
import xerial.sbt.Sonatype._
import ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys
import sbtbuildinfo.Plugin._

object build extends Build {

  def gitHash: String = scala.util.Try(
    sys.process.Process("git rev-parse HEAD").lines_!.head
  ).getOrElse("master")

  final val ScalazVersion = "7.1.0"
  val generateBoilerplate = TaskKey[Unit]("generateBoilerplate")
  val generateSources = SettingKey[List[Boilerplate.SourceCode]]("generateSources")
  val checkGenerate = TaskKey[Unit]("checkGenerate")
  final val boilerplateMax = 22

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
      "-Ywarn-unused" ::
      "-Ywarn-unused-import" ::
      Nil
    ),
    scalaVersion := "2.11.4",
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
      generateBoilerplate.value
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
  )

  val junit = "com.novocode" % "junit-interface" % "0.11" % "test"

  private final val zeroapplyName = "zeroapply"
  private final val zeroapplyScalazName = "zeroapply-scalaz"

  val modules: List[String] =
    zeroapplyName ::
    zeroapplyScalazName ::
    Nil

  lazy val zeroapply = Project("zeroapply", file("zeroapply")).settings(
    baseSettings : _*
  ).settings(
    name := zeroapplyName,
    sourceGenerators in Compile <+= buildInfo,
    buildInfoPackage := "zeroapply",
    buildInfoObject := "BuildInfoZeroApply",
    generateSources := Boilerplate.zeroapply(boilerplateMax),
    libraryDependencies ++= (
      ("org.scala-lang" % "scala-reflect" % scalaVersion.value) ::
      junit ::
      Nil
    )
  )

  lazy val scalaz = Project("scalaz", file("scalaz")).settings(
    baseSettings : _*
  ).settings(
    name := zeroapplyScalazName,
    sourceGenerators in Compile <+= buildInfo,
    buildInfoPackage := "zeroapply",
    buildInfoObject := "BuildInfoZeroApplyScalaz",
    buildInfoKeys ++= Seq[BuildInfoKey](
      "scalazVersion" -> ScalazVersion
    ),
    generateSources := Boilerplate.scalaz(boilerplateMax),
    libraryDependencies ++= (
      ("org.scalaz" %% "scalaz-core" % ScalazVersion) ::
      ("org.scalaz" %% "scalaz-scalacheck-binding" % ScalazVersion % "test") ::
      junit ::
      Nil
    )
  ).dependsOn(zeroapply)

  lazy val root = {
    import sbtunidoc.Plugin._

    Project("root", file(".")).settings(
      baseSettings ++ unidocSettings ++ Seq(
        name := "zeroapply-all",
        generateSources := Nil,
        artifacts <<= Classpaths.artifactDefs(Seq(packageDoc in Compile)),
        packagedArtifacts <<= Classpaths.packaged(Seq(packageDoc in Compile))
      ) ++ Defaults.packageTaskSettings(
        packageDoc in Compile, (UnidocKeys.unidoc in Compile).map{_.flatMap(Path.allSubpaths)}
      ): _*
    ).aggregate(zeroapply, scalaz)
  }

}
