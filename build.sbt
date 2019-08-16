import build._

lazy val zeroapply = Project("zeroapply", file("zeroapply"))
  .enablePlugins(
    BuildInfoPlugin
  )
  .settings(
    Common.baseSettings,
    name := zeroapplyName,
    buildInfoPackage := "zeroapply",
    buildInfoObject := "BuildInfoZeroApply",
    Common.generateSources := Boilerplate.zeroapply(boilerplateMax),
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      junit,
    )
  )

lazy val scalaz = Project("scalaz", file("scalaz"))
  .enablePlugins(
    BuildInfoPlugin
  )
  .settings(
    Common.baseSettings,
    name := zeroapplyScalazName,
    buildInfoPackage := "zeroapply",
    buildInfoObject := "BuildInfoZeroApplyScalaz",
    buildInfoKeys ++= Seq(
      scalazVersion
    ),
    Common.generateSources := Boilerplate.scalaz(boilerplateMax),
    scalazVersion := "7.2.28",
    scalapropsWithScalaz,
    scalapropsVersion := "0.6.1",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % scalazVersion.value,
      junit,
    )
  )
  .dependsOn(zeroapply)

lazy val root = Project("root", file("."))
  .settings(
    Common.baseSettings,
    name := "zeroapply-all",
    Common.generateSources := Nil,
    libraryDependencies ++= {
      if (Sxr.enableSxr.value) {
        Seq(
          (libraryDependencies in scalaz).value,
          (libraryDependencies in zeroapply).value
        ).flatten
      } else Nil
    },
    artifacts := Nil,
    packagedArtifacts := Map.empty,
    artifacts ++= Classpaths.artifactDefs(Seq(packageDoc in Compile)).value,
    packagedArtifacts ++= Classpaths.packaged(Seq(packageDoc in Compile)).value,
    Sxr.settings1,
    Defaults.packageTaskSettings(
      packageDoc in Compile,
      (unidoc in Compile).map { _.flatMap(Path.allSubpaths) }
    ),
    Sxr.settings2
  )
  .enablePlugins(
    ScalaUnidocPlugin
  )
  .aggregate(zeroapply, scalaz)
