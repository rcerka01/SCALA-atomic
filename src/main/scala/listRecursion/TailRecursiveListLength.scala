object kTailRecursiveListLength extends App {
  
//11. Given the following function, which computes the length of a list:
//  def length: Int = 
//    this match {
//      case Nil     => 0
//      case x :: xs => 1 + xs.length
//  }
//Design a tail-recursive version of length.  
  
// extra parameter - counter must be involved

def recursiveLength(l:List[Int], count: Int = 1): Int = {
   if (l.tail == Nil) count
   else recursiveLength(l.tail, count + 1)
}
  

def tailRecLength(list: List[Int], count: Int = 0): Int =
   list match {
     case Nil    => count
     case x::xs  => tailRecLength(xs, count + 1)
}


val list1 = List(1,2,3,4)

println(list1)
println("length 1: " + recursiveLength(list1))
println("length 2: " + tailRecLength(list1))

}
