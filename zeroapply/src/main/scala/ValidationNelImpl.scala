package zeroapply

import scala.reflect.macros.blackbox.Context

final class ValidationNelImpl(override val c: Context) extends EitherBase {
  import c.universe._

  protected def getValDef(name: TermName, left: Type, right: Type, body: Tree) =
    q"val $name: _root_.scalaz.ValidationNel[$left, $right] = $body"

  protected def rightValue(value: Tree, left: Type, right: Type): Tree =
    q"$value.asInstanceOf[scalaz.Success[$right]].a"

  protected def wrapRight(value: Tree): Tree =
    q"_root_.scalaz.Success($value)"

  protected def asEither(value: Tree, left: Type, right: Tree): Tree =
    ???

  override def impl(params: List[Tree], types: List[Type], left: Type, right: Tree, f: Tree, isTuple: Boolean = false): Tree = {
    val valNamesAndParams = params.zipWithIndex.map {
      case (p, index) =>
        p -> TermName(c.freshName("x" + index))
    }

    val valList = (valNamesAndParams, types).zipped.map {
      case ((p, name), t) =>
        getValDef(name, left, t, p)
    }

    val valNames = valNamesAndParams.map(_._2)
    val failure = TermName(c.freshName("failure"))

    val ifSuccess = if (isTuple) {
      f match {
        case Function(fparams, body) =>
          val newParams = (fparams, valNames, types).zipped.map {
            case (p, name, r) =>
              val b = q"${Ident(name)}"
              ValDef(p.mods, p.name, TypeTree(p.tpe), rightValue(b, left, r))
          }
          Block(newParams, q"$body")
        case other => other
      }
    } else {
      val list = (valNames, types).zipped.map { (name, tpe) =>
        rightValue(q"$name", left, tpe)
      }
      inlineAndReset(q"$f(..$list)")
    }

    val tree = q"""
      ..$valList

      var $failure : _root_.scalaz.IList[$left] = _root_.scalaz.IList.empty[$left]

      ..${valNames.reverse.map {
      case name =>
        q"""
          if($name.isInstanceOf[_root_.scalaz.Failure[_]]){
            val nel = $name.asInstanceOf[_root_.scalaz.Failure[_root_.scalaz.NonEmptyList[$left]]].e
            $failure :::= nel.tail
            $failure ::= nel.head
          }
        """
    }}

      $failure match {
        case _root_.scalaz.INil() =>
          ${wrapRight(ifSuccess)}
        case  _root_.scalaz.ICons(h, t) =>
          _root_.scalaz.Failure(_root_.scalaz.NonEmptyList.nel(h, t))
      }
    """
    tree
  }
}
