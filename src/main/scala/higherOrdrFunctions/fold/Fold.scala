package revision1

object Fold extends App {
  
  val l:List[Int] = List(1,2,3)
             println((l fold 0)(_+_))
  println("right:" + (0 /: l)(_+_))
  println("left:" +  (l :\ 0)(_+_))
}