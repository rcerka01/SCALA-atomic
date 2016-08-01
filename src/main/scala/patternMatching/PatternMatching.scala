package week1

/**
 * Created by raitis on 16/07/15.
 */
class PatternMatching


trait Function1[-A, +R] {
  def applay(x: A):R
}



object Run extends App {

  val f1:String => String = { case "ping" => "pong"}

  // have method isDefained() for patern matching (not working for inner case blocks)
  val f2:PartialFunction[String, String] = { case "ping" => "pong"}

  println(
    f1("ping")
  )

  println(
    f2("ping")
  )

// gives error
//  println(
//    f("test")
//

// Partial Function
  println(
    f2.isDefinedAt("ping")
  )

  println(
    f2.isDefinedAt("test")
  )

}
