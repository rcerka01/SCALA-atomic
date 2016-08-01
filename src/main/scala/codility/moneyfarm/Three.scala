package codility.moneyfarm

/**
  * Created by raitis on 28/01/2016.
  */
object Three extends App {

  def solution(S: String)= {

    var counter: Int = -1

    val result = S.replace("-", "")
      .replace(" ", "")
      .map(s => if (counter == 2) {
        counter = 0
        "-"+s
      } else {
        counter +=1
        s
      })
      .mkString("")

    // mend if the last symbol is single
    if (result.takeRight(2).take(1) == "-")
      result.take(result.length-5) + result.drop(result.length-5).replace("-","").map(x=> if (counter == 1) {
        counter = -1
        x+"-"
      } else {
        counter += 1
        x
      }).mkString("")
    else
      result
  }




  val a = "00-44  48 5555 8361"
  val b = "0 - 22 1985--324"
  val c = "555372654"
  val d = "5553726/54"
  val e = "0 - 22 1985--324"

  println(solution(a))
  println(solution(b))
  println(solution(c))
  println(solution(d))
  println(solution(e))

}
