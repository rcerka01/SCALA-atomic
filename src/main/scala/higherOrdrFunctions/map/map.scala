package exam2014

object A extends App {
  
 def squareArg(ls:List[Int]):Int =
   ls map {x => x * x} sum
   
 println(squareArg(List(1,2,4)))
}