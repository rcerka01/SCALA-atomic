package exam2014

object C extends App {
   val v = Vector("aa", "aaaaaa", "e", "b")
   
   println(
       v.sortBy { x => x.length() }
       ) 
       
   println(
       v.sortBy { x => x.length } reverse
       )  
       
   println(
       v.sortBy { x => x.take(1) }
       ) 
       
   println(
       v.sortBy { x => if (x.take(1) == "e") false else true }
       )   

}