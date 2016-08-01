package imutability


object ValVarDef {
  def main(args: Array[String]) {

    // val is value but def is function

    // val is evaluated on initialization while def is evaluated only when, and every time, the function is called.
    // val not really fork for reflection?

    //def must be used for abstract methods because daf can be overriden

    trait Foo {
      def x:Int
      val y:Int
    }

    class Bar extends Foo {
      override val  x=5
      override val  y=6
     // override def  y=6 def can become val, but val cannot become def
    }


    val a:Foo = new Bar
    val b:Bar = new Bar

    println(a.x)
    println(a.y)

    println(b.x)
    println(b.y)


  }
}
