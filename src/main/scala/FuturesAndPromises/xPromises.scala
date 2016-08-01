package week4

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success}
import ExecutionContext.Implicits.global


/**
 * Created by raitis on 17/08/15.
 */
case class TaxCut(reduction: Int)



object TaxCut2 extends App {

    //declaration
    val taxcut1 = Promise[TaxCut]()
    val taxcut2: Promise[TaxCut] = Promise()

    val taxcutFuture: Future[TaxCut] = campaignPledge()
    println("see in action")


// error
    taxcutFuture.onComplete {
      case Success(TaxCut(reduction)) => println(s"It's ok, reduction: $reduction")
      case Failure(ex)                => println(s"error: ${ex.getMessage}")
   }






  def campaignPledge(): Future[TaxCut] = {
    val p = Promise[TaxCut]()
        Future {
          println("Start new")
          Thread.sleep(2000)
         //  Throwable p.failure("Error")
          p.success(TaxCut(20))
          println("Done")
        }
    p.future
  }




}


