
package question7

object SortingLists extends App {
  
  def isort(xs: List[List[Symbol]]): List[List[Symbol]] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail));     
    
  def insert(x: List[Symbol], xs: List[List[Symbol]]): List[List[Symbol]] =
    if (xs.isEmpty) List(x)
    else if (x.length > xs.head.length) xs.head :: insert(x, xs.tail)
    else x :: xs

var mylist: List[List[Symbol]] = List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e),
List('i, 'j, 'k, 'l), List('m, 'n), List('o))

println(isort(mylist))










var counts = new scala.collection.mutable.HashMap[Int, Int]
  
def addCounts(i: Int) = {
    if (counts.contains(i))
        counts.put(i, counts(i) + 1)
    else
        counts.put(i, 1)
}


 def isortFreq(xs: List[List[Symbol]]): List[List[Symbol]] =
    if (xs.isEmpty) Nil
    else {addCounts(xs.head.length); insertFreq(xs.head, isort(xs.tail));}
    
    
  def insertFreq(x: List[Symbol], xs: List[List[Symbol]]): List[List[Symbol]] =
    if (xs.isEmpty) List(x)
    else if (x.length > xs.head.length) xs.head :: insertFreq(x, xs.tail)
    else x :: xs


}