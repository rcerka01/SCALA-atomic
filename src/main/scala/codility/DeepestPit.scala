package codility

/**
  * Created by raitis on 27/01/2016.
  */

/// Not Correct !!!!

object DeepestPit extends App {

  def solution(A: Array[Int]) = {

    var depth = 0


    for (p <- A.indices) {
      for (q <- A.indices) {
        for (r <- A.indices) {
          for (dec <- p to q) {
            for (inc <- q to r) {
              if (0 <= p
                && p < q
                && q < r
                && r < A.length - 1
                && A(dec) > A(dec + 1) && A(dec + 1) < A.length - 1
                && A(inc) < A(inc + 1) && A(inc + 1) < A.length - 1
              )

              ///////////////////////
              {
                var tempdepth = 0

                if (A(p) - A(q) < A(r) - A(q))
                  tempdepth = A(p) - A(q)
                else
                  tempdepth = A(r) - A(q)


                if (depth < tempdepth) {
                  depth = tempdepth
                  tempdepth = 0
                } else
                  tempdepth = 0
              }
              ///////////////////////

            }
          }
        }
      }
    }
    depth
  }

  println(solution(Array(0,1,3,-2,0,1,0,-3,2,3)))


}