/*
 * Currying is a technique not necessarily complex, but is one that you probably are not familiar 
 * with if you come from Java background as it is not a straightforward technique to apply in that language. 
 * Currying allows to turn a function that expects two arguments into a function that expects only one, 
 * and that function returns a function that expects the second argument. Creating basically a chain 
 * of functions.
 */

package revision1

object Currying extends App {
  (x:Int) => x+x
  
  println((x:Int) => x+x)
  
  // to call add variable in brackets
  println(((x:Int) => x+x)(3))
  //or assaign function to variable
  val f = (x:Int) => x+x
  println(f(3))
  
  // CURRYING
  println()
  
  def add(x:Int, y:Int):Int = x+y
  println("No currying: " + add(2,2))
  
  def addC(x:Int)(y:Int) = x + y
  
  println(addC(2)_)
  println(addC(2)(2))
  val fc = addC(2)_
  println(fc(2)) 
}