package scalaz

/**
  * Created by raitis on 09/04/2016.
  */
class NickPartridgeWelcome

//  SCALAZ uses traits, not inheritence

// MONOID

trait MyMonoid[A] {
  def mappend(x: A, y: A): A
  def mzerro: A
}


// companion object
// implicit objects cannot be defined as top level objects
object MyMonoid {

  implicit object IntMyMonoid extends MyMonoid[Int] {
    def mappend(x: Int, y: Int): Int = {
      x + y
    }
    def mzerro = 0
  }

  implicit object StringMonoid extends MyMonoid[String] {
    def mappend(x: String, y: String) = { x + y }
    def mzerro = ""
  }

}




// GENERALISE foldLeft

// F[_] - type constructor, like List, Option, etc.
trait FoldLeft[F[_]] {
  def foldLeft[A,B](l: F[A], b: B, f2: (B,A) => B):B
}

// companion object
object FoldLeft {

  // implicit scope for list
  implicit object MyFoldLeftList extends FoldLeft[List] {
    def foldLeft[A, B](l: List[A], b: B, f: (B,A) => B) = {
      l.foldLeft(b)(f)
    }
  }

}


// IDENTIFAY ANY TYPE

trait Identity[A] {
  val value: A
  def plus(a: A)(implicit m: MyMonoid[A]): A = m.mappend(value, a)
  // or
  def |+| (a: A)(implicit m: MyMonoid[A]): A = m.mappend(value, a)

}


// FOR SUM MUST BE MORE INFORMATION PROVIDED

trait MA[M[_], A] {

  val value: M[A]

  def mySum(implicit m: MyMonoid[A], fl: FoldLeft[M]): A = { fl.foldLeft(value, m.mzerro, m.mappend) }

}




object Run extends App {

  val testl = List(1,2,3,4,5)

  // MONOID

  // for sumViaMonoid3 if implicit object is not defined
  // implicit val intMonoid = IntMyMonoid
  // or define custom object:
  val MultMonoid = new MyMonoid[Int] {
    def mappend(x:Int, y:Int) = x * y
    def mzerro = 1
  }



  def sum(l: List[Int]): Int = { l.foldLeft(0)(_+_) }

  def sumViaMonoid(l: List[Int]) = { l.foldLeft(MyMonoid.IntMyMonoid.mzerro)((x:Int,y:Int) => MyMonoid.IntMyMonoid.mappend(x,y)) }

  // pass the Monoid into the function
  def sumViaMonoid2(l: List[Int], m: MyMonoid[Int]) = { l.foldLeft(m.mzerro)((x:Int,y:Int) => m.mappend(x,y)) }

  // change to universal type
  def sumViaMonoid3[T](l: List[T])(implicit m: MyMonoid[T]) = { l.foldLeft(m.mzerro)(m.mappend) }

  // generalise for F[_]
  // taking monoid and foldLeft
  def sumViaF[M[_], T](l: M[T]) (implicit m: MyMonoid[T], fl: FoldLeft[M]): T = { fl.foldLeft(l, m.mzerro, m.mappend) }

  // sum any two types with monoid (jast use mappend)
  def plus[T](a:T, b:T)(implicit m: MyMonoid[T]): T = m.mappend(a,b)

  // or make it implicit
  implicit def toIdent[A](a: A): Identity[A] = new Identity[A] {
    val value = a
  }

  // for sum
  implicit def toMA[M[_], A](ms: M[A]): MA [M,A] = new MA[M, A] {
    val value = ms
  }



  println(sum(testl))
  println(sumViaMonoid(testl))
  println(sumViaMonoid2(testl, MyMonoid.IntMyMonoid))
  println(sumViaMonoid3(testl))
  // for string
  println(sumViaMonoid3(List("a","b","c")))
  // custom monoid for multiplication
  println(sumViaMonoid3(testl)(MultMonoid))
  // more generalise
  println(sumViaF(testl))
  // now for multiplication must be passed extra parameter (this is correct syntax, implicitly is already defined)
  println(sumViaF(testl)(MultMonoid, implicitly[FoldLeft[List]]))
  // Identify and sum any type
  println(plus(3,4))
  // or it can be writen like this from implicit scope
  println(3.plus(4))
  // or
  println(3 plus 4)
  // or
  println(3 |+| 4)
  // sum
  println(List(1,2,3,4,5).mySum)









}
