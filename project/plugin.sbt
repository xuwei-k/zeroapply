scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Yno-adapted-args",
)

addSbtPlugin("com.github.scalaprops" % "sbt-scalaprops" % "0.5.1")

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.3.1")

addSbtPlugin("com.github.sbt" % "sbt-release" % "1.4.0")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.12.2")

addSbtPlugin("com.github.sbt" % "sbt-unidoc" % "0.6.0")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.13.1")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.5")

fullResolvers ~= { _.filterNot(_.name == "jcenter") }
