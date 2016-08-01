package scalaz


import scalaz.Scalaz._


/**
  * Created by raitis on 22/03/2016.
  */
class Foo


object Bits extends App {

  //  compiler not complaning to compare diferent types
  if ("1" == 1) println("hallo") else println("not hallo")
  // Scalaz style. Comparing only within the same type
  if ("1" === "") println("hallo") else println("not hallo")



  // \/ (Disjunction or “the other Either”)
  // -\/ left value
  // \/- right value
  println(
    1.right[String]
  )

  println(
    1.right[Int]
  )

  println(
    "efef".left[Int]
  )

  // try catch
  // right
  println(
    \/.fromTryCatchNonFatal("123".toInt)
  )

  // left
  println(
    \/.fromTryCatchNonFatal("123x".toInt)
  )

  // raight value has a map
  \/.fromTryCatchNonFatal("123".toInt).map(println)





  // TYPECLASSES

  trait OffspringName[T] {
    def getName(t: T): String
  }

  def getName[T](t: T)(implicit i: OffspringName[T]) = {
    i.getName(t)
  }


  class Cat
  class Dog


   implicit object CatName extends OffspringName[Cat] {
      def getName(cat: Cat) = "Kiity"
    }

   implicit object DogName extends OffspringName[Dog] {
      def getName(dog: Dog) = "Puppy"
    }



  println(
    getName(new Cat)
  )

  println(
    getName(new Dog)
  )







}
