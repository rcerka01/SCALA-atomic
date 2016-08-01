package codility

/**
  * Created by raitis on 27/01/2016.
  */
object CountMultiPlicativePairs extends App {


  def solution(A: Array[Int], B: Array[Int]) = {

      val C = for (i <- A.indices) yield A(i)+B(i).toDouble/1000000

      var counter = 1

      for (i <- C.indices) {
        for (ii <- C.indices) {
          if (0 <= C(i)
            && C(i) < C(ii)
            && C(ii) < C.length
            && C(i) * C(ii) >= C(i) + C(ii)
          )
            counter += 1
        }
      }

    counter
   }





  val a = Array(0,1,2,3,4,5)
  val b = Array(500000,500000,0,0,0,20000)

  //println(solution(a,b).foreach(x=>println(x)))
  println(solution(a,b))

  println(a.length)

}
