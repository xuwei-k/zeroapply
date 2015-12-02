package zeroapply

import scala.annotation.tailrec
import scala.reflect.macros.blackbox

object PlayJson {
  type Key = playjson.JsonKey @annotation.meta.field
}

class CaseClassImpl(val c: blackbox.Context) {

  import c.universe._

  private def fieldsOf(tpe: Type): Map[TermSymbol, (String, Type)] = {
    val explicitLabels = tpe.decls.flatMap { sym =>
      for {
        a <- sym.annotations.find(_.tree.tpe =:= typeOf[PlayJson.Key])
      } yield {
        val label = a.tree.children.collectFirst {
          case Literal(Constant(value: String)) => value
        }.getOrElse {
          c.abort(c.enclosingPosition, s"$tpe.${sym.name} has a @Key annotation, but the argument is not a constant String")
        }
        (sym.fullName, label)
      }
    }.toMap

    tpe.decls.collect {
      case m: TermSymbol =>
        explicitLabels.get(m.fullName).map(_ -> m)
    }.flatten.map{ case (name, sym) =>
      sym -> ((name, sym.typeSignatureIn(tpe).finalResultType))
    }.toMap
  }

  private val ReadsApplicative = q"_root_.play.api.libs.functional.syntax.functionalCanBuildApplicative[_root_.play.api.libs.json.Reads]"
  private val ReadsObj = q"_root_.play.api.libs.json.Reads"
  private val JsPath = q"_root_.play.api.libs.json.JsPath"
  private val Extractor = q"_root_.play.api.libs.functional.~"

  def reads[A: c.WeakTypeTag]: c.Tree = {
    val A = weakTypeOf[A]
    val fields = A.decls.filter { m => m.isTerm && m.asTerm.isCaseAccessor && m.isMethod }
    val x = fieldsOf(A)
    val y = fields.map{ f =>
      f -> x.getOrElse(f.asTerm, c.abort(c.enclosingPosition, s"the `${f.asTerm.name}` field does not have @Key annotation"))
    }.toList

    @tailrec
    def checkDuplicates(list: List[String], set: Set[String]): Unit = list match {
      case aa :: tail =>
        if(set.contains(aa)) {
          c.abort(c.enclosingPosition, s"duplicate keys `$aa`")
        } else {
          checkDuplicates(tail, set + aa)
        }
      case Nil =>
    }
    checkDuplicates(y.map(_._2._1), Set.empty)

    val z = y.map{ case (f, (key, t)) =>
      val s = Literal(Constant(key))
      t.typeArgs match {
        case tt :: Nil if t.typeConstructor =:= typeOf[Option[_]].typeConstructor =>
          q"""$ReadsObj.nullable[${t.typeArgs.head}]($JsPath \ $s)"""
        case _ =>
          q"""$ReadsObj.at[$t]($JsPath \ $s)"""
      }
    }

    val d = z.tail.foldLeft(z.head: c.Tree)((a, as) => q"$ReadsApplicative.apply($a, $as)")
    val xs = List.fill(fields.size)(TermName(c.freshName("x")))

    val a = pq"$Extractor(${xs(0)}, ${xs(1)})"
    val r = q"""$d.map{
      case ${xs.tail.tail.foldLeft(a)((s, t) => pq"$Extractor($s, $t)")} =>
        new $A(..$xs)
    }"""
    println(showCode(r))
    r
  }

  def equalImpl[Z: c.WeakTypeTag]: c.Tree = {
    val Z = weakTypeOf[Z]
    val x1, x2 = TermName(c.freshName("x"))
    val fields = Z.decls.filter { m => m.isTerm && m.asTerm.isCaseAccessor && m.isMethod }

    q"""new _root_.scalaz.Equal[$Z]{
      ${isNatural(fields, Z)}
      ${equalDef(x1, x2, fields, Z)}
    }"""
  }

  private def equalDef(x1: c.TermName, x2: c.TermName, fields: Iterable[c.Symbol], Z: c.Type) = {
    val body = fields.map { m =>
      val t = q"_root_.scalaz.Equal[${m.typeSignatureIn(Z)}]"
      q"$t.equal(${Select(Ident(x1), m.name)}, ${Select(Ident(x2), m.name)})"
    }.reduceLeft((t1, t2) => q"$t1 && $t2")
    q"override def equal($x1: $Z, $x2: $Z) = $body"
  }

  private def isNatural(fields: Iterable[c.Symbol], Z: c.Type) = {
    val body = fields.map { m =>
      q"_root_.scalaz.Equal[${m.typeSignatureIn(Z)}].equalIsNatural"
    }.reduceLeft[c.universe.Tree]((t1, t2) => q"$t1 && $t2")
    q"override def equalIsNatural = $body"
  }

  def orderImpl[Z: c.WeakTypeTag]: c.Tree = {
    val Z = weakTypeOf[Z]
    val x1, x2 = TermName(c.freshName("x"))
    val fields = Z.decls.filter { m => m.isTerm && m.asTerm.isCaseAccessor && m.isMethod }

    val last: Tree = {
      val m = fields.last
      val t = q"_root_.scalaz.Order[${m.typeSignatureIn(Z)}]"
      q"$t.order(${Select(Ident(x1), m.name)}, ${Select(Ident(x2), m.name)})"
    }

    val order = (fields.init, Stream.continually(TermName(c.freshName("x")))).zipped.foldRight(last) {
      case ((m, other), acc) =>
        val t = q"_root_.scalaz.Order[${m.typeSignatureIn(Z)}]"

        q"""
          $t.order(${Select(Ident(x1), m.name)}, ${Select(Ident(x2), m.name)}) match {
            case _root_.scalaz.Ordering.EQ => $acc
            case $other => $other
          }
        """
    }

    q"""new _root_.scalaz.Order[$Z]{
      ${isNatural(fields, Z)}
      ${equalDef(x1, x2, fields, Z)}
      override def order($x1: $Z, $x2: $Z) = $order
    }"""
  }
}
