package functionalProgrammingScala.partone

/**
  * Created by raitis on 27/03/2016.
  */

// WRITE LOOPS AS RECURSION
// TAIL RECURSION

object Fibonacci extends App {


  def fib(n: Int): Int = {

    @annotation.tailrec
    def helper(a1: Int, a2:Int, count: Int): Int = {
      if (n.equals(0)) n
      else if (count -3 < 0) a1 + a2
      else helper(a2, a1 + a2, count - 1)
    }

    helper(0,1,n)
  }


  // OTHER FUNCTION
  def increment(n: Int): Int = {
    n+1
  }



  // PASS FUNCTION
  def formatResult(name: String, n:Int, f: Int => Int) = {
    "The result of %s from %d is %d".format(name, n, f(n))
  }


  // ANOTHER EXAMPLE
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {

    @annotation.tailrec
    def helper(counter: Int): Boolean = {
      if (counter == 0) true
      else if (!ordered(as(counter-1),as(counter))) false
      else helper(counter-1)
    }

    helper(as.length-1)

  }





  println(fib(0) + " should be 0" )
  println(fib(1) + " should be 1" )
  println(fib(2) + " should be 1" )
  println(fib(3) + " should be 2" )
  println(fib(4) + " should be 3" )
  println(fib(5) + " should be 5" )
  println(fib(6) + " should be 8" )
  println(fib(20) + " should be 6765" )

  println(formatResult("Fibonachi", 3, fib))
  println(formatResult("Increment", 3, increment))

  println("is sorted: " + isSorted(Array(1,2,3,4,5), (a:Int, b:Int) => a < b ))
  println("is sorted: " + isSorted(Array(1,2,3,5,4), (a:Int, b:Int) => a < b ))
  println("is sorted: " + isSorted(Array(5,4,3,2,1), (a:Int, b:Int) => a > b ))
  println("is sorted: " + isSorted(Array(5), (a:Int, b:Int) => a > b ))
 // println("is sorted: " + isSorted(Array(), (a:Int, b:Int) => a > b )) goes for exception

}
