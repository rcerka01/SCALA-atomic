package week1

/**
 * Created by raitis on 06/08/15.
 */

//trait M[T] {
//  def flatMap[U](f: T => M[U]): M[U]
//}

// low
// 1. (x + y) +z = x + (y + z)
// 2. unit(x) flatMap f == f(x)     (fall on TRY)
// 3. m flatMap unit == m
// usable for FOR expressions

/*
It is the sequencing of operations, that leads to the evolution of higher order functional abstractions.

It is the types that actually take part in the operations. In the first case, it is the operations
on List type that gets chained. While in the second case, it is the Option type.

The flatMap (aka bind in Haskell) operation, which works orthogonally across types and serves
as the generic binder of the sequence of actions.
 */




object Monad extends App {

  // sequence of one
  for {
    x <- List(1,2)
  } yield (println(x + 2))


  println
  // equals
  List(1,2) map (x => println(x + 2))



  println
  // sequence with two
  val one = List(1,2)
  val two = List(3,4)
  for {
    i <- one
    j <- two
  } yield (println(i * j))


  println
  // equals
  val r = one flatMap (x => two map (y => x * y))
  println(r)




  println
  // sequence with three
  val onex = List(1,2)
  val twox = List(3,4)
  val threex = List("a","ab", "abc")
  for {
    i <- onex
    j <- twox
    k <- threex
  } yield (println(i * j * k.length))


  println
  // equals
  val rx = onex flatMap
              (x => twox flatMap
                      (y => threex map(z => (x * y * z.length))))
  println(rx)
  //flatMap, which binds the computation through chaining. Each invocation of flatMap returns the same data
  // structure type (but of different value), that serves as the input to the next command in chain.



//  case class Order(item: Option[Item])
//  case class Item(product: Option[Product])
//  case class Product(name: String)
//
//  for {
//    order <- myOrder
//    item <- order.item
//    product <- item.product
//  } yield product.name
//
//  maybeOrder flatMap {
//    order => order.lineItem flatMap {
//      lineItem => lineItem.product map {
//        product => product.name
//      }
//    }
//  }



  // ability to combine diverse monadic operations to design modular and extensible code
  println
  val list = List("India", "Japan", "France", "Russia")
  val capitals =
    Map("India" -> "New Delhi", "Japan" -> "Tokyo", "France" -> "Paris")

  for {
    i <- list
    j <- capitals get(i) orElse(Some("None"))
  }
    yield(println(j))


  println
  // monad
  list flatMap {
    i => capitals.get(i).orElse(Some("None")) map {
      j => println(j)
    }
  }







}
