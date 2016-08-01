package companionObject

// A companion object is an object with the same name as a class or trait and is
// defined in the same source file as the associated file or trait. A companion object differs
// from other objects as it has access rights to the class/trait that other objects do not.
// In particular it can access methods and fields that are private in the class/trait.



// often use for factories

class MyClass(name: String) {
  private var score: String = "approved"
  override def toString = "Name: " + name + " score: " + score
}



object MyClass {

  def apply(d1: String, d2: String) = {
    val myclass = new MyClass(d1)
    myclass.score = d2
    myclass
  }

  def apply(d1: String) = {
    new MyClass(d1)
  }

  // or get static val
  val staticVal = "Hallo"

}


object companionObject extends App {

  println(MyClass.staticVal)
  println(MyClass("Ilva,"))
  println(MyClass("Raitis,", "rejected"))

}