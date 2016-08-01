package higherorderfunctions


object General extends App {

  // FOLD
  // use when access to income and outcome needed

  case class Foo(val name: String, val age: Int, val sex: Symbol)

  val fooList =
    Foo("Hugh Jass", 25, 'male) ::
      Foo("Biggus Dickus", 43, 'male) ::
      Foo("Incontinentia Buttocks", 37, 'female) ::
      Nil


  val stringList = fooList.foldLeft(List[String]()) { (z, f) =>
    val title = f.sex match {
      case 'male => "Mr."
      case 'female => "Ms."
    }
    z :+ s"$title ${f.name}, ${f.age}"
  }

  println(stringList)

//
//  The function is then applied to its two arguments, in this case a simple addition, and returns the result.
//  Fold then gives the function the previous return value as its first argument and the next item in the list
  // as its second argument, and applies it, returning the result.
//    This process repeats for each item of the list and returns the return value of the function once all items in the list have been iterated over.
//  This is a trivial example though. Let's take a look at something that is more useful. I will use foldLeft
  // in this next example and will explain how it is different from fold later. For now, think of it in the same way as fold.

 // Like the first example, we have a beginning—this case and empty List of Strings—and the operation function.
  // In this example we determine which title is appropriate for the current item, construct the string we want,
  // and append it to the end of the accumulator (which is a list).
}