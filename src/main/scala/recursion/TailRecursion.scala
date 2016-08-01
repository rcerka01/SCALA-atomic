package basics

// Tail recursive is better with deep recursion.

// Tail recursion is when only recursive function is called at the end.
// Factorial is NOT Tail recursive, because * n still must be done.

object bTailRecursion extends App {
  
  /////////// SOURCE
  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
  
  def myFun(n: Int): Int =
    n match {
    case  0 => 1
    case  n => n * myFun(n-1)
  }
  
  /////////////  PROPER
  def tailRecursive(n: Int): Int = {  
    
    def helper(value: Int, n: Int): Int =
      if (n == 0) value
      else helper(value * n, n - 1)
    
    helper(1, n)
  }

 println(tailRecursive(5))
}