package typeclasses

object ImplicitAdapters {
  def main(args: Array[String]) {

    // (ad-hoc polymorphism)
    // replacement for adapter pattern.


    trait Anytype[N] {
      def plus(x: N): String
    }

    // companion object (got accees to anything in Anytype, including private members)
    object Anytype {

      implicit object WithInt extends Anytype[Int] {
        def plus(x: Int) = "With Int " + x
      }

      implicit object WithDouble extends Anytype[Double] {
        def plus(x: Double) = "With Double " + x
      }

    } // <- Anytype object

    // applay object within implicit scope
    def result[T](x: T)(implicit anytype: Anytype[T]) = anytype.plus(x: T)

    println(
      result(3)
    )

    println(
      result(2.345)
    )

    // implicit parameter for type  string not found
    //  println(
    //    result("srf")
    //  )


  }
}
