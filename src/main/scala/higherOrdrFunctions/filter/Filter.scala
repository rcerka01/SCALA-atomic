package exam2014

object B extends App {
  
 def oddGT10(v:Vector[Int]):Vector[Int] =
   v.filter { x => x>10 } filter {x => x % 2 != 0}  

println(oddGT10(Vector(1,2,3,5,6,7,8,10,13,14,17)))

}