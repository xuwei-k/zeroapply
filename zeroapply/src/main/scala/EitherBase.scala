package zeroapply

abstract class EitherBase extends InlineUtil with Common with EitherBoilerplate {
  import c.universe._

  protected def getValDef(name: TermName, left: Type, right: Type, body: Tree): Tree

  protected def rightValue(value: Tree, left: Type, right: Type): Tree

  protected def wrapRight(value: Tree): Tree

  protected def asEither(value: Tree, left: Type, right: Tree): Tree

  override final def tupleN(params: List[Tree], types: List[Type], leftType: Type): Tree = {
    val f = tuple(params, types)
    val right = tupleType(params, types)
    impl(params, types, leftType, right, f, true)
  }

  override final def impl(params: List[Tree], types: List[Type], left: Type, right: Tree, f: Tree, isTuple: Boolean = false): Tree = {
    val valNamesAndParams = params.zipWithIndex.map {
      case (p, index) =>
        p -> TermName(c.freshName("x" + index))
    }

    val valList = (valNamesAndParams, types).zipped.map{
      case ((p, name), t) =>
        getValDef(name, left, t, p)
    }

    val valNames = valNamesAndParams.map(_._2)

    val block = if(isTuple){
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
        (v, t) => rightValue(q"$v", left, t)
      }
      inlineAndReset(q"$f(..$list)")
    }

    val tree = valList.foldRight(wrapRight(block)){
      case (valdef @ ValDef(_, name, _, _), ifRight) =>
        val ident = Ident(name)
        q"""
          $valdef
          if($ident.isLeft){
            ${asEither(ident, left, right)}
          }else{
            $ifRight
          }
        """
    }
    tree
  }
}
