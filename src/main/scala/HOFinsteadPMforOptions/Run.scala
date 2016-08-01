package HOFinsteadPMforOptions

/**
  * Created by raitis on 30/05/2016.
  * http://blog.tmorris.net/posts/scalaoption-cheat-sheet/
  */
object Run extends App {

  /**
    * None, foo(x)
    * option.flatMap(foo(_))
    */

  def foo(i: Int): Option[Int] = Some(i + 1)

  val a: Option[Int] = Some(1) // None

  val a1 = a match {
    case None => None
    case Some(x) => foo(x)
  }

  val a2 = a.flatMap(foo(_))

  println("--flatMap--")
  println(a1)
  println(a2)


  /**
    * None, x
    * option.flatten
    */

  val b: Option[Option[Int]] = Some(Some(1)) // None

  val b1 = b match {
    case None => None
    case Some(x) => x
  }

  val b2 = b.flatten

  println("--flatten--")
  println(b1)
  println(b2)


  /**
    * {}, foo(x)
    * option.foreach(foo(_))
    */

  val c: Option[Int] = Some(1)

  val c1 = c match {
    case None => {
    }
    case Some(x) => foo(x)
  }

  val c2 = c.foreach(foo(_))

  println("--foreach--")
  println(c1)
  println(c2)

}
