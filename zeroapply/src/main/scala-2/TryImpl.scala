package zeroapply

import scala.reflect.macros.blackbox.Context

final class TryImpl(override val c: Context) extends OptionBase {
  import c.universe._

  override protected def getValDef(name: TermName, tpe: Type, body: Tree): Tree = {
    val e = TermName(c.freshName("e"))
    q"""
    val $name: _root_.scala.util.Try[$tpe] = try {
      $body
    } catch {
      case _root_.scala.util.control.NonFatal($e) =>
        _root_.scala.util.Failure($e)
    }
    """
  }

  override protected def getValue(value: Tree, tpe: Type): Tree =
    q"$value.get"

  override protected def none(value: Tree): Tree =
    q"$value.asInstanceOf[_root_.scala.util.Try[Nothing]]"

  /**
   * @see [[https://github.com/scala/scala/blob/v2.11.8/src/library/scala/util/Try.scala#L187-L194]]
   */
  override protected def wrapSome(value: Tree): Tree = {
    val e = TermName(c.freshName("e"))
    q"""
    try _root_.scala.util.Success($value) catch {
      case _root_.scala.util.control.NonFatal($e) =>
        _root_.scala.util.Failure($e)
    }
    """
  }

  override protected def isEmpty(value: Tree): Tree =
    q"$value.isFailure"
}
