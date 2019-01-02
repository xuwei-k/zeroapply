package zeroapply

import org.junit.Assert.assertEquals
import org.junit.Test
import scala.util.Try
import scalaz._
import scalaz.syntax.validation._

final class InlineTest {

  private[this] val expectClassName = getClass().getName

  private[this] def check(message: String, stackTrace: Array[StackTraceElement], index: Int, method: String) = {
    val first = stackTrace.head
    assertEquals(message, classOf[Thread].getName, first.getClassName)
    assertEquals(message, "getStackTrace", first.getMethodName)

    val actualStack = stackTrace(index)
    assertEquals(message, expectClassName, actualStack.getClassName)
    assertEquals(message, method, actualStack.getMethodName)
  }

  @Test
  def test1(): Unit = {
    val thread = Thread.currentThread
    import thread.getStackTrace

    val option = OptionApply.apply2(Option(1), Option("a"))((a, b) => getStackTrace).get
    val either = EitherApply.apply2(Right(1), Right("a"))((a, b) => getStackTrace).right.get
    val utilTry = TryApply.apply2(Try(1), Try("a"))((a, b) => getStackTrace).get
    val disjunction = DisjunctionApply.apply2(\/-(1), \/-("a"))((a, b) => getStackTrace).getOrElse(null)
    val maybe = MaybeApply.apply2(Maybe.just(1), Maybe.just("a"))((a, b) => getStackTrace).getOrElse(null)
    val validationNel = ValidationNelApply.apply2(1.successNel[Int], "a".successNel[Int])((a, b) => getStackTrace).getOrElse(null)

    List(
      option,
      either,
      utilTry,
      disjunction,
      maybe,
      validationNel
    ).foreach { stackTrace =>
      check(stackTrace.take(10).mkString("\n"), stackTrace, 1, "test1")
    }
  }

}
