package zeroapply

import scala.reflect.macros.blackbox

class CaseClassImpl(val c: blackbox.Context) {
  import c.universe._

  def equalImpl[Z: c.WeakTypeTag]: c.Tree = {
    val Z = weakTypeOf[Z]
    val x1, x2 = TermName(c.freshName("x"))
    val fields = Z.decls.filter { m => m.isTerm && m.asTerm.isCaseAccessor && m.isMethod }

    q"""new _root_.scalaz.Equal[$Z]{
      ${isNatural(fields, Z)}
      ${equalDef(x1, x2, fields, Z)}
    }"""
  }

  private def equalDef(x1: c.TermName, x2: c.TermName, fields: Iterable[c.Symbol], Z: c.Type) = {
    val body = fields.map { m =>
      val t = q"_root_.scalaz.Equal[${m.typeSignatureIn(Z)}]"
      q"$t.equal(${Select(Ident(x1), m.name)}, ${Select(Ident(x2), m.name)})"
    }.reduceLeft((t1, t2) => q"$t1 && $t2")
    q"override def equal($x1: $Z, $x2: $Z) = $body"
  }

  private def isNatural(fields: Iterable[c.Symbol], Z: c.Type) = {
    val body = fields.map { m => q"_root_.scalaz.Equal[${m.typeSignatureIn(Z)}].equalIsNatural" }.reduceLeft[c.universe.Tree]((t1, t2) =>
      q"$t1 && $t2"
    )
    q"override def equalIsNatural = $body"
  }

  def orderImpl[Z: c.WeakTypeTag]: c.Tree = {
    val Z = weakTypeOf[Z]
    val x1, x2 = TermName(c.freshName("x"))
    val fields = Z.decls.filter { m => m.isTerm && m.asTerm.isCaseAccessor && m.isMethod }

    val last: Tree = {
      val m = fields.last
      val t = q"_root_.scalaz.Order[${m.typeSignatureIn(Z)}]"
      q"$t.order(${Select(Ident(x1), m.name)}, ${Select(Ident(x2), m.name)})"
    }

    val order = (fields.init, Stream.continually(TermName(c.freshName("x")))).zipped.foldRight(last) {
      case ((m, other), acc) =>
        val t = q"_root_.scalaz.Order[${m.typeSignatureIn(Z)}]"

        q"""
          $t.order(${Select(Ident(x1), m.name)}, ${Select(Ident(x2), m.name)}) match {
            case _root_.scalaz.Ordering.EQ => $acc
            case $other => $other
          }
        """
    }

    q"""new _root_.scalaz.Order[$Z]{
      ${isNatural(fields, Z)}
      ${equalDef(x1, x2, fields, Z)}
      override def order($x1: $Z, $x2: $Z) = $order
    }"""
  }
}
