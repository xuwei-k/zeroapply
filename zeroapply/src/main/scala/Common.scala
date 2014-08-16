package zeroapply

import scala.reflect.macros.blackbox.Context

trait Common {
  val c: Context
  import c.universe._
  import Flag.PARAM

  final type W[A] = c.WeakTypeTag[A]
  protected final def w[A](implicit W: W[A]): Type = W.tpe

  protected final def tupleType(params: List[Tree], types: List[Type]): Tree = {
    AppliedTypeTree(
      Select(
        Ident(TermName("scala")), TypeName("Tuple" + params.size)),
      types.map(TypeTree(_)))
  }

  protected final def tuple(params: List[Tree], types: List[Type]): Tree = {
    val names = (0 until params.size).map(i => TermName(c.freshName("p" + i))).toList
    Function(
      names.zipWithIndex.map{ case (name, i)  =>
        val t = TypeTree(types(i))
        ValDef(
          Modifiers(PARAM), name, t, EmptyTree)
      },
      Apply(
        Select(
          Ident(TermName("Tuple" + params.size)), TermName("apply")),
          names.map(n => Ident(n))))
  }
}
