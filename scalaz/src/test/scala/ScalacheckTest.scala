package zeroapply

import org.scalacheck.{Prop, Properties}
import scalaz.{Equal, Maybe, Apply, \/, LazyOption, LazyEither, IList}
import scalaz.std.list._
import scalaz.std.anyVal._
import scalaz.std.string._
import scalaz.scalacheck.ScalazArbitrary._
import scalaz.std.tuple._

object ScalacheckTest extends Properties("zeroapply") {

  private implicit class AssertOps[A](private val a1: A) extends AnyVal{
    def mustEqual(a2: A)(implicit A: Equal[A]): Boolean = {
      val result = A.equal(a1, a2)
      assert(result, s"$a1 is not equals $a2")
      result
    }
  }

  property("Option") = Prop.forAll{
    (a1: Option[Int], a2: Option[String], a3: Option[List[Int]]) =>

    import scalaz.std.option._

    OptionApply.tuple3(a1, a2, a3) mustEqual Apply[Option].tuple3(a1, a2, a3)
    OptionApply.apply3(a1, a2, a3)(Tuple3.apply) mustEqual Apply[Option].apply3(a1, a2, a3)(Tuple3.apply)
  }

  property("LazyOption") = Prop.forAll{
    (a1: LazyOption[String], a2: LazyOption[Int], a3: LazyOption[Int \/ Byte]) =>

    LazyOptionApply.tuple3(a1, a2, a3) mustEqual Apply[LazyOption].tuple3(a1, a2, a3)
    LazyOptionApply.apply3(a1, a2, a3)(Tuple3.apply) mustEqual Apply[LazyOption].apply3(a1, a2, a3)(Tuple3.apply)
  }

  property("Maybe") = Prop.forAll{
    (a1: Maybe[Int], a2: Maybe[String], a3: Maybe[List[Int]]) =>

    MaybeApply.tuple3(a1, a2, a3) mustEqual Apply[Maybe].tuple3(a1, a2, a3)
    MaybeApply.apply3(a1, a2, a3)(Tuple3.apply) mustEqual Apply[Maybe].apply3(a1, a2, a3)(Tuple3.apply)
  }

  type EitherInt[A] = Either[Int, A]

  property("Either") = Prop.forAll{
    (a1: EitherInt[Int], a2: EitherInt[String], a3: EitherInt[List[Int]]) =>

    import scalaz.std.either._

    EitherApply.tuple3(a1, a2, a3) mustEqual Apply[EitherInt].tuple3(a1, a2, a3)
    EitherApply.apply3(a1, a2, a3)(Tuple3.apply) mustEqual Apply[EitherInt].apply3(a1, a2, a3)(Tuple3.apply)
  }

  type LazyEitherInt[A] = LazyEither[Int, A]

  property("LazyEither") = Prop.forAll{
    (a1: LazyEitherInt[Int], a2: LazyEitherInt[String], a3: LazyEitherInt[IList[Byte]]) =>

    implicit def lazyEitherEq[A: Equal, B: Equal]: Equal[LazyEither[A, B]] =
      Equal.equalBy(_.disjunction)

    LazyEitherApply.tuple3(a1, a2, a3) mustEqual Apply[LazyEitherInt].tuple3(a1, a2, a3)
    LazyEitherApply.apply3(a1, a2, a3)(Tuple3.apply) mustEqual Apply[LazyEitherInt].apply3(a1, a2, a3)(Tuple3.apply)
  }

  type DisjunctionInt[A] = Int \/ A

  property("""\/""") = Prop.forAll{
    (a1: DisjunctionInt[Int], a2: DisjunctionInt[String], a3: DisjunctionInt[List[Int]]) =>

    DisjunctionApply.tuple3(a1, a2, a3) mustEqual Apply[DisjunctionInt].tuple3(a1, a2, a3)
    DisjunctionApply.apply3(a1, a2, a3)(Tuple3.apply) mustEqual Apply[DisjunctionInt].apply3(a1, a2, a3)(Tuple3.apply)
  }

  type ValidationNenInt[A] = scalaz.ValidationNel[Int, A]

  property("ValidationNel") = Prop.forAll {
    (a1: ValidationNenInt[Int], a2: ValidationNenInt[String], a3: ValidationNenInt[Maybe[Int]]) =>

    ValidationNelApply.tuple3(a1, a2, a3) mustEqual Apply[ValidationNenInt].tuple3(a1, a2, a3)
    ValidationNelApply.apply3(a1, a2, a3)(Tuple3.apply) mustEqual Apply[ValidationNenInt].apply3(a1, a2, a3)(Tuple3.apply)
  }
}
