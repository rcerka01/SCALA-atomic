package codility.moneyfarm

/**
  * Created by raitis on 28/01/2016.
  */
object One extends App {


  def solution(A: Array[Int]) = {

    // ._1 max size ._2 beginning of slice
    var acumulator = (0,0)


    for (p <- A.indices) {
      for (q <- A.indices) {

        // probably not needed checks
        if (0 <= p
          && p <= q
          && q <= A.length
        )

        ///////////
        {

          // find ascending
          var ascflag = true
          for (asc <- p to q) {
            if (asc+1 < A.length && A(asc) >= A(asc+1)) {
              ascflag = false
            }
          }


          // add to acumulator
          if (ascflag && q-p+1 > acumulator._1)
            acumulator = (q-p+1,p)


        }
        ////////////
      }
    }

    acumulator._2
  }



  val a = Array(2,2,2,2,1,2,-1,2,1,3)
  val b = Array(30,20,10)

  println(solution(a))
  println("//////")
  println(solution(b))

}
