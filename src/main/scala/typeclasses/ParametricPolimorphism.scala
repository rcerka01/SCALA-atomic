package typeclasses


object ParametricPolimorphism {
  def main(args: Array[String]) {




    def mylist[E](l:List[E]):E = {
      l.head
    }
    println(
      mylist(List(1,2,3))
    )
    println(
      mylist(List("o","t","th"))
    )

    // all types must be casted before argument list [E,A]
    def mylist2[E,A](l:List[E], x:A):A = {
      x
    }
    println(
      mylist2(List(1,2,3), "x")
    )
    // this actually work
    println(
      mylist2(List(1,2,3), 3)
    )



  }
}
