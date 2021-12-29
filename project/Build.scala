import sbt._

object build {
  final val boilerplateMax = 22
  val scalazVersion = SettingKey[String]("scalazVersion")

  val junit = "com.github.sbt" % "junit-interface" % "0.13.3" % "test"

  final val zeroapplyName = "zeroapply"
  final val zeroapplyScalazName = "zeroapply-scalaz"

  val modules: List[String] = List(
    zeroapplyName,
    zeroapplyScalazName,
  )
}
