package scalaz.dayone

/**
  * Created by raitis on 12/04/2016.
  *
  * add extends App to objects
  */



// PARAMETRIC POLYMORPHISM
// A can be any value

object Run1 {

  def head[A](l: List[A]): A = l.head

  // 1.
  println(head(List(1,2,3)))

  // 2.
  case class car(make: String)
  println(head(List("Alfa", "BMW", "Opel")))

}




// SUBTYPE POLYMORPHISM

trait Plus[A] {
  def plus(a: A): A
}

object Run2 {
  // it is now possible to call function recursively
  // def plus[A]](a1:A, a2:A) =  a1.plus(a2)
  def plus[A <: Plus[A]](a1:A, a2:A) =  a1.plus(a2)

}



// AD-HOC POLYMORPHISM
// implicits

trait Plus2[A] {
  def plus(a: A, a2:A): A
}

object Run3 {

  def plus[A: Plus2](a1: A, a2: A): A = implicitly[Plus2[A]].plus(a1,a2)

}



