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
    scalazVersion := "7.3.8",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % scalazVersion.value,
      "com.github.scalaprops" %% "scalaprops" % "0.10.0" % "test",
      "com.github.scalaprops" %% "scalaprops-scalaz" % "0.10.0" % "test",
      junit,
    )
  )
  .dependsOn(zeroapply)

lazy val root = Project("root", file("."))
  .settings(
    Common.baseSettings,
    name := "zeroapply-all",
    Common.generateSources := Nil,
    artifacts := Nil,
    packagedArtifacts := Map.empty,
    artifacts ++= Classpaths.artifactDefs(Seq(Compile / packageDoc)).value,
    packagedArtifacts ++= Classpaths.packaged(Seq(Compile / packageDoc)).value,
    Defaults.packageTaskSettings(
      (Compile / packageDoc),
      (Compile / unidoc).map { _.flatMap(Path.allSubpaths) }
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
  )
  .enablePlugins(
    ScalaUnidocPlugin
  )
  .aggregate(zeroapply, scalaz)
