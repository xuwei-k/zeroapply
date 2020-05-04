object Boilerplate {
  final case class SourceCode(name: String, code: String)

  private final class Gen(i: Int) {
    val t = (1 to i).map("A" + _)
    val a = (1 to i).map("a" + _)
    val ts = t.mkString(", ")
    val tparams = t.map(_ + ": W").mkString(", ")
    val paramsF = (a, t).zipped.map((x, y) => x + ": F[" + y + "]").mkString(", ")
    val paramsFL = (a, t).zipped.map((x, y) => x + ": F[L, " + y + "]").mkString(", ")
    val params0 = a.map(_ + ": Tree").mkString(", ")
    val params1 = (a :+ "Nil").mkString(" :: ")
    val params2 = (t.map("w[" + _ + "]") :+ "Nil").mkString(" :: ")
  }

  private def optionBoilerplate(n: Int): String = {
    def gen(i: Int) = {
      val g = new Gen(i)
      import g._
      s"""
  final def apply$i[$tparams, Z: W]($params0)(f: Tree): Tree =
    impl($params1, $params2, f, TypeTree(w[Z]))

  final def tuple$i[$tparams]($params0): Tree =
    tupleN($params1, $params2)"""
    }

    s"""package zeroapply

trait OptionBoilerplate extends Common{
  import c.universe._

  def tupleN(params: List[Tree], types: List[Type]): Tree

  def impl(params: List[Tree], types: List[Type], f: Tree, result: Tree, isTuple: Boolean = false): Tree

${(2 to n).map(gen).mkString("\n")}
}
"""
  }

  private def option(objectName: String, classRename: String, impl: String, n: Int): SourceCode = {
    def gen(i: Int) = {
      val g = new Gen(i)
      import g._
      s"""
  final def apply[$ts, Z]($paramsF)(f: ($ts) => Z): F[Z] =
    macro Impl.apply$i[$ts, Z]

  final def apply$i[$ts, Z]($paramsF)(f: ($ts) => Z): F[Z] =
    macro Impl.apply$i[$ts, Z]

  final def tuple[$ts]($paramsF): F[($ts)] =
    macro Impl.tuple$i[$ts]

  final def tuple$i[$ts]($paramsF): F[($ts)] =
    macro Impl.tuple$i[$ts]"""
    }

    val code = s"""package zeroapply

import scala.language.experimental.macros

object $objectName {

  import zeroapply.{$impl => Impl}
  import $classRename => F}

${(2 to n).map(gen).mkString("\n")}
}
"""

    SourceCode(objectName, code)
  }

  private def eitherBoilerplate(n: Int): String = {
    def gen(i: Int) = {
      val g = new Gen(i)
      import g._
      s"""
  final def apply$i[$tparams, L: W, Z: W]($params0)(f: Tree): Tree =
    impl($params1, $params2, w[L], TypeTree(w[Z]), f)

  final def tuple$i[$tparams, L: W]($params0): Tree =
    tupleN($params1, $params2, w[L])"""
    }

    s"""package zeroapply

trait EitherBoilerplate extends Common{
  import c.universe._

  def tupleN(params: List[Tree], types: List[Type], leftType: Type): Tree

  def impl(params: List[Tree], types: List[Type], left: Type, right: Tree, f: Tree, isTuple: Boolean = false): Tree


${(2 to n).map(gen).mkString("\n")}
}
"""
  }

  private def either(objectName: String, classRename: String, impl: String, n: Int): SourceCode = {
    def gen(i: Int) = {
      val g = new Gen(i)
      import g._
      s"""
  final def apply[$ts, L, Z]($paramsFL)(f: ($ts) => Z): F[L, Z] =
    macro Impl.apply$i[$ts, L, Z]

  final def apply$i[$ts, L, Z]($paramsFL)(f: ($ts) => Z): F[L, Z] =
    macro Impl.apply$i[$ts, L, Z]

  final def tuple[${t.mkString(", ")}, L]($paramsFL): F[L, ($ts)]=
    macro Impl.tuple$i[$ts, L]

  final def tuple$i[${t.mkString(", ")}, L]($paramsFL): F[L, ($ts)]=
    macro Impl.tuple$i[$ts, L]"""
    }

    val code = s"""package zeroapply

import scala.language.experimental.macros

object $objectName {

  import zeroapply.{$impl => Impl}
  import $classRename => F}

${(2 to n).map(gen).mkString("\n")}
}
"""
    SourceCode(objectName, code)
  }

  def scalaz(n: Int): List[SourceCode] =
    List(
      option("MaybeApply", "scalaz.{Maybe", "MaybeImpl", n),
      option("LazyOptionApply", "scalaz.{LazyOption", "LazyOptionImpl", n),
      either("DisjunctionApply", """scalaz.{\/""", "DisjunctionImpl", n),
      either("LazyEitherApply", """scalaz.{LazyEither""", "LazyEitherImpl", n),
      either("ValidationNelApply", """scalaz.{ValidationNel""", "ValidationNelImpl", n),
    )

  def zeroapply(n: Int): List[SourceCode] =
    List(
      SourceCode("OptionBoilerplate", optionBoilerplate(n)),
      SourceCode("EitherBoilerplate", eitherBoilerplate(n)),
      option("OptionApply", "scala.{Option", "OptionImpl", n),
      option("TryApply", "scala.util.{Try", "TryImpl", n),
      either("EitherApply", "scala.{Either", "EitherImpl", n),
    )
}
