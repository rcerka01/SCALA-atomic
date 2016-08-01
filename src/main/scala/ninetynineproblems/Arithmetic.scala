package ninetynineproblems

/**
  * Created by raitis on 07/01/2016.
  */

import scala.math._

object Arithmetic extends App {

  // 31
  println()
  println("thirty one")
  println()

  def isPrime(i:Int): Boolean = {

    def helper(i: Int, a: Int): Boolean = i match {
      case 2  => true
      case _  => if (a % (i-1) == 0) false else helper(i-1, a)

    }

    if (i < 2) false else helper(i, i)

  }

  for (r <- 1 to 100)  if (isPrime(r)) println(r)


  // 32
  println()
  println("thirty two")
  println()


  println(
    gcd(36, 63)
  )
  println(
    gcd(1071, 462)
  )

  def gcd(i: Int, j: Int) = {

    def helper(d: Int, i: Int, j: Int): Int = { d match {
      case 1 => 1
      case _ => if (i % d == 0 && j % d == 0) d else helper(d-1, i, j)
      }
    }

    if (i < j) helper(i, i, j) else helper(j, i, j)

  }


  // 33
  println()
  println("thirty three")
  println()

  println(
    isCoprimeTo(35, 64)
  )
  println(
    isCoprimeTo(35, 75)
    )

  def isCoprimeTo(i: Int, j: Int) = {

    def helper(a: Int, b: Int):Boolean = {
     var flag = true
     for (r <- 2 to a if (a % r == 0) && (b % r == 0)) flag = false
     flag
    }

    if (i < j) helper(i, j) else helper(j, i)

  }


  // 34
  println()
  println("thirty for")
  println()

  // my
  def totient(i: Int): Int = {
    var counter = 0
    for (n <- 1 to i) {if (isCoprimeTo(i, n)) counter += 1 }
    counter
  }

  // book
  // in my case book examle is not possible //def totient2(i: Int): Int = (1 to i) filter( i.is)

  println(
    totient(11)
  )


  // 35
  println()
  println("thirty five")
  println()


  def primeFactors(i: Int): List[Int] = {

    var result: List[Int] = List()
    helper(i, 2)

    def helper(value: Int, counter: Int): Int = {
      if (isPrime(counter) && value % counter == 0 ) {
        result = result :+ counter
        helper(value / counter, 2)
      }
      else if (isPrime(value) && isPrime(counter)) {
        result = result :+ value
        -1
      }
      else {
        helper(value, counter + 1)
      }
    }

    result
  }


  // better version with no var and ::
  def primeFactors2( i: Int ): List[Int] = {

    def helper( value: Int, l: List[Int] ): List[Int] = {

      if (isPrime(l.head) && value % l.head == 0 ) {
        helper(value / l.head, l.head :: l)
      }
      else if (isPrime(value) && isPrime(l.head)) {
       value :: l.tail
      }
      else {
        helper(value, l.head + 1 :: l.tail)
      }
    }

    helper(i, List(2)) reverse

  }



  println(
    primeFactors(315)
  )
  println(
    primeFactors2(315)
  )



  // 36
  println()
  println("thirty six")
  println()

  // list
  def primeFactorMultiplicity(i: Int) = {
    ( primeFactors2(i) groupBy(x=>x) map (y => (y._1, y._2.length)) )
      .toList
      .sortWith((z1,z2) => z1._1 < z2._1 )
  }

  // map
  def primeFactorMultiplicity2(i: Int) = {
    primeFactorMultiplicity(i).toMap
  }


  println(
    primeFactorMultiplicity(315)
  )

  println(
    primeFactorMultiplicity2(315)
  )



  // 37
  println()
  println("thirty seven")
  println()


  def totientFromPrimeFactors(i: Int): Int = {

    primeFactorMultiplicity(i).foldRight(1){ (x:(Int, Int),y:Int) => y * pow(x._1,x._2).toInt }

  }

  println("previous totient result: " +
    totient(315)
    )

  println("must be equal to: " +
    totientFromPrimeFactors(315)
  )

  println("pow(2,3).toInt: " +
    pow(2,3).toInt
  )

  println("primeFactorMultplicity: " +
    primeFactorMultiplicity(315)
  )


}

