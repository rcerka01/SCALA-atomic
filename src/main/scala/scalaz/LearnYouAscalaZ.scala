package scalaz


/**
  * Created by raitis on 13/04/2016
  */

import scalaz.Scalaz._

case class MyInt(i: Int)
case class MyCaseClass(name: String, amount: Int)

object LearnYouAscalaZ extends App {

  println(
    some(3) map { _ + 1 }
  )


  println(
    (none: Option[Int]) map { _ + 1}
  )


  println(
    3.some
  )


  println(
    3.some.getOrElse("fuck")
  )


  println(
    (none: Option[Int]) map (_+1) getOrElse "fuck"
  )

  // or
  // must be Int
  println(
    none[Int] some { _ + 1 } none { 1 }
  )

  // if two optiona values exist
  // can't find <|*|>
//  3.some <|*|> 2.some match {
//    case Some((a,b)) if a == b => println("match")
//    case Some ((_,_)) => println("Dont' match")
//    case None => println("At least one is missing")
//  }

  println(
    (6 < 10).option("Im here")
  )

  println(
    (6 > 10).option("I'm too")
  )

  println(
    "56".parseDouble.getOrElse("Rubbish")
  )

  List(1,2,3,4).allPairs foreach println

  println(
    "someme".some
  )

  // this no problem
  println(
    new MyInt(1).some
  )

  // Either type goes to the right
  // map and flatMap goes here to right etc.
  val more = \/-(5)
  val more2 = -\/(5)

  println(
    more.getOrElse("fuck")
  )
  println(
    more2.getOrElse("fuck")
  )


  // TYPECLASSES

  // EQUAL


  println(
    1 === 2
  )

  // to make this working you have to build implicit Equal function for MyNotCaseClass type

// implicit val xxx = new Equal[MyCaseClass] {
//   def equal(o1: MyCaseClass, o2: MyCaseClass): Boolean = {
//      o1.name === o2.name &&
//      o1.amount === o2.amount
//   }
// }

  // is exaactly same as this:
  implicit val xxx = Equal.equalA[MyCaseClass]


  println(
    new MyCaseClass("alfa", 1) === new MyCaseClass("alfa", 1)
  )


  // FUNCTOR
  // anything what can be maped (list, option, future, etc.)

  // F[_] type constructor. Must be replaced with real type
  def addInt[F[_]]
           (i: Int, toAdd: F[Int])
           (implicit f: Functor[F]): F[Int] = {
    // functor can be maped
    f.map(toAdd)( _ + i)
  }

  // now
  println(
    addInt(6, 10.some)
  )

  println(
    addInt(3, List(1,2,3))
  )


  // MONOID

  // made of two traits

  // f2 is leasy
//  trait Semigroup[F[_]] {
//    def append(f1: F, f2: => F): F
//    def |+| (f1: F, f2: => F) = append(f1, f2)
//  }
//
//  trait Monoid[F] extends Semigroup[F] {
//    def zero: F
//  }

  println(
    1 |+| 2 |+| 3
  )

  println(
    List(9,6,3) foldMap (x => x / 3)
  )

  println(
    List("wed", "ewdwdd") foldMap ( _.length )
  )

  // can work along with all monoids
  println(
    "Hallo".some |+| None |+| "Friends".some
  )

  val map1 = Map(1 -> List (1,2,3),
                 2 -> List("a", "b"),
                 3 -> List("aa", "bb"))

  val map2 = Map(1 -> List("z"),
                 2 -> List("yyy", "zzz"))

  // return joined (in List case concatinate is default) 1es, 2es, 3

  println(
    map1 |+| map2
  )

  val map3 = Map( "a" -> 1, "b" -> 2 )
  val map4 = Map( "a" -> 14, "c" -> 32 )
  // in Int case add up (default)

  // if for example multiplication, then it has to be declared

  println(
    map3 |+| map4
  )

  // ??
  println(
    List("a", "b", "b", "b", "b", "c", "c") foldMap( x => Map(x -> 1) )
  )


  // MONADS

  class User
  class Address

  def getUser(id: Int): Option[User] = ???
  def getAddress(user: User): Option[Address] = ???

//  for {
//    user <- getUser(1)
//    address <- getAddress(user)
//
//  } yield address







}
