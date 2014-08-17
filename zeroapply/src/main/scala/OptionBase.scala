package zeroapply

abstract class OptionBase extends InlineUtil with OptionBoilerplate{
  import c.universe._

  override final def tupleN(params: List[Tree], types: List[Type]): Tree =
    impl(params, types, tuple(params, types), tupleType(params, types), true)

  protected def getValDef(name: TermName, tpe: Type, body: Tree): Tree

  protected def getValue(value: Tree, tpe: Type): Tree

  protected def wrapSome(value: Tree): Tree

  protected def none(value: Tree): Tree

  protected def isEmpty(value: Tree): Tree

  override final def impl(params: List[Tree], types: List[Type], f: Tree, result: Tree, isTuple: Boolean = false): Tree = {
    val valNamesAndParams = params.zipWithIndex.map {
      case (p, index) =>
        p -> TermName(c.freshName("x" + index))
    }

    val valList = (valNamesAndParams, types).zipped.map{
      case ((p, name), t) =>
        getValDef(name, t, p)
    }

    val valNames = valNamesAndParams.map(_._2)

    val block = if(isTuple){
      f match {
        case Function(fparams, body) =>
          val newParams = (fparams, valNames, types).zipped.map{ (p, name, t) =>
            val b = Ident(name)
            ValDef(p.mods, p.name, TypeTree(p.tpe), getValue(b, t))
          }
          Block(newParams, q"$body")
        case other => other
      }
    }else{
      val list = (valNames, types).zipped.map{
        (v, t) => getValue(q"$v", t)
      }
      inlineAndReset(q"$f(..$list)")
    }

    val tree = valList.foldRight(wrapSome(block)){
      case (valdef @ ValDef(_, name, _, _), ifNonEmpty) =>
        val ident = Ident(name)
        q"""
          $valdef
          if(${isEmpty(ident)}){
            ${none(ident)}
          }else{
            $ifNonEmpty
          }
        """
    }
    tree
  }
}
