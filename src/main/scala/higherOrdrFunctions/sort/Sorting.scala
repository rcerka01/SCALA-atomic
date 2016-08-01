/*
10.   As an example of how lists can be processed, consider sorting the elements of a list
    of numbers into ascending order. One simple way to do so is insertion sort, which
    works as follows:
      To sort a non-empty list with first element x and rest xs, sort the
    remainder xs and insert the element x at the right position in the result.
    Sorting an empty list will yield the empty list.
      Expressed as Scala code:
            def isort(xs: List[Int]): List[Int] =
                 if (xs.isEmpty) Nil
                 else insert(xs.head, isort(xs.tail))
    Provide an implementation of the missing function insert.
 */


// Lists are Immutable
// Lists are recursive
// Lists has more operations than Array
// :: cons - constraction operation

object jSorting extends App  {
  
  val fruit = List("apples", "oranges", "pears")
  println(fruit + " same as:")
  val fruit2 = "apples" :: ("oranges" :: ("pears" :: Nil)) // printacies can be redundand
  println(fruit2)
  println()
  
  val list =  List(2,1,4,6,12,21,7,5)
  val list2 = List(2,1,4,3)
  val list3 = List(2,1,4,3)
  
  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))
    
  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty) List(x)
    else if (x > xs.head) xs.head :: insert(x, xs.tail)
    else x :: xs
    
    println(list)
    println(isort(list))
}