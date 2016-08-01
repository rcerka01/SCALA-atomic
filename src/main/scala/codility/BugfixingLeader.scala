package codility

/**
  * Created by raitis on 27/01/2016.
  */
object BugfixingLeader extends App {

  def solution(A: Array[Int]): Int = {

    var n: Int = A.length

    var L: Array[Int] = Array(-1) ++ A

    var count: Int = 0

    var pos: Int = (n ) / 2

    var candidate: Int = L(pos)

    var i: Int = 1

    while (i <= n) {
      if (L(i) == candidate)
        count = count + 1;
      i = i + 1;
    }

    if (count > pos)
      return candidate;
    return -1;
  }




  println(solution(Array(2,2,2,2,2,2,1,4,4,4,6)))
  println(solution(Array(1,1,1,1,50)))




}
