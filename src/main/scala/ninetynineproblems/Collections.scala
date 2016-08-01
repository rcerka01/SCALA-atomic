package ninetynineproblems

import scala.util.Random

/**
  * Created by raitis on 30/12/2015.
  */
object Collections extends App {


  val l = List(1,2,3,4,8)


  // 1.

  def result1a(list: List[Any]) = ( list drop (list.length - 1) ) head

  def result1b[A](list: List[A]):A = { list match {
    case head :: Nil  => head
    case head :: tail => result1b(tail)
  }
  }

  def result1c(list: List[Any]) = l.last

  println("first")
  println(result1a(l))
  println(result1b(l))
  println(result1c(l))

  // 2.

  def result2a(list: List[Any]) = ( list drop (list.length - 2) ) head

  println("second")
  println(result2a(l))


  // 3.

  def nth(i: Int, l: List[Any]) = {
    l indexOf(i)
  }

  println("third")
  println(nth(2, List(1, 1, 2, 3, 5, 8)))

  // 4.

  def length(l: List[Any]) = {
    l length
  }

  println("forth")
  println(length(List(1, 1, 2, 3, 5, 8)))

  // 5.

  def reverse[T](l: List[T]) = {
    l.reverse
  }

  println("fifth")
  println(reverse(List(1, 1, 2, 3, 5, 8)))

  // 6.

  def isPalindrome(l: List[Any]) = {
    l == l.reverse
  }

  println("sixth")
  println(isPalindrome(List(1, 2, 3, 2, 1)))


  // 7.
  def flatten(l: List[Any]): List[Any] = {
    l flatMap {
      case x: List[Any] => flatten(x)
      case x            => List(x)
    }
  }

  val l2 = List(List(1,2,3),List(4,5,6)).flatMap { x => x}
  println("flatMap: " +l2)
  // not work val l3 = List(1,2,3).flatMap(x => x)
  val s1 = Seq(Seq(1,2,3),Seq(4,5,6)).flatMap { x => x.map(_*2) }
  println("Sequence *2 : " + s1)
  val v1 = Vector(Vector(1,2,3),Vector(4,5,6)).flatMap { x => x.zip(List('a','b','c','d')) }
  println("Vector zip: " + v1)


  println("seventh")
  println(List(List(1, 1), 2, List(3, List(5, 8))))
  println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))


  // 8.

  println("eighth")

  /////////////// FOLD
  val v6 = Vector(1,2,3,4).fold(5)(_+_)
  println("fold: " + v6)
  val v66 = List(1,2,3).fold(0){(x:Int, y:Int)=>x+y}
  println(v66)

  // if IF statement is not returning ELSE with a list (x), it is recognised as a Unit.

  def compress(l: List[Symbol]) = {
    l.foldLeft    (List[Any]())   {  (x, y:Any)  =>  if    (  x.isEmpty || !x.last.equals(y) )  x :+ y else  x }
  }

  println(
    compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  )

  // 9.

  println("nine")

  def pack(l: List[Any]) ={
    // l.foldLeft    (List(List[Any]()))   {  (x, y:Any)  =>  if    ( x.last.isEmpty || !x.last.last.equals(y) )  x:+List(y)  else { println("x->"+x.last); println("y->"+y); x;} }
    l.foldLeft    (List(List[Any]()))   {  (x: List[List[Any]], y:Any)  =>  if    ( x.last.isEmpty || !x.last.last.equals(y) )  x :+ List(y)   else   x.updated(x.length-1, x.last:+y)   }  drop(1)
  }

  println(
    pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  )

  val a = List(1,2,3)
  val b = List(4,5,6)

  println()
  println("++++++++++++++++++++")
  println()



  // LIST TO LIST BUT CAN USE ALSO FOR ELEMENTS
  // Returns a new list containing the elements from the left hand operand followed by the elements from the right hand operand. The element type of the list is the most specific superclass encompassing the element types of the two operands.
  println("++")
  // a left hand elements + right hand elements
  println(
    a ++ b
  )
  // this is no problem
  println(
    a ++ "a" ++ "1"
  )




  println("++:")
  // It differs from ++ in that the right operand determines the type of the resulting collection rather than the left one. Mnemonic: the COLon is on the side of the new COLlection type.
  // same as ++ but new list will be with type as right side element (usually add more specific type, example LinkedList etc.)
  println(
    a ++: b
  )
  // ok
  println(
    a ++: "a" ++: "1"
  )
  // :++ not exist
  //  println(
  //    a :++ "a" :++ "1"
  //    )


  // ELEMENT TO LIST ONLY
  // copy of the list with an element prepended.
  println("+:")
  println(
    a :+ 9
  )
  // or :+
  //  A copy of this list with an element appended.
  println(
    9 +: a
  )



  // :: takes List and produces List, while +: is more generic form, that can build other collections - like Vector or ArrayBuffer
  // :: prepends a single item whereas ::: prepends a complete list. So, if you put a List in front of :: it is taken as one item, which results in a nested structur
  // Adds an element at the beginning of this list.
  println("::")
  println(
    a :: b
  )

  // Adds the elements of a given list in front of this list.
  println(":::")
  println(
    a ::: b
  )

  println()
  println("++++++++++++++++++++")
  println()

  println("ten")

  println(
    encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  )

  // : List[(Int, Symbol)]
  def encode(l: List[Symbol]): List[(Int, Any)]= {
    pack(l) map ( x => (x.length, x.head))
  }


  println("eleven")

  println(
    encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  )

  def encodeModified(l: List[Symbol]) = {
    encode(l) map (x => if (x._1 == 1) x._2 else (x._1, x._2))
  }


  println("twelve")

  println(
    decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  )

  // My
  def decode(l: List[(Int, Symbol)]): List[Symbol]= {
    l map (x => for ( i <- 1 to x._1) yield x._2) flatten
  }

  // Book
  //  def decode[A](ls: List[(Int, A)]): List[A] =
  //    ls flatMap { e => List.make(e._1, e._2) }


  println("thirteen")

  println(
    encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  )

  // : List[(Any, Int)]

  def encodeDirect(l: List[Any]):List[(Int, Any)] = {
    def helper(l2: List[Any]):List[List[Any]] =
    l2 match {
      case Nil => Nil
      case h :: t => (h::t span (x => x.equals(h)))._1 :: helper((h::t span (x => x.equals(h)))._2)
    }
     helper(l) map (x => (x.length, x.head))
  }


//          if (x.head._2.equals(0)) {
//            println("x")
//            x.updated(0, (x.head._1, acum))
//          }
//          else if (x.last._1.equals(y)) {
//            acum = acum + 1
//            println("y")
//            x
//          }
//          else {
//            println("z")
//            x :+ (y, acum)
//          }


  println()
  println("fourteen")
  println()

  println(
    duplicate(List('a, 'b, 'c, 'c, 'd))
  )

  def duplicate(l: List[Symbol]) = {
    l flatMap (x => List(x,x))
  }


  println()
  println("fifteen")
  println()


  val ss1 = Seq(Seq(1,2,3),Seq(4,5,6)).flatMap { x => x.map(_*2) }
  println("Sequence *2 : " + ss1)
  val vv1 = Vector(Vector(1,2,3),Vector(4,5,6)).flatMap { x => x.zip(List('a','b','c','d')) }
  println("Vector zip: " + vv1)
  println()


  println(
    duplicateN(3, List('a, 'b, 'c, 'c, 'd))
    )

    def duplicateN(i: Int, l: List[Symbol]) = {
      l.flatMap( x => { for (n <- 1 to i ) yield x } )
    }


  println()
  println("sixteen")
  println()

  println(
    drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  )

  def drop(i: Int, l: List[Symbol]) = {
    for (n <- l.zipWithIndex if !n._2.equals(i-1)) yield n._1
  }


  println()
  println("seventeen")
  println()

  println(
    split(4, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  )

  // my
  def split(i: Int, l: List[Symbol]) = {
    (for (n <- l.zipWithIndex if n._2 < i) yield n._1, l.drop(i))
  }

  // book
  def splitB(i: Int, l: List[Symbol]) = {
    (l.take(i), l.drop(i))
  }


  println()
  println("eighteen")
  println()

  println(
    slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  )

  def slice(i: Int, k: Int, l: List[Symbol]) = {
    for (n <- l.zipWithIndex if n._2 >= i & n._2 < k ) yield n._1
  }


  println()
  println("nineteen")
  println()

  println(
    rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  )
  println(
    rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    )

  def rotate(i: Int, l: List[Symbol]) = {
    if (i >= 0)
      l.drop(i) ::: l.take(i)
    else
      l.drop(l.length-Math.abs(i)) ::: l.take(l.length - Math.abs(i))

  }


  println()
  println("twenty")
  println()

  println(
    removeAt(1, List('a, 'b, 'c, 'd))
  )

  def removeAt(i: Int, l: List[Symbol]) = {
    drop(i,l)
  }


  println()
  println("twentyone")
  println()

  println(
    insertAt('new, 1, List('a, 'b, 'c, 'd))
  )

  def insertAt(s: Symbol, i: Int, l: List[Symbol]) = {
    l.take(i) ::: s :: l.drop(i)
  }


  println()
  println("twentytwo")
  println()

  println(
    range(4, 9)
  )

  def range(i: Int, j: Int) = {
    (for (n <- i to j) yield n).toList
  }


  println()
  println("twentythree")
  println()

  println(
    randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  )

  def randomSelect(i: Int, l: List[Symbol]) = {
    for (n <- 1 to i) yield Random.shuffle(l).head
  }



  println()
  println("twentyfour")
  println()

  println(
    lotto(6, 49)
  )

  def lotto(i:Int, k: Int) = {
    val l = range(0, k)
    for (n <- 1 to i) yield Random.shuffle(l).head
  }


  println()
  println("twentyfive")
  println()

  println(
    randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
  )

  def randomPermute(l: List[Symbol]) = {
    Random.shuffle(l)
  }


  println()
  println("twentysix")
  println()

  println(
    combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
  )

  // easy version for combination of 3
  def combinations(i: Int, l: List[Any]) = {

    l flatMap (x =>
      l.filter(x1 => x1!=x) flatMap (y =>
        l.filter(y1 => y1!=y & y1!=x) map (z =>
          List(x,y,z)
          )
        )
      )

//    for (n <- l) {
//      for (nn <- l )
//        yield nn
//    }

//    l match {
//      case Nil  => Nil
//      case h::t => (for (n <- l) yield n) :: combinations(i, t)
//    }
  }


  // Twenty seven - not interested

  println()
  println("twentyeight")
  println()

  println(
    lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
  )

  // A
  def lsort(l: List[List[Symbol]]) = {
     l.sortWith((x,y) => x.length < y.length)
  }

  // B
  println(
    lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
  )

  def lsortFreq(l: List[List[Symbol]]) = {
    l.groupBy(x=>x.length)
      .toList
      .sortWith((s1,s2) => s1._2.length < s2._2.length)
      .flatMap (m => m._2)
  }



}
