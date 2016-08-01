package eather

/**
  * Created by raitis on 22/04/2016.
  */
object EatherTest extends App {

  // can be any type, any order
  def divadeZerro(a: Int, b: Int): Either[Double, String] = {
    if (b == 0) Right("Cannot divide by 0")
    else Left(a / b)
  }

  println(divadeZerro(2,0))
  println(divadeZerro(2,4))

  // clean output
  divadeZerro(2,2) match {
    case Right(s) => println(s)
    case Left(d) => println(d)
  }

}
