package codility

import scala.util.control.Breaks._
import scala.collection.immutable.Stream.Empty

// CODILITY DEMO

/**
  * Created by raitis on 11/01/2016.
  */
object DemoTask extends App {

  var ind= 0
  val l:List[Int] =   List(-1,3,-4,5,1,-6,2,1)

    var result = -1

    val r =  l.zipWithIndex.filter ( x => {
      l.take(x._2 + 1).sum + x._1 == l.drop(x._2).sum + x._1
     }) map (y => y._2)

    if (r.nonEmpty) result = r(0)

  println(result)
//  println(r)

//  println(r(0))
//  println(List().length)
//  println(l.take(2))
//  println(l.zipWithIndex.map ( x=> x._2))
//  println(l.drop(1))



  val A: Array[Int] =  Array(-1,3,-4,5,1,-6,2,1)


  def solution(A: Array[Int]): Int = {
    var result = -1
    breakable { for ((x, i) <- A.zipWithIndex) { if ((A.take(i+1).sum + x) == (A.drop(i).sum + x)) {result = i; break; } } }
    result
  }

  println(solution(A))


  // DOMINANT ARRAY MEMBER

  val ar = Array(3,23,23,23, 23, 67, 67)

  val r_ar = ar.groupBy(x=>x).filter(t=>t._2.length > ar.length / 2)

   val result_ar = if (r_ar.isEmpty) -1 else r_ar.toList(0)._1

  println(
   result_ar
  )

}


