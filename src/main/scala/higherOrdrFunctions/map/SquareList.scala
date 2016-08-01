
// xs ++ ys - list of all elements + list of all elements
// xs.reverse - reversed order
// xs updated (n, x) - same list + n, x

// vectors are seperated in chunks of 32 elements
// Vector(1,3,4)
// addvector element - left +x right x+

// seq set map all are iterable
// Range 1 to 20 by 3

// 12. Consider a function which squares all elements of a list and returns a list with the
//     results. Complete the following two equivalent definitions of squareList:

object lSquareList extends App {

  def squareList(xs: List[Int]): List[Int] = 
   xs match {
    case List()  => xs
    case y :: ys => y * y :: squareList(ys)
  }
  
  def squareListMap(xs: List[Int]): List[Int] =
    xs map (x => x * x )
  
  val list = List(1, 2, 3, 4)
  
  println("normal" + squareList(list))
  println("map" + squareListMap(list))

  // BONUS
  val s = "Hallo World"
  println(s filter (x => x.isUpper))

}