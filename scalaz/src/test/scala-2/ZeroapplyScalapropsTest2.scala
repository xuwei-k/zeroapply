package zeroapply

import scalaprops._
import scalaprops.Property.forAll
import scalaprops.ScalapropsScalaz._
import scalaz.{\/, Apply, Equal, Maybe}
import scalaz.std.list._
import scalaz.std.anyVal._
import scalaz.std.string._
import scalaz.std.tuple._

object ZeroapplyScalapropsTest2 extends Scalaprops {
  private[this] implicit val stringGen: Gen[String] = Gen.asciiString

  private implicit class AssertOps[A](private val a1: A) extends AnyVal {
    def mustEqual(a2: A)(implicit A: Equal[A]): Boolean = {
      val result = A.equal(a1, a2)
      assert(result, s"$a1 is not equals $a2")
      result
    }
  }

  type ValidationNenInt[A] = scalaz.ValidationNel[Int, A]

  val validationNel = forAll { (a1: ValidationNenInt[Int], a2: ValidationNenInt[String], a3: ValidationNenInt[Maybe[Int]]) =>
    ValidationNelApply.tuple3(a1, a2, a3) mustEqual Apply[ValidationNenInt].tuple3(a1, a2, a3)
    ValidationNelApply.apply3(a1, a2, a3)(Tuple3.apply) mustEqual Apply[ValidationNenInt].apply3(a1, a2, a3)(Tuple3.apply)
  }
}
