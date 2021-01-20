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
    libraryDependencies ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, _)) =>
          Seq(
            "org.scala-lang" % "scala-reflect" % scalaVersion.value,
          )
        case _ =>
          Nil
      }
    },
    libraryDependencies ++= {
      Seq(
        junit,
      )
    }
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
    scalazVersion := "7.3.3",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % scalazVersion.value withDottyCompat scalaVersion.value,
      "com.github.scalaprops" %% "scalaprops" % "0.8.1" % "test" withDottyCompat scalaVersion.value,
      "com.github.scalaprops" %% "scalaprops-scalaz" % "0.8.1" % "test" withDottyCompat scalaVersion.value,
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
    publish / skip := {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((3, _)) =>
          // TODO https://github.com/sbt/sbt-unidoc/issues/83
          true
        case _ =>
          false
      }
    },
    Sxr.settings2
  )
  .enablePlugins(
    ScalaUnidocPlugin
  )
  .aggregate(zeroapply, scalaz)
