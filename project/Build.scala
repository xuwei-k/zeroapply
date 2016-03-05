import sbt._, Keys._
import sbtbuildinfo.BuildInfoPlugin
import sbtbuildinfo.BuildInfoKeys._

object build extends Build {

  private final val boilerplateMax = 22
  val scalazVersion = SettingKey[String]("scalazVersion")

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
      scalazVersion
    ),
    Common.generateSources := Boilerplate.scalaz(boilerplateMax),
    scalazVersion := "7.2.1",
    libraryDependencies ++= (
      ("org.scalaz" %% "scalaz-core" % scalazVersion.value) ::
      ("org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion.value % "test") ::
      junit ::
      Nil
    )
  ).dependsOn(zeroapply)

  lazy val root = {
    import sbtunidoc.Plugin._

    Project("root", file(".")).settings(
      Common.baseSettings ++ unidocSettings
    ).settings(
      name := "zeroapply-all",
      Common.generateSources := Nil,
      libraryDependencies ++= {
        if(Sxr.enableSxr.value) {
          Seq(
            (libraryDependencies in scalaz).value,
            (libraryDependencies in zeroapply).value
          ).flatten
        } else Nil
      },
      artifacts := Nil,
      packagedArtifacts := Map.empty,
      artifacts <++= Classpaths.artifactDefs(Seq(packageDoc in Compile)),
      packagedArtifacts <++= Classpaths.packaged(Seq(packageDoc in Compile))
    ).settings(
      Sxr.settings1
    ).settings(
      Defaults.packageTaskSettings(
        packageDoc in Compile, (UnidocKeys.unidoc in Compile).map{_.flatMap(Path.allSubpaths)}
      )
    ).settings(
      Sxr.settings2
    ).aggregate(zeroapply, scalaz)
  }

}
