package zeroapply

import scala.reflect.macros.blackbox.Context

final class EitherImpl(override val c: Context) extends EitherBase{
  import c.universe._

  override protected def getValDef(name: TermName, left: Type, right: Type, body: Tree) =
    q"""val $name: _root_.scala.Either[$left, $right] = $body"""

  override protected def wrapRight(value: Tree) =
    q"_root_.scala.Right($value)"

  override protected def rightValue(value: Tree, left: Type, right: Type) =
    q"$value.asInstanceOf[_root_.scala.Right[$left, $right]].b"

  override protected def asEither(value: Tree, left: Type, right: Tree) =
    q"$value.asInstanceOf[_root_.scala.Either[$left, $right]]"
}
