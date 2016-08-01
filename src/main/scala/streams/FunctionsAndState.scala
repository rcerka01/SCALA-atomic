package week2

/**
 * Created by raitis on 07/08/15.
 */
object  FunctionsAndState extends App {
  // State of functions depend on variables (VAR is involved)
  // example: objext account, var state, deposit() and withdraw()

  // S T R E A M S
  //  Stream construct, which is like a List which lazily evaluates the next item only when needed.

  val stream = (1 to 100000000).toStream
  println(stream.head)
  println(stream.tail)

  val str = 1 #:: 2 #:: 3 #:: Stream.empty
  println(str)

  // higher order functions map, filter, flatMap etc.

}
