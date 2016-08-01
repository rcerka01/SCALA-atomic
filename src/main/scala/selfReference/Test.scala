package selfReference

/**
  * Created by raitis on 23/03/2016.
  */

// useful when you have inner classes with naming conflicts, to make the outer scope visible.
trait U { self =>


  val name = "outer"

  val b = new AnyRef {
    val name = "inner"
    println(name)
    println(this.name)
    println(self.name)
  }

}

object Test extends App with U {


}
