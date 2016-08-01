package week2

import rx._

/**
 * Created by raitis on 12/08/15.
 */
object ObserfersReplacedSignals extends  App {

  // counter for observer:
  var counter = 0

  val  v1,v2 = Var(0)

  // observer
  Obs(v1) { counter += 1}

  val sum = Rx{v1() + v2()}

  println(sum() + " counter: " + counter)

  v1() = 2

  println(sum() + " counter: " + counter)

  v2() = 3

  println(sum() + " counter: " + counter)

  // never implement observer yourself

}
