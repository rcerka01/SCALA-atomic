sealed trait DivideByZero 

final case object Finite   extends DivideByZero
final case object Infinite extends DivideByZero
 

object Divaide {  
  def applay (i1: Int, i2: Int) = {
      if (i2 == 0) Infinite
      else         Finite    
  }  
}


object Test extends App {  
  println(Divaide.applay(1,0))
  println(Divaide.applay(0,1))
}

