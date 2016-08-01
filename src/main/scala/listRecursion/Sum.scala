package revision1

object Sum extends App {

   def sum(l:List[Int]):Int =
      l match {
        case Nil => 0
        case h::t => h + sum(t)
      }  
   
   def prod(l:List[Int]):Int =
      l match {
        case Nil => 1
        case h::t => h * prod(t)
      }
   
   println(sum(List(1,2,3)))
   println(prod(List(1,2,3)))
   
  // sum and product in terms of reduce
   def sumReduce(l:List[Int]):Int =  (0::l).reduce(_ + _)
   
  // def prodReduce(l:List[Int]):Int =  l.reduce(_ * _)
   def prodReduce(l:List[Int]):Int =  (1::l).reduce(_ * _)
   
   println(sumReduce(List(1,2,3)))
   println(prodReduce(List(1,2,3)))
}