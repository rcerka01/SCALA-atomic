package functionalProgrammingScala

/**
  * Created by raitis on 24/03/2016.
  */


// WITH SIDE EFFECTSs
class Creditcard { def charge(price: Double) = ???}
class Payment
class Cofee { val price = 1.24 }

class Cafe {

  def buyCofee(cc:Creditcard, p:Payment) = {
    val cup = new Cofee()
    cc.charge(cup.price)
    cup
  }

}


// FUNCTIONAL

// data type
case class Charge(cc: Creditcard, amount: Double) {
  def combine(other: Charge): Charge =
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
  else
      throw new Exception("Cannot combine charges to different cards")

}


// seperate concerns
class CafeF {

  def buyCofeeF(cc: Creditcard): (Cofee, Charge) = {
    val cup = new Cofee()
    (cup, Charge(cc, cup.price))
  }

  // buy many coffees
  def buyCofeesF(cc: Creditcard, n: Int): (List[Cofee], Charge) ={
    val purchases: List[(Cofee, Charge)] = List.fill(n)(buyCofeeF(cc))
    val (cofees, charges) = purchases.unzip
    (cofees, charges.reduce((c1,c2) => c1.combine(c2)))
  }

}