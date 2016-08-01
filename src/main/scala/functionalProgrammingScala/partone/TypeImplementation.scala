package functionalProgrammingScala.partone

/**
  * Created by raitis on 02/04/2016.
  */
object TypeImplementation extends App {

  def partial1[A,B,C] (a: A, f: (A,B) => C ):B => C =
    (b: B) => f(a,b)

 def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    (a: A) => (b: B) => f(a,b)
   // or
   // a => b => f(a,b)

  def uncurry[A,B,C] (f: A => B => C): (A,B) => C =
    (a:A, b:B) => f(a)(b)
    // or
    // (a, b) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))
    // or
    // a => f(g(a))


   def c(i: Int)(ii: Int) = i + ii
   println(c(3)(2))

  // second is lambda, anonomous function
  def cat2(s1: String) = (s2: String) => s1 + s2
  def cat3(s1: String)(s2: String) = s1 + s2
  println(cat2("a")("b"))
  println(cat3("a")("b"))

}
