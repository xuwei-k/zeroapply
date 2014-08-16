package zeroapply

import scala.reflect.macros.blackbox.Context
import scala.language.experimental.macros

final class LazyOptionImpl (override val c: Context) extends OptionBase {
  import c.universe._

  override protected def getValDef(name: TermName, tpe: Type, body: Tree): Tree =
    q"val $name: _root_.scalaz.LazyOption[$tpe] = $body"

  override protected def getValue(value: Tree, tpe: Type): Tree =
    q"$value.toOption.get"

  override protected def none: Tree =
    q"_root_.scalaz.LazyOption.lazyNone"

  override protected def wrapSome(value: Tree): Tree =
    q"_root_.scalaz.LazyOption.lazySome($value)"
}
