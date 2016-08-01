package exercise1

object ExpensiveResource extends App {
 
  // with "lazy" it is not evaluated it
  lazy val resource: Int = init()
  
  def init(): Int = {
    println("ouch")
    0
  }
  
  // only after println
  println(resource)

}