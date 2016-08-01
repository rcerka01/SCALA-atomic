package functionalProgrammingScala.parttwodatastructures

/**
  * Created by raitis on 05/04/2016.
  */
object Exercises extends App {


  val x = List(1, 2, 3, 4, 5) match {
    case x :: 2 :: 4 :: _ => x
    case Nil => 42
    case x :: y :: 3 :: 4 :: _ => x + y
    case h :: t => h + t.sum
    case _ => 101
  }

  println(x)

  val l = List(1, 2, 3, 4, 5)

  def tail[A](l: List[A]): List[A] = {
    l match {
      case h :: t => t
      case _ => Nil
    }
  }

  println(tail(l))
  println(tail(List(1, 2)))
  println(tail(List(1)))
  println(tail(List()))

  def drop[A](l: List[A], n: Int): List[A] = {
    n match {
      case 0 => l
      case _ => drop(tail(l), n - 1)
    }
  }

  // from the book

  //  def drop[A](l: List[A], n: Int): List[A] =
  //    if (n <= 0) l
  //    else l match {
  //      case Nil => Nil
  //      case Cons(_,t) => drop(t, n-1)
  //    }

  println(drop(l, 2))




  /**
    *  FOLD
    */

  // foldLeft IS TAIL RECURSIVE!!! IT IS PREFERRED TO USE FOR LARGE DATA SETS.
  // BOOK SAMPLES:


  //  @annotation.tailrec
  //  def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = l match {
  //    case Nil => z
  //    case Cons(h,t) => foldLeft(t, f(z,h))(f)
  //  }


  //   def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = // Utility functions
  //     as match {
  //       case Nil => z
  //       case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  //   }


  // Given at the book.
  // @annotation.tailrec <- not tail recursive, can give stack overflow at large data sets
  // returns tail up until the last operation and then collapse.
  // cannot see any reason why to use this instead of foldLeft
  def foldRight[A,B](as: List[A], z: B)(f: (A,B)=>B): B = {

    as match {
      case Nil => z
      case h::t => f(h, foldRight(t, z)(f));
    }

  }


  // My version, perfect match to answers
  // goes FROM left and performs function on each step (left to right).
  @annotation.tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = {

    as match {
      case Nil => z
      case h :: t => foldLeft(t, f(z, h))(f)
    }

  }


  println(foldLeft(l,0)((x:Int, y:Int)=> x + y))
  // same as:
  println(foldLeft(l,0)(_+_))
  println(foldRight(l,0)(_+_))




  /**
    *  REVERSE
    */

  def reverse[A](l: List[A]): List[A] = {
    foldLeft(l, List[A]())((h,t) => t::h)
  }

  println(reverse(l))


  /**
    *  MAP, FLATMAP
    */


  def map[A,B](as: List[A])(f: A => B): List[B] = {
    as match {
      case Nil    => Nil
      case h :: t => f(h) :: map(t)(f)
    }
  }

  println(map(l)(_ + 1))

  // flatMap means Concatenate
  // ++ for any is the same as ::: only for lists
  def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] = {
    as match {
      case Nil    => Nil
      case h :: t => f(h) ::: flatMap(t)(f)
    }
  }

  val f = List(List(1,2), List(3,4),List(4,5))

  println(flatMap(f)(_.::(69)))


  // filter cannot be written via map. How to remove element? There is no NIL VALUE.
  def filter[A](l: List[A])(f: A => Boolean): List[A] = {
    flatMap(l)((a:A) => if (f(a)) List(a) else Nil)
  }

  println(filter(l)(_ > 2))
  println(filter(f)(_.length >= 2))




}
