package functionalProgrammingScala.partone

/**
  * Created by raitis on 31/03/2016.
  */

// 1.
// applay must have arguments
object Hallo extends HalloTrait {
  def apply(a:Int) = "applay from object with Int argument: " + a
  override def apply = "apply from object with no argument (override)"
  def halloTom = println("Hallo Tom")
}

// 2.
// NOT  taking arguments
trait HalloTrait {
  def apply(s: String) = "apply from trait with String argument: " + s
  def apply = "apply from trait with no argument"
  def hallo = "Hallo from trait"
}

// 3.
// can only be a case class if there is an argument
// it cannot call applay methor
case class HalloCaseClass(a: Int) {
  def apply(b: Int) = "applay from caase class with Int arguments: " + a + " and " + b
  def apply = "apply from case classt with no argument"
  def hallo = "Hallo from Case Class"
}

// 4. SomeClass extends HalloFunction


object Functions extends App {

  val objecthallo = Hallo
  // apply is not working automatically without arguments!
  println(objecthallo)
  println(objecthallo(1))
  println(objecthallo("Hallo from trait"))
  objecthallo.halloTom
  println

  // cannoit be instantiated but can be implemented
  val myTrait = new HalloTrait{
    def moreTrait = "More Trait"
    override def apply(s: String) = "Apply from manually extended trait: "  + s
  }
  // apply also been taken automaticly
  println(myTrait("Direct hallo from trait WITHOUT using apply method"))
  println(myTrait.apply("Direct hallo from trait WITH using apply method"))
  println(myTrait.hallo)
  println(myTrait.moreTrait)
  println

  // must be given class constructor argument
  val caseclasshallo = HalloCaseClass(2)
  println(caseclasshallo(1))
  println(caseclasshallo.apply(1))
  println(caseclasshallo.hallo)
  println




  ///////////////  SO  ////////////////
  // from Scala API:

//  trait Function2[@specialized(scala.Int, scala.Long, scala.Double) -T1, @specialized(scala.Int, scala.Long, scala.Double) -T2, @specialized(scala.Unit, scala.Boolean, scala.Int, scala.Float, scala.Long, scala.Double) +R] extends AnyRef { self =>
//
//    def apply(v1: T1, v2: T2): R
//
//    @annotation.unspecialized def curried: T1 => T2 => R = {
//      (x1: T1) => (x2: T2) => apply(x1, x2)
//    }
//
//    @annotation.unspecialized def tupled: Tuple2[T1, T2] => R = {
//      case Tuple2(x1, x2) => apply(x1, x2)
//    }
//    override def toString() = "<function2>"
//  }


// To define anonymous function is a syntactic sugar from:
    val someFunction = new Function2[Int, Int, Boolean]  {
    def apply(a: Int, b:Int) = {
      a > b
    }
  }


  println(someFunction(1,2))
  println(someFunction(2,1))



}
