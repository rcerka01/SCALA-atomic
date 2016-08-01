package typeclasses

// type parameters must be declared in the definition of a class, and must be bound to a real
// type when instantiating that class.
// This is very similar to using a method parameter instead of a concrete value in a method body.




abstract class Fruit { def name: String }
class Apple extends Fruit { def name = "Apple" }
class Orange extends Fruit { def name = "Orange" }

// 1 REPLACE
// abstract class Box { def fruit: Fruit }
// class OrangeBox(orange: Orange) { def fruit = orange }
// class AppleBox(apple: Apple) { def fruit = apple }

// as it depends from Apple or orange argument which IS SUBTYPE OF FRUIT (upper type bond)
// class Box (fruit: Fruit) { def getFruit: Fruit = fruit } // still fine
// additional type safety so F is definetly subclass of Fruit
 class Box [+F <: Fruit] (fruit: F) { def getFruit: Fruit = fruit } // still fine


object Covariance {
  def main(args: Array[String]) {
     // 1 REPLACE
     // val appleBox = new AppleBox(new Apple)
     // val orangeBox = new OrangeBox(new Orange)

     val appleBox  = new Box(new Apple)
     val orangeBox = new Box(new Orange)
     val appleBox2:  Box[Fruit] = new Box[Fruit](new Apple()) // ok
     //val orangeBox2: Box[Fruit] = new Box[Orange](new Orange()) // do not compile,
     // because Box[Fruit] and Box[Orange] ar not realated



    // VARIANCE
    //by adding +F define variance
    val orangeBox2: Box[Fruit] = new Box[Orange](new Orange())




///////////////////////////
// COvariance Int is subtype of Any. CONTRAvariance is on opposite
    val x = List(1,2,3)
    val y:List[Any] = x





  }
}
