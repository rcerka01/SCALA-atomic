package implicits


/**
  * Created by raitis on 25/11/2015.
  */
object ImplicitFunction {
  def main(args: Array[String]) {


    // Missing conversion from one type to another type. This also applies to
    //  nmethod calls on an object that would require a conversion.




    // IMPLICIT FUNCTION

    // def foo = new { def x = println("x") }
    implicit def foo(x:Int) = new { def x = println("hallo") }

    // look in implicit scope to convert from the type (int) to any
    // other type that has that method

    // foo.x
    15.x


// can be used as database connection, if there is none one is greated
// as a default logger
  }
}
