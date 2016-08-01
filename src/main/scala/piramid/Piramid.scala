package question5

object StringList extends App {

def createFractal(n: Int): List[String] = {

  def helper(n:Int, result:List[String])():List[String] = {       
     n match {
       case 1 => result
       case n => {        
              val top = result map { s => (" " * s.length) + s } 
              val bottom = result map { s => s + s }
              
              helper(n-1, top:::bottom) 
              }
     }
  }
     
  helper(n, List(" |", "/|"))
}


createFractal(3).foreach( s => println(s))

}