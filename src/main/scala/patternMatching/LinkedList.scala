case class MyPair(val head: Int, tail: LinkedList) extends LinkedList

final case object ListEnd extends LinkedList  {
  val head: Int = 0
  val tail: LinkedList = null
}

sealed trait LinkedList {
  val head: Int
  val tail: LinkedList

  def length(sum: Int = 0):Int = {
    this match {
      case MyPair(head,tail) => tail.length(1+sum)
      case ListEnd => sum
    }
  } 
  
  def applay(nth: Int):LinkedList = {
    this match {
      case MyPair(nth, tail)  => MyPair(nth, tail.applay(nth))
      case ListEnd => ListEnd
    }
  }
}

object TestLinkedList extends App {
  var list: LinkedList = MyPair(1, MyPair(2, MyPair(3, ListEnd)))
  println(list)
  println(list.isInstanceOf[LinkedList])  
  println(list.head)
  println(list.tail.head)
  println(list.tail.tail)
  
  println("length")
  println(list.length())
  println(list.applay(2))
  //println(list.contains(3, ListEnd))

}