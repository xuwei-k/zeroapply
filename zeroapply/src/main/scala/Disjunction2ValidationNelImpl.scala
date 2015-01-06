package zeroapply

import scala.reflect.macros.blackbox.Context

final class Disjunction2ValidationNelImpl(override val c: Context) extends EitherBase {
  import c.universe._

  protected def getValDef(name: TermName, left: Type, right: Type, body: Tree) =
    ???

  protected def rightValue(value: Tree, left: Type, right: Type): Tree =
    q"$value.asInstanceOf[_root_.scalaz.\/-[$right]].b"

  protected def wrapRight(value: Tree): Tree =
    ???

  protected def asEither(value: Tree, left: Type, right: Tree): Tree =
    ???

  override def impl(params: List[Tree], types: List[Type], left: Type, right: Tree, f: Tree, isTuple: Boolean = false): Tree = {
    val valNamesAndParams = params.zipWithIndex.map {
      case (p, index) =>
        p -> TermName(c.freshName("x" + index))
    }

    val valList = (valNamesAndParams, types).zipped.map{
      case ((p, name), t) =>
        q"val $name: _root_.scalaz.\/[$left, $t] = $p"
    }

    val valNames = valNamesAndParams.map(_._2)
    val failure = TermName(c.freshName("failure"))

    val ifSuccess = if(isTuple){
      f match {
        case Function(fparams, body) =>
          val newParams = (fparams, valNames, types).zipped.map { case (p, name, r) =>
            val b = q"${Ident(name)}"
            ValDef(p.mods, p.name, TypeTree(p.tpe), rightValue(b, left, r))
          }
          Block(newParams, q"$body")
        case other => other
      }
    }else{
      val list = (valNames, types).zipped.map{
        (name, tpe) => rightValue(q"$name", left, tpe)
      }
      inlineAndReset(q"$f(..$list)")
    }

    val tree = q"""
      ..$valList

      var $failure : List[$left] = Nil

      ..${valNames.reverse.map{ case name =>
        q"""
          if($name.isInstanceOf[_root_.scalaz.-\/[_]]){
            $failure ::= $name.asInstanceOf[_root_.scalaz.-\/[$left]].a
          }
        """
      }}

      if($failure eq Nil){
        _root_.scalaz.Success($ifSuccess)
      }else{
        _root_.scalaz.Failure(_root_.scalaz.NonEmptyList.nel($failure.head, $failure.tail))
      }
    """
    tree
  }
}
