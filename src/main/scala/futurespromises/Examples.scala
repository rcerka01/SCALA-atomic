package futurespromises

import scala.concurrent.{Future, future}
import scala.util.{Failure, Success}
// import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global



object Examples {
  def main(args: Array[String]) {

     println("My work which in middle need the Future")


     // 1. Creating a Future is simple; you just pass it a block of code you want to run
     val f = Future {
       Thread.sleep(500)
       println("Done")
     }

    // 2. It can also be return from function
    def myFuture (s: String)  = Future {
      Thread.sleep(100)
      s
    }

     // 1. onCompleate
     f.onComplete {
       case Success(r) => println("Future complete: " + r)
       case Failure(e)   => println("Error ocure: $e")
     }

    // 2.
    val result = for {
      r1 <-  myFuture("Tom")
      r2 <-  myFuture(" Rob")
      r3 <-  myFuture(" Ford")
    } yield (r1 + r2 + r3)

    result.onSuccess {
      case result => println(result)
    }



     println("My work continious and is done.")
     Thread.sleep(1000) // keep JVM running

  }
}
