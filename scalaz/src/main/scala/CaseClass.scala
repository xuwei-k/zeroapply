package zeroapply

import play.api.libs.json.Reads
import zeroapply.PlayJson.Key

import scalaz.{Order, Equal}
import scala.language.experimental.macros

object CaseClass{
  def equal[Z]: Equal[Z] =
    macro CaseClassImpl.equalImpl[Z]

  def order[Z]: Order[Z] =
    macro CaseClassImpl.orderImpl[Z]

  def reads[A]: play.api.libs.json.Reads[A] =
    macro CaseClassImpl.reads[A]
}

case class Foo(
  @Key("a1") x1: String,
  @Key("a2") x2: Option[Boolean],
  @Key("a3") x3: Int,
  @Key("a4") x4: Int,
  @Key("a5") x5: Int,
  @Key("a6") x6: Int,
  @Key("a7") x7: Int,
  @Key("a8") x8: Int,
  @Key("a9") x9: Int,
  @Key("a10") x10: Int,
  @Key("a11") x11: Int,
  @Key("a12") x12: Int,
  @Key("a13") x13: Int,
  @Key("a14") x14: Int,
  @Key("a15") x15: Int,
  @Key("a16") x16: Int,
  @Key("a17") x17: Int,
  @Key("a18") x18: Int,
  @Key("a19") x19: Int,
  @Key("a20") x20: Int,
  @Key("a21") x21: Int,
  @Key("a22") x22: Int,
  @Key("a23") x23: Int,
  @Key("a24") x24: Int,
  @Key("a25") x25: Int
)

object Foo {
  implicit val instance: Reads[Foo] = CaseClass.reads[Foo]
}
