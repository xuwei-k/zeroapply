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
      "com.github.scalaprops" %% "scalaprops" % "0.10.1" % "test",
      "com.github.scalaprops" %% "scalaprops-scalaz" % "0.10.1" % "test",
      junit,
    )
  )
  .dependsOn(zeroapply)

lazy val root = Project("root", file("."))
  .settings(
    Common.baseSettings,
    name := "zeroapply-all",
    Common.generateSources := Nil,
    publish / skip := true,
  )
  .aggregate(zeroapply, scalaz)
