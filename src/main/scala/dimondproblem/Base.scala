package dimondproblem

/**
  * Created by raitis on 09/01/2016.
  */

// You can't extend multiple classes, but you can extend several traits. Unlike Java interfaces,
// traits can also include implementation (method definitions, data members, etc.). There is still
// a difference in that you can't instantiate a trait directly (similar to abstract classes in a way).



trait A { val x: Symbol  }

class B extends A { val x = 'b }

trait C extends A { override val x = 'c }
trait D extends A { override val x = 'd }


//Scala’s solution to the Diamond Problem is actually fairly simple: it considers the order in which traits are inherited.
//If there are multiple implementors of a given member, the implementation in the supertype that is furthest
//to the right (in the list of supertypes) “wins.”

//class E extends B with A with C  // -> c
//class E extends B with C with D   // -> d
class E extends C with A with D  // -> d


object Base extends App {

  val d = new E

  println(
    d.x
  )

}
