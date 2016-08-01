package exercise1

// examinable:
// martin scala
// scala or java8
// solid, individual examples
// check uml
// patterns - strategy, final - treat, 
// streaming, filtering, mapping, reducing
// reflection bit
// DI bit
// NOTHING on actors agents, persistance 
// 7 8 no and 10 not like that (will be smaller) 2014
// all 2013 usable, section c is crap

object Carrying extends App {
  
   def cat(s1: String)(s2: String) = s1 + s2
   
   // second is lambda, anonomous function
   def cat2(s1: String) = (s2: String) => s1 + s2
   
   println(cat("Hallo ")("World"))
   println(cat2("Hallo ")("World"))
   
   val f = cat2("Boris ")
   val s = f("Spider")
   println(s)
   
   def addn(n: Int) = (i: Int) => i + n
   
   val add5 = (addn(5))
   
   println(add5(10))
}