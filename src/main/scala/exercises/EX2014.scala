package exercises

/**
  * Created by raitis on 03/12/2015.
  */

object EX2014 extends App {

  val list1 = List(List("a", "b", "c"), List("d", "e"), List("f", "g", "h"), List("d", "e"), List("i", "j", "k", "l"), List("m", "n"), List("o"))

  // 1.
  def lsort(l:List[List[Any]]):List[List[Any]] = {
    l.sortBy(x => x.length)
  }

  println(lsort(list1))


  // 2.
  def lsortFreq(l:List[List[Any]]) = {

    l
      .groupBy(x => x.length)
      .toList
      .sortBy(x => x._2.length)
      .map (x => x._2)
  }

  println(lsortFreq(list1))
}
