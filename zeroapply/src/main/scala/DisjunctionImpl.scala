package zeroapply

import scala.reflect.macros.blackbox.Context

final class DisjunctionImpl(override val c: Context) extends EitherBase {
  import c.universe._

  override protected def getValDef(name: TermName, left: Type, right: Type, body: Tree) =
    q"""val $name: _root_.scalaz.\/[$left, $right] = $body"""

  override protected def wrapRight(value: Tree) =
    q"""_root_.scalaz.\/-($value)"""

  override protected def rightValue(value: Tree, left: Type, right: Type) =
    q"""$value.asInstanceOf[_root_.scalaz.\/-[$right]].b"""

  override protected def asEither(value: Tree, left: Type, right: Tree) =
    q"""$value.asInstanceOf[_root_.scalaz.\/[$left, $right]]"""
}
