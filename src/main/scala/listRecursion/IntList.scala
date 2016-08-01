// VIP !!!
// Recursive Algebrate Date Type Pattern


import scala.annotation.tailrec 
  
// sealed compleatness, put all in one file
sealed trait  IntList {
  
//  @tailrec
//  def sum( total: Int = 0): Int =
//    this match {
//       case EndOfList => total
//       case Pair(hd, tl) => tl.sum ( hd + total)
//  }
//  
//    
//  @tailrec
//  def product( total: Int = 0): Int =
//    this match {
//       case EndOfList => total
//       case Pair(hd, tl) => tl.product ( hd * total)
//  }
//
//  
//    
//  @tailrec
//  def length( total: Int = 0): Int =
//    this match {
//       case EndOfList => total
//       case Pair(hd, tl) => tl.length ( 1 + total)
//  }
  
//  //2 4 6 
//   @tailrec
//   def double(list: IntList, total: Int = 0): IntList = 
//    this match {
//       case EndOfList => EndOfList
//       case Pair(hd, tl) => Pair(hd*2, double(tl, total))
//  }
  
  
  // abstract over methods <- (patern)
  def fold(end: Int, f: (Int, Int)=> Int): Int =
    this match {
       case EndOfList => end
       case Pair(hd, tl) => f(hd, tl.fold(end, f))
  }
  
  def sum: Int =
    fold(0, (hd, tl) => hd + tl)  
  def length: Int =
    fold(0, (_, tl) => 1 + tl)
  def product: Int =
    fold(1, (hd, tl) => hd * tl)
}

final case class Pair(heads: Int, tails: IntList) extends IntList

final case object EndOfList extends IntList


object main extends App {
  
  def l = Pair(1, Pair(2, Pair(3, Pair(4, EndOfList))))
  
  println(l)
  println(l.sum)
  println(l.product)
  println(l.length)
 // println(double(l))
  

  
}

// without anotation: 
//  def sum(list: IntList): Int =
//    list match {
//       case EndOfList => 0
//       case Pair(hd, tl) => hd + sum(tl)
//  }

// jvm not do tail recursion, it must be coded.
// scala does it with anotation
// anotation can be runtime or compile time