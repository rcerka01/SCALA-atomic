package week4

/**
 * Created by raitis on 13/08/15.
 */

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.util.Random


object xFutures extends App {

  type CoffeeBeans = String
  type GroundCoffee = String
  case class Water(temperature: Int)
  type Milk = String
  type FrothedMilk = String
  type Espresso = String
  type Cappuccino = String

  def grind(coffeebeans: CoffeeBeans): Future[GroundCoffee] = Future {
    println("grinding...")
    Thread.sleep(Random.nextInt(2000))
    println("grinding done")
    s"ground coffee $coffeebeans"
  }

  def heatWater(water: Water): Future[Water] = Future {
    println("heating water...")
    Thread.sleep(Random.nextInt(2000))
    println("water heated")
    water.copy(79)
  }

  def frothMilk(milk: Milk): Future[Milk] = Future {
    println("frothing milk..")
    Thread.sleep(Random.nextInt(2000))
    println("milk ready")
    s"froathed milk"
  }

  def brew(cofee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
    println("brewing...")
    Thread.sleep(Random.nextInt(2000))
    println("done")
    "expresso"
  }


  def prepareCappuccino(): Future[Cappuccino] = {
    val groundCoffee = grind("arabica beans")
    val heatedWater = heatWater(Water(20))
    val frothedMilk = frothMilk("milk")
    for {
      ground <- groundCoffee
      water <- heatedWater
      foam <- frothedMilk
      espresso <- brew(ground, water)
    } yield espresso

  }


//prepareCappuccino()
//readLine()

  /*
  // CALLBACKS

  // called only if Future is successful
  grind("my onSuccess beans").onSuccess {
    case "ground coffee my onSuccess beans" => println("ok")
    case _                                  => println("something wrong")
  }

  // called only if Future fails
  grind("my onFailure beans").onFailure {
    // throwable
    case t => println("An error has occured: " + t.getMessage)
  }

  // better to combine both
  grind("my onComplete beans").onComplete {
    case Success(ground) => println(s"got my $ground")
    case Failure(ex)     => println("This grinder needs a replacement.")
  }

  readLine()
  */



  // never prints if fail
  val temperatureOk: Future[Boolean] = heatWater(Water(25)) map {
    water => println("boiled")
     (80 to 85) contains(water.temperature)
  }
  readLine()


}
