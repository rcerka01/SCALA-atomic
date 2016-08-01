package revision1

object Multiplylist extends App {

  def multiply(l:List[Int], v: Double):List[Double] = 
      l match {
         case Nil => Nil
         case h::t => h*v::multiply(t,v)
      }
  
  
  println(multiply(List(1,2,3), 2.1))

}

