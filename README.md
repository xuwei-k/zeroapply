# zeroapply [![Build Status](https://secure.travis-ci.org/xuwei-k/zeroapply.png)](http://travis-ci.org/xuwei-k/zeroapply)
[![Gitter](https://badges.gitter.im/Join Chat.svg)](https://gitter.im/xuwei-k/zeroapply?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)


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


### latest stable version

```scala
libraryDependencies += "com.github.xuwei-k" %% "zeroapply" % "0.1.1"
```

```scala
libraryDependencies += "com.github.xuwei-k" %% "zeroapply-scalaz" % "0.1.1"
```


- [API Documentation](https://oss.sonatype.org/service/local/repositories/releases/archive/com/github/xuwei-k/zeroapply-all_2.11/0.1.1/zeroapply-all_2.11-0.1.1-javadoc.jar/!/index.html)
- [Maven Central Repository Search](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.xuwei-k%22%20AND%20(a%3A%22zeroapply_2.11%22%20OR%20a%3A%22zeroapply-scalaz_2.11%22))
- [Maven Central](http://repo1.maven.org/maven2/com/github/xuwei-k/)
