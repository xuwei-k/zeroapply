scalacOptions ++= (
  "-deprecation" ::
  "-unchecked" ::
  "-Xlint" ::
  "-language:existentials" ::
  "-language:higherKinds" ::
  "-language:implicitConversions" ::
  "-Yno-adapted-args" ::
  Nil
)

addSbtPlugin("com.github.scalaprops" % "sbt-scalaprops" % "0.2.6")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.1")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.5")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.3")

addSbtPlugin("com.eed3si9n" % "sbt-unidoc" % "0.4.2")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.7.0")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}
