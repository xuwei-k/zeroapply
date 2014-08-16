package zeroapply

import scala.reflect.macros.blackbox.Context

final class OptionImpl(override val c: Context) extends OptionBase {
  import c.universe._

  override protected def getValDef(name: TermName, tpe: Type, body: Tree): Tree =
    q"val $name: _root_.scala.Option[$tpe] = $body"

  override protected def getValue(value: Tree, tpe: Type): Tree =
    q"$value.get"

  override protected def none: Tree =
    q"_root_.scala.None"

  override protected def wrapSome(value: Tree): Tree =
    q"_root_.scala.Some($value)"
}
