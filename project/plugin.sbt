scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Yno-adapted-args",
)

addSbtPlugin("ch.epfl.lamp" % "sbt-dotty" % "0.5.4")

addSbtPlugin("com.github.scalaprops" % "sbt-scalaprops" % "0.4.1")

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.1.2")

addSbtPlugin("com.github.sbt" % "sbt-release" % "1.0.15")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.7")

addSbtPlugin("com.eed3si9n" % "sbt-unidoc" % "0.4.3")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.10.0")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")

fullResolvers ~= { _.filterNot(_.name == "jcenter") }
