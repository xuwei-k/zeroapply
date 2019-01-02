import sbt._

object build {

  final val boilerplateMax = 22
  val scalazVersion = SettingKey[String]("scalazVersion")

  val junit = "com.novocode" % "junit-interface" % "0.11" % "test"

  final val zeroapplyName = "zeroapply"
  final val zeroapplyScalazName = "zeroapply-scalaz"

  val modules: List[String] = List(
    zeroapplyName,
    zeroapplyScalazName,
  )

}
