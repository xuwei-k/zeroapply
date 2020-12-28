package zeroapply

import org.junit.Assert.assertEquals
import org.junit.Test

import scalaz.{-\/, \/-}

final class ScalazTest2 {
  private def err: Nothing = sys.error("undefined")

  implicit class AssertOps[A](private val a1: A) {
    def mustEqual[AA >: A](a2: AA) = assertEquals(a1, a2)
  }

  object scalaz

  private case class Foo[A, B](a: A, b: B, c: Int)
  private object Foo {
    import _root_.scalaz.Order
    import _root_.scalaz.std.anyVal._
    implicit def instance[A: Order, B: Order]: Order[Foo[A, B]] =
      CaseClass.order[Foo[A, B]]
  }

  @Test
  def caseClassEqualOrder(): Unit = {
    import _root_.scalaz.std.AllInstances._
    import _root_.scalaz.{Equal, Order}

    val f = Foo(true, Option("a"), 42)
    assert(Order[Foo[Boolean, Option[String]]].lessThan(f, f.copy(c = 100)))
    assert(Equal[Foo[Boolean, Option[String]]].equal(f, f.copy()))
    assert(Order[Foo[Boolean, Option[String]]].equalIsNatural)

    assert(CaseClass.equal[Foo[Boolean, Option[String]]].equal(f, f.copy()))
    assert(CaseClass.equal[Foo[Boolean, Option[String]]].equalIsNatural)
  }
}
