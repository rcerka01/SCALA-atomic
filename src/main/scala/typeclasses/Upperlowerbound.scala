package typeclasses

class A
class A1 [P] // must have to take a parmmetter

class B [X <: A] // uppper type bound, X is a subtype of A
class C [X >: A] // lower  type bound, X is a supertype of A

// syntavtical sugar
//def fn[A <% B](arg: A)  = ... //sugared
//def fn[A](arg: A)(implicit ev: A => B) = ... //unsugared
class D [X <% A] // <% - view bound

//def fn[A : Numeric](arg: A)  = ... //sugared
//def fn[A](arg: A)(implicit ev: Numeric[A]) = ... //unsugared
class E [X : A1] // : - context bound



object Upperlowerbound {
  def main(args: Array[String]) {

    //var obj:A = new B()



     println("uraa")


  }
}
