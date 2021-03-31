object Boilerplate {
  final case class SourceCode(name: String, code: String, version: Int)

  private final class Gen(i: Int) {
    val t = (1 to i).map("A" + _)
    val a = (1 to i).map("a" + _)
    val x = a.indices.map { i => s"x${i + 1}" }
    val ts = t.mkString(", ")
    val tparams = t.map(_ + ": W").mkString(", ")
    val paramsF = (a, t).zipped.map((x, y) => x + ": F[" + y + "]").mkString(", ")
    val inlineParamsF = (a, t).zipped.map((x, y) => s"${x}: F[${y}]").mkString(", inline ")
    val paramsFL = (a, t).zipped.map((x, y) => x + ": F[L, " + y + "]").mkString(", ")
    val inlineParamsFL = (a, t).zipped.map((x, y) => s"${x}: F[L, ${y}]").mkString(", inline ")
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

  private def optionScala3NoInline(objectName: String, classRename: String, n: Int): SourceCode = {
    def gen(i: Int) = {
      val g = new Gen(i)
      import g._
      s"""
  final def apply[$ts, Z]($paramsF)(f: ($ts) => Z): F[Z] =
    apply$i[$ts, Z](${a.mkString(", ")})(f)

  final def apply$i[$ts, Z]($paramsF)(f: ($ts) => Z): F[Z] =
    for { ${a.zipWithIndex.map { case (a, i) => s"x${i + 1} <- $a" }.mkString("; ")} } yield f(${(1 to i).map("x" + _).mkString(", ")})

  final def tuple[$ts]($paramsF): F[($ts)] =
    tuple$i[$ts](${a.mkString(", ")})

  final def tuple$i[$ts]($paramsF): F[($ts)] =
    apply$i(${a.mkString(", ")})(Tuple$i.apply)"""
    }

    val code = s"""package zeroapply

object $objectName {

  import $classRename => F}

${(2 to n).map(gen).mkString("\n")}
}
"""

    SourceCode(objectName, code, 3)
  }

  private def indent(s: String): String = s.linesIterator.map("  " + _).mkString("", "\n", "")

  private def optionScala3(objectName: String, classRename: String, n: Int, some: String, none: String, get: String => String): SourceCode = {
    def gen(i: Int) = {
      val g = new Gen(i)
      import g._

      val last = s"${some}(f(${x.zip(t).map { case (a, t) => a + get(t) }.mkString(", ")}))"
      val impl = x
        .zip(a)
        .foldRight(last) { case ((x, aa), acc) =>
          indent(s"""
val ${x} = ${aa}
if (${x}.isEmpty) {
  ${none}
} else {
  ${acc}
}""")
        }
        .linesIterator
        .filter(_.trim.nonEmpty)
        .mkString("\n")
      s"""
  inline def apply[$ts, Z]($inlineParamsF)(inline f: ($ts) => Z): F[Z] =
    apply$i[$ts, Z](${a.mkString(", ")})(f)

  inline def apply$i[$ts, Z]($inlineParamsF)(inline f: ($ts) => Z): F[Z] = {
${indent(impl)}
  }

  inline def tuple[$ts]($inlineParamsF): F[($ts)] =
    tuple$i[$ts](${a.mkString(", ")})

  inline def tuple$i[$ts]($inlineParamsF): F[($ts)] =
    apply$i(${a.mkString(", ")})(Tuple$i.apply)"""
    }

    val code = s"""package zeroapply

object $objectName {

  import $classRename => F}

${(2 to n).map(gen).mkString("\n")}
}
"""

    SourceCode(objectName, code, 3)
  }

  private def optionScala2(objectName: String, classRename: String, impl: String, n: Int): SourceCode = {
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

    SourceCode(objectName, code, 2)
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

  private def eitherScala3(
    objectName: String,
    classRename: String,
    n: Int,
    wrapRight: String,
    get: String => String
  ): SourceCode = {
    def gen(i: Int) = {
      val g = new Gen(i)
      import g._

      val last = s"${wrapRight}(f(${x.zip(t).map { case (a, t) => a + get(t) }.mkString(", ")}))"
      val impl = indent(
        x.zip(a)
          .foldRight(last) { case ((xx, aa), acc) =>
            indent(s"""
val ${xx} = ${aa}
if (${xx}.isLeft) {
  ${xx}.asInstanceOf[F[L, Z]]
} else {
  ${acc}
}""")
          }
          .linesIterator
          .filter(_.trim.nonEmpty)
          .mkString("\n")
      )

      s"""
  inline def apply[$ts, L, Z]($inlineParamsFL)(f: ($ts) => Z): F[L, Z] =
    apply$i[$ts, L, Z](${a.mkString(", ")})(f)

  inline def apply$i[$ts, L, Z]($inlineParamsFL)(f: ($ts) => Z): F[L, Z] = {
${impl}
  }

  inline def tuple[$ts, L]($inlineParamsFL): F[L, ($ts)]=
    tuple$i(${a.mkString(", ")})

  inline def tuple$i[$ts, L]($inlineParamsFL): F[L, ($ts)]=
    apply$i(${a.mkString(", ")})(Tuple$i.apply)"""
    }

    val code = s"""package zeroapply

object $objectName {

  import $classRename => F}

${(2 to n).map(gen).mkString("\n")}
}
"""
    SourceCode(objectName, code, 3)
  }

  private def eitherScala2(objectName: String, classRename: String, impl: String, n: Int): SourceCode = {
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
    SourceCode(objectName, code, 2)
  }

  def scalaz(n: Int): List[SourceCode] =
    List(
      optionScala2("MaybeApply", "scalaz.{Maybe", "MaybeImpl", n),
      optionScala2("LazyOptionApply", "scalaz.{LazyOption", "LazyOptionImpl", n),
      optionScala3("MaybeApply", "scalaz.{Maybe", n, "scalaz.Maybe.just", "scalaz.Maybe.empty", t => s".asInstanceOf[scalaz.Maybe.Just[$t]].get"),
      optionScala3("LazyOptionApply", "scalaz.{LazyOption", n, "scalaz.LazyOption.lazySome", "scalaz.LazyOption.lazyNone", _ => ".toOption.get"),
      eitherScala2("DisjunctionApply", """scalaz.{\/""", "DisjunctionImpl", n),
      eitherScala2("LazyEitherApply", """scalaz.{LazyEither""", "LazyEitherImpl", n),
      eitherScala2("ValidationNelApply", """scalaz.{ValidationNel""", "ValidationNelImpl", n),
      eitherScala3("DisjunctionApply", """scalaz.{\/""", n, "scalaz.\\/-", t => s".asInstanceOf[scalaz.\\/-[L, $t]].b"),
      eitherScala3("LazyEitherApply", """scalaz.{LazyEither""", n, "scalaz.LazyEither.lazyRight", _ => s".toOption.get"),
    )

  def zeroapply(n: Int): List[SourceCode] =
    List(
      SourceCode("OptionBoilerplate", optionBoilerplate(n), 2),
      SourceCode("EitherBoilerplate", eitherBoilerplate(n), 2),
      optionScala3("OptionApply", "scala.{Option", n, "Some", "None", _ => ".get"),
      optionScala3NoInline("TryApply", "scala.util.{Try", n),
      eitherScala3("EitherApply", "scala.{Either", n, "Right", t => s".asInstanceOf[Right[L, $t]].value"),
      optionScala2("OptionApply", "scala.{Option", "OptionImpl", n),
      optionScala2("TryApply", "scala.util.{Try", "TryImpl", n),
      eitherScala2("EitherApply", "scala.{Either", "EitherImpl", n),
    )
}
