package zeroapply

import org.junit.Assert.assertEquals
import org.junit.Test

import scalaz.{-\/, \/-}

final class ScalazTest {
  private def err: Nothing = sys.error("undefined")

  implicit class AssertOps[A](private val a1: A) {
    def mustEqual(a2: A) = assertEquals(a1, a2)
  }

  object scalaz

  @Test
  def either(): Unit = {
    import _root_.scalaz.syntax.either._

    val a = "a".right[Int]
    val b = List(1).right[Int]
    DisjunctionApply.tuple2(a, b) mustEqual \/-("a" -> List(1))
    DisjunctionApply.apply2(a, b)((_, _) => Vector(9)) mustEqual \/-(Vector(9))
    DisjunctionApply.apply3(\/-(1), -\/("a"), err)(Tuple3.apply) mustEqual -\/("a")
    DisjunctionApply.apply3(-\/(1), err, err)((_, _, _) => "") mustEqual -\/(1)
    DisjunctionApply.tuple3(-\/("a"), err, err) mustEqual -\/("a")
  }

  @Test
  def lazyEither(): Unit = {
    import _root_.scalaz.syntax.equal._
    import _root_.scalaz.std.AllInstances._
    import _root_.scalaz.{Equal, LazyEither, Show}
    import LazyEither.{lazyLeft, lazyRight}
    implicit def equal[A: Equal, B: Equal]: Equal[LazyEither[A, B]] =
      Equal[Either[A, B]].contramap(_.toEither)
    implicit def show[A, B]: Show[LazyEither[A, B]] = Show.showA

    val a = lazyRight[Int]("a")
    val b = lazyRight[Int](List(1))
    LazyEitherApply.tuple2(a, b) assert_=== lazyRight("a" -> List(1))
    LazyEitherApply.apply2(a, b)((_, _) => Vector(9)) assert_=== lazyRight(Vector(9))
    LazyEitherApply.apply3[Int, Int, Int, Int, String](lazyLeft(1), err, err)((_, _, _) => "") assert_=== lazyLeft(1)
    LazyEitherApply.tuple3[Int, Int, Int, String](lazyLeft("a"), err, err) assert_=== lazyLeft("a")
  }
  @Test
  def maybe(): Unit = {
    import _root_.scalaz.Maybe
    import Maybe.{Empty, Just}

    MaybeApply.apply2(Just(1), Just(2))(_ + _) mustEqual Just(3)
    MaybeApply.tuple2(Empty(), err) mustEqual Maybe.empty[(Nothing, Nothing)]
    MaybeApply.apply3(Empty(), err, Empty())((a, b, c) => 9) mustEqual Empty()
    MaybeApply.tuple3(Just(1), Just("a"), Just(Nil)) mustEqual Just((1, "a", Nil))
  }

  @Test
  def lazyOption(): Unit = {
    import _root_.scalaz.LazyOption
    import LazyOption.{lazyNone, lazySome}
    import _root_.scalaz.syntax.equal._
    import _root_.scalaz.std.AllInstances._

    LazyOptionApply.apply2(lazySome(1), lazySome(2))(_ + _) assert_=== lazySome(3)
    LazyOptionApply.tuple2[Int, Int](lazyNone, err) assert_=== lazyNone
    LazyOptionApply.apply3[Int, String, List[Int], Int](lazyNone, err, lazyNone)((a, b, c) => 9) assert_=== lazyNone
    LazyOptionApply.tuple3(lazySome(1), lazySome("a"), lazySome(List(8))) assert_=== lazySome((1, "a", List(8)))
  }

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
