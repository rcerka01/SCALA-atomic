package generics

object Func extends App {
  
  // DP Carrying
  def part[A, B, C] (a: A, fn: (A,B)=>C ): (B=>C)  = 
    (b:B) => fn(a,b)
  
    // Comparable not needed
  def compose[A <% Comparable[A],B <% Comparable[B],C <% Comparable[C]](f: B=>C, g: A => B): (A=>C) =
    a => f(g(a))

  // freezing akrguments (carrying)
  val a= 3  
  val add3 = part(a, (a: Int, b: Int) => a + b) 
  val add6 = part(6, (a: Int, b: Int) => a + b) 
 
  println(add3(6))
  println(add6(6))
  
  val double = (x: Double) => 2 * x
  val squared = (x: Double) => x * x
  val x = compose(double, squared)
  
 // or without comparables
 // println(compose(double, squared)(3))
  
  println(x(3))

}