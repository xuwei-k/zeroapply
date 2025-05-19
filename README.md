# zeroapply

## Zero Cost `Apply`/`Applicative` Syntax

### example


```scala
zeroapply.OptionApply.apply3(Option(1), Option(2), Option(3))(_ + _ + _)
```

↓

```scala
{
  val x0: _root_.scala.Option[Int] = scala.Option.apply[Int](1);
  if (x0.isEmpty)
    _root_.scala.None
  else
    {
      val x1: _root_.scala.Option[Int] = scala.Option.apply[Int](2);
      if (x1.isEmpty)
        _root_.scala.None
      else
        {
          val x2: _root_.scala.Option[Int] = scala.Option.apply[Int](3);
          if (x2.isEmpty)
            _root_.scala.None
          else
            _root_.scala.Some(x0.get.+(x1.get).+(x2.get))
        }
    }
}
```


- [Maven Central Repository Search](https://search.maven.org/search?q=g:com.github.xuwei-k%20AND%20(a:zeroapply_3%20OR%20a:zeroapply-scalaz_3))
- [Maven Central](https://repo1.maven.org/maven2/com/github/xuwei-k/)

## [`scalaz.Equal`](https://github.com/scalaz/scalaz/blob/v7.3.8/core/src/main/scala/scalaz/Equal.scala) and [`scalaz.Order`](https://github.com/scalaz/scalaz/blob/v7.3.8/core/src/main/scala/scalaz/Order.scala) macro

```scala
import scalaz._, std.AllInstances._

case class Foo[A, B](a: A, b: B, c: Int)

object Foo {
  implicit def instance[A: Order, B: Order]: Order[Foo[A, B]] =
    zeroapply.CaseClass.order[Foo[A, B]]
}
```

↓

```scala
new Order[Foo[A, B]] {
  override def equalIsNatural =
    Equal[A].equalIsNatural && Equal[B].equalIsNatural && Equal[Int].equalIsNatural

  override def equal(x1: Foo[A, B], x2: Foo[A, B]) =
    Equal[A].equal(x1.a, x2.a) && Equal[B].equal(x1.b, x2.b) && Equal[Int].equal(x1.c, x2.c)

  override def order(x1: Foo[A, B], x2: Foo[A, B]) =
    Order[A].order(x1.a, x2.a) match {
      case Ordering.EQ =>
        Order[B].order(x1.b, x2.b) match {
          case Ordering.EQ => Order[Int].order(x1.c, x2.c)
          case z => z
        }
      case z =>
        z
    }
}

```

### latest stable version

```scala
libraryDependencies += "com.github.xuwei-k" %% "zeroapply" % "0.5.1"
```

```scala
libraryDependencies += "com.github.xuwei-k" %% "zeroapply-scalaz" % "0.5.1"
```

### scaladoc

[![scaladoc](https://javadoc.io/badge2/com.github.xuwei-k/zeroapply-scalaz_3/javadoc.svg)](https://javadoc.io/doc/com.github.xuwei-k/zeroapply-scalaz_3)

[![scaladoc](https://javadoc.io/badge2/com.github.xuwei-k/zeroapply_3/javadoc.svg)](https://javadoc.io/doc/com.github.xuwei-k/zeroapply_3)

### for scalaz 7.2.x

<https://github.com/xuwei-k/zeroapply/tree/0.2.x>
