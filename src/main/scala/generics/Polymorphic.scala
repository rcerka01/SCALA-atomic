// subclass is dificult if class arguments is assaigned
// recursive is better to split in chanks and do it paralel

import scala.annotation.tailrec

object Polymorphic extends App {
    
  def findFirst[T](as: Array[T], value:T ): Int = {
// change type
//  def findFirst(as: Array[String], value:String ): Int = {    
    @tailrec 
    def helper(n: Int): Int = 
      if (n >= as.length) -1
      else if (as(n) == value) n
      else helper(n+1)
     helper(0)
  }
 
  
  def isSorted[T](as: Array[T], gt: (T, T) => Boolean): Boolean = {
   
    @tailrec 
    def helper(n: Int): Boolean = 
      if (n >= as.length -1) true
      else if (gt(as(n), as(n+1))) false
      else helper(n+1)
     helper(0)
  }
  
 
  def gt (x: Int, y: Int) = x>y
  
  
  println(findFirst(Array(23, 2, 1, 3), 1))
  println(isSorted(Array(1,6,3), gt))
  println(isSorted(Array(1,3,6), gt))
  
  // as a function literal
  println(isSorted(Array(1,3,6), (a:Int, b:Int) => a>b)) 
  
  // generics in java 
  // T extends ?
  // T super ?
  
  // Student extends Person
  // Pair[Student] <-> Pair[Person
  
}
