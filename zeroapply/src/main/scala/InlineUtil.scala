package zeroapply

import scala.reflect.macros.blackbox.Context

/**
 * [[https://github.com/non/spire/blob/v0.8.2/macros/src/main/scala/spire/macros/Syntax.scala#L25-L71]]
 */
abstract class InlineUtil {
  val c: Context
  import c.universe._

  protected final def inlineAndReset(tree: Tree): Tree = {
    val inlined = inlineApplyRecursive(tree)
    c.untypecheck(inlined)
  }

  protected final def inlineApplyRecursive(tree: Tree): Tree = {
    import c.universe._
    val ApplyName = TermName("apply")

    class InlineSymbol(symbol: Symbol, value: Tree) extends Transformer {
      override def transform(tree: Tree): Tree = tree match {
        case Ident(_) if tree.symbol == symbol =>
          value
        case tt: TypeTree if tt.original != null =>
          super.transform(c.universe.internal.setOriginal(TypeTree(), transform(tt.original)))
        case _ =>
          super.transform(tree)
      }
    }

    object InlineApply extends Transformer {
      def inlineSymbol(symbol: Symbol, body: Tree, arg: Tree): Tree =
        new InlineSymbol(symbol, arg).transform(body)

      override def transform(tree: Tree): Tree = tree match {
        case Apply(Select(Function(params, body), ApplyName), args) =>
          params.zip(args).foldLeft(body) {
            case (b, (param, arg)) =>
              inlineSymbol(param.symbol, b, arg)
          }

        case Apply(Function(params, body), args) =>
          params.zip(args).foldLeft(body) {
            case (b, (param, arg)) =>
              inlineSymbol(param.symbol, b, arg)
          }

        case _ =>
          super.transform(tree)
      }
    }

    InlineApply.transform(tree)
  }
}
