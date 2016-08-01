package revision1

object Rungame extends App {
  
  type Player = (String, String, Int)
  type Squad = (Seq[Player])
  type Division = (Seq[Squad])

  
  def avarageAge(sq: Squad):Double =
    (sq.map(x => x._3) sum) / sq.length
 
  def partition(sq:Squad):(Squad, Squad) =
     sq.filter{x => x._3 <= 23 && x._3 >= 17}partition { x => x._3 <= 20 && x._3 >= 19 }
  
  val p1 = ("ede", "wefd", 12)
  val p2 = ("wefe", "yhfd", 19)
  val p3 = ("vge", "ikfd", 22)
  val p4 = ("vge", "ikfd", 23)
  val sq = Seq(p1,p2,p3,p4)    
       
 println(avarageAge(sq))
 println(partition(sq))
}

