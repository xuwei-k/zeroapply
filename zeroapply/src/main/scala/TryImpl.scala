package zeroapply

import scala.reflect.macros.blackbox.Context

final class TryImpl(override val c: Context) extends OptionBase {
  import c.universe._

  override protected def getValDef(name: TermName, tpe: Type, body: Tree): Tree =
    q"""
    val $name: _root_.scala.util.Try[$tpe] = try {
      $body
    } catch {
      case _root_.scala.util.control.NonFatal(e) =>
        _root_.scala.util.Failure(e)
    }
    """

  override protected def getValue(value: Tree, tpe: Type): Tree =
    q"$value.get"

  override protected def none(value: Tree): Tree =
    q"$value.asInstanceOf[_root_.scala.util.Try[Nothing]]"

  /**
   * @see [[https://github.com/scala/scala/blob/v2.11.2/src/library/scala/util/Try.scala#L186-L193]]
   */
  override protected def wrapSome(value: Tree): Tree =
    q"""
    try _root_.scala.util.Success($value) catch {
      case _root_.scala.util.control.NonFatal(e) =>
        _root_.scala.util.Failure(e)
    }
    """

  override protected def isEmpty(value: Tree): Tree =
    q"$value.isFailure"
}
