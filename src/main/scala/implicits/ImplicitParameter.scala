package implicits

/**
  * Created by raitis on 25/11/2015.
  */
object ImplicitParameter {
  def main(args: Array[String]) {

    // A method call or constructor with a missing parameter.


    // val x:Int = 5
    implicit val x:Int = 5
    //implicit val y:Int = 6 //Error:(20, 5) ambiguous implicit values:both value y of type Int

    //def outp(z:Int) = println(z)
    def outp(implicit z:Int) = println(z)

    // outp(x)
    outp

// NO NEED FOR ARGUMENT


  }
}
