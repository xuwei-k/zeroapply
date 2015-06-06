import sbt._, Keys._
import sbtbuildinfo.BuildInfoPlugin
import sbtbuildinfo.BuildInfoKeys._

object build extends Build {

  private final val boilerplateMax = 22
  private final val ScalazVersion = "7.1.2"

  private val junit = "com.novocode" % "junit-interface" % "0.11" % "test"

  private final val zeroapplyName = "zeroapply"
  private final val zeroapplyScalazName = "zeroapply-scalaz"

  val modules: List[String] =
    zeroapplyName ::
    zeroapplyScalazName ::
    Nil

  lazy val zeroapply = Project("zeroapply", file("zeroapply")).settings(
    Common.baseSettings : _*
  ).enablePlugins(
    BuildInfoPlugin
  ).settings(
    name := zeroapplyName,
    buildInfoPackage := "zeroapply",
    buildInfoObject := "BuildInfoZeroApply",
    Common.generateSources := Boilerplate.zeroapply(boilerplateMax),
    libraryDependencies ++= (
      ("org.scala-lang" % "scala-reflect" % scalaVersion.value) ::
      junit ::
      Nil
    )
  )

  lazy val scalaz = Project("scalaz", file("scalaz")).settings(
    Common.baseSettings : _*
  ).enablePlugins(
    BuildInfoPlugin
  ).settings(
    name := zeroapplyScalazName,
    buildInfoPackage := "zeroapply",
    buildInfoObject := "BuildInfoZeroApplyScalaz",
    buildInfoKeys ++= Seq(
      "scalazVersion" -> ScalazVersion
    ),
    Common.generateSources := Boilerplate.scalaz(boilerplateMax),
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
      Common.baseSettings ++ unidocSettings ++ Seq(
        name := "zeroapply-all",
        Common.generateSources := Nil,
        libraryDependencies ++= {
          if (Sxr.disableSxr) Nil
          else Seq((libraryDependencies in scalaz).value, (libraryDependencies in zeroapply).value).flatten
        },
        artifacts := Nil,
        packagedArtifacts := Map.empty,
        artifacts <++= Classpaths.artifactDefs(Seq(packageDoc in Compile)),
        packagedArtifacts <++= Classpaths.packaged(Seq(packageDoc in Compile)),
        scalacOptions in UnidocKeys.unidoc += {
          "-P:sxr:base-directory:" + (sources in UnidocKeys.unidoc in ScalaUnidoc).value.mkString(":")
        }
      ) ++ Defaults.packageTaskSettings(
        packageDoc in Compile, (UnidocKeys.unidoc in Compile).map{_.flatMap(Path.allSubpaths)}
      ) ++ Sxr.commonSettings(Compile, "unidoc.sxr") ++ Seq(
        Sxr.packageSxr in Compile <<= (Sxr.packageSxr in Compile).dependsOn(UnidocKeys.unidoc in Compile)
      ) : _*
    ).aggregate(zeroapply, scalaz)
  }

}
