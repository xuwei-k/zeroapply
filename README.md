# zeroapply [![Build Status](https://secure.travis-ci.org/xuwei-k/zeroapply.png)](http://travis-ci.org/xuwei-k/zeroapply) [![Reference Status](https://www.versioneye.com/java/com.github.xuwei-k:zeroapply-scalaz_2.11/reference_badge.svg?style=flat)](https://www.versioneye.com/java/com.github.xuwei-k:zeroapply-scalaz_2.11/references)


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


- [Maven Central Repository Search](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.xuwei-k%22%20AND%20(a%3A%22zeroapply_2.11%22%20OR%20a%3A%22zeroapply-scalaz_2.11%22))
- [Maven Central](http://repo1.maven.org/maven2/com/github/xuwei-k/)

## [`scalaz.Equal`](https://github.com/scalaz/scalaz/blob/v7.1.5/core/src/main/scala/scalaz/Equal.scala) and [`scalaz.Order`](https://github.com/scalaz/scalaz/blob/v7.1.5/core/src/main/scala/scalaz/Order.scala) macro

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
libraryDependencies += "com.github.xuwei-k" %% "zeroapply" % "0.1.4"
```

```scala
libraryDependencies += "com.github.xuwei-k" %% "zeroapply-scalaz" % "0.1.4"
```

- [API Documentation](https://oss.sonatype.org/service/local/repositories/releases/archive/com/github/xuwei-k/zeroapply-all_2.11/0.1.4/zeroapply-all_2.11-0.1.4-javadoc.jar/!/index.html)
- [sxr](https://oss.sonatype.org/service/local/repositories/releases/archive/com/github/xuwei-k/zeroapply-all_2.11/0.1.4/zeroapply-all_2.11-0.1.4-sxr.jar/!/index.html)


### snapshot version

```scala
resolvers += Opts.resolver.sonatypeSnapshots

libraryDependencies += "com.github.xuwei-k" %% "zeroapply" % "0.1.5-SNAPSHOT"
```

```scala
resolvers += Opts.resolver.sonatypeSnapshots

libraryDependencies += "com.github.xuwei-k" %% "zeroapply-scalaz" % "0.1.5-SNAPSHOT"
```

- [API Documentation](https://oss.sonatype.org/service/local/repositories/snapshots/archive/com/github/xuwei-k/zeroapply-all_2.11/0.1.5-SNAPSHOT/zeroapply-all_2.11-0.1.5-SNAPSHOT-javadoc.jar/!/index.html)
- [sxr](https://oss.sonatype.org/service/local/repositories/snapshots/archive/com/github/xuwei-k/zeroapply-all_2.11/0.1.5-SNAPSHOT/zeroapply-all_2.11-0.1.5-SNAPSHOT-sxr.jar/!/index.html)

### for scalaz 7.1.x

<https://github.com/xuwei-k/zeroapply/tree/0.1.x>
