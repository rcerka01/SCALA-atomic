package companionObject

/**
  * Created by raitis on 28/07/2016.
  */

class X(i: Int)
//case class X(i: Int)

object X {
  def apply(s: String): String = s
  def apply(i:Int, ii: Int):Int = {i + i}
}

object CaseClassVSclass extends App {

//  println(X(5))
  println(X(5,5))
  println(X("pieci"))

}
