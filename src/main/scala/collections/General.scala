package collections

// SCALA IS RUNNING EXPRESSIONS NOT STATEMENTS!!!
//(one line code)


object General {
  def main(args: Array[String]) {


//    A Set[A] is a function A => Boolean,
//    which means one can check whether an element is present on it or not.
//
//    A Seq[A] is a function Int => A,
//    which means that each element in it has an index, and one can retrieve the element that is at any given index.


//    On this and the following pages, we explore hashing, a technique used (among other applications)
//    to implement Java's common map and set classes. Hashing is designed to solve the problem of needing
//    to efficiently find or store an item in a collection. For example, if we have a list of 10,000 words of
//    English and we want to check if a given word is in the list, it would be inefficient to successively compare
//    the word with all 10,000 items until we find a match. Hashing is a technique to make things more efficient by
//    effectively narrowing down the search at the outset.


    // Set
    // A set is a collection that contains no duplicate elements.
    val se = Set(1,2,3,4)
    // List (linked List) Inefficient for indexing
    // With tale recursion (head :: tale) use Lists

    // For indexing use Vector (similar to Java Array List)

    val sq = Seq(1,2,3,4)

    println(se)
    println(sq)


    // PAEALLEL COMPUTATIONS
    val list = (1 to 10000).toList
    list.map(_ + 42)
    // can be
    val listPar = list.par.map(_ + 42)
    println(listPar)

//    ParArray
//    ParVector
//    mutable.ParHashMap
//    mutable.ParHashSet
//    immutable.ParHashMap
//    immutable.ParHashSet
//    ParRange
//    ParTrieMap (collection.concurrent.TrieMaps are new in 2.10)




    // map vs foreach
    val x = List(1,2,3) map (x=>x+1)
    val y = List(1,2,3) foreach (x=>x+1)

    println("map" + x)
    println("Foreach. Is it empty?" + y)




  }
}
