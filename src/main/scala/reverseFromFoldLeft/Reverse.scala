package revision3

object Reverse extends App {
  
  def reverse[T](x: List[T]) = x.foldLeft(List[T]())((b,a) => a :: b)
    
  val ls = List("dsw",2,"eded",4)
  
  println(reverse(ls))

}