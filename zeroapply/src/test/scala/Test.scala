package zeroapply

import org.junit.Assert.assertEquals
import org.junit.Test

final class ZeroApplyTest {
  private def err: Nothing = sys.error("undefined")

  implicit class AssertOps[A](private val a1: A) {
    def mustEqual(a2: A) = assertEquals(a1, a2)
  }

  @Test
  def utilTry(): Unit = {
    import scala.util.{Failure, Success, Try}
    TryApply.tuple2(Try(1), Try(2)) mustEqual Try((1, 2))
    TryApply.apply2(Success(1), Success(2))(_ + _) mustEqual Try(3)
    val e = new Throwable {}
    TryApply.apply2(Success(1), (throw e): Try[Int])(_ + _) mustEqual Failure(e)
    TryApply.apply2(Success(1), Failure(e): Try[Int])(_ + _) mustEqual Failure(e)
    TryApply.apply2(Success(1), Success(2))((_, _) => (throw e): Int) mustEqual Try(throw e)
  }

  @Test
  def either(): Unit = {
    val a = Right[Int, String]("a")
    val b = Right[Int, List[Int]](Nil)
    EitherApply.tuple2(a, b) mustEqual Right("a" -> Nil)
    EitherApply.apply2(a, b)((_, _) => Vector(9)) mustEqual Right(Vector(9))
    EitherApply.apply3(Right(1), Left("a"), err)(Tuple3.apply) mustEqual Left("a")
    EitherApply.apply3(Left(1), err, err)((_, _, _) => "") mustEqual Left(1)
    EitherApply.tuple3(Left("a"), err, err) mustEqual Left("a")
  }

  @Test
  def option(): Unit = {
    OptionApply.apply2(Option(1), Option(2))(_ + _) mustEqual Option(3)
    OptionApply.tuple2(None, err) mustEqual None
    OptionApply.apply3(None, err, None)((a, b, c) => 9) mustEqual None
    OptionApply.tuple3(Option(1), Option("a"), Option(Nil))
  }
}
