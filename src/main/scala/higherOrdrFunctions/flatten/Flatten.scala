package revision1

object Flatten extends App {

   val mylist = List(List(2,3),List(3,4))

   def flatten(l:List[List[Int]]):List[Int] = 
        l match {
          case Nil  => Nil
          case h::t => h++flatten(t)
        }
   
   println(flatten(mylist))
}  