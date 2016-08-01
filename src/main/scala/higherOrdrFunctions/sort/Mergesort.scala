/*
Question 4 . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . Total: 9 marks
The mergesort algorithm for sorting lists consists of two steps:
1. Split a given list in two, and recursively call the sort algorithm on both sub-lists.
2. Merge the two resulting sorted lists into a single, sorted list, in linear time.
In this question, you are required to implement the merge step of the sorting algorithm.
This function should work on generic lists.
(a) Implement the merge function. It takes two sorted lists, and a comparator func- 5 marks
    tion, and returns a single list, which contains the elements of the two input lists,
    sorted. The two input lists are also sorted according to the comparator function.
     The implementation of merge should be recursive (not tail recursive), and use
     pattern matching on lists:
          def merge[T](as: List[T], bs: List[T])(cmp: (T, T) => Boolean): List[T] = ???
     The cmp function takes two arguments, and returns true if the rst argument is
     less than or equal to the second argument.
      For example,
      merge(List(1, 4, 7, 10, 11), List(2, 3, 5, 7, 12, 16))((x, y) => x <= y)
      should return
      List(1, 2, 3, 4, 5, 7, 7, 10, 11, 12, 16)
(b) Implement a function merge2, which is the same as merge, except that it is tail- 4 mark recursive.
        def merge2[T](as: List[T], bs: List[T])(cmp: (T, T) => Boolean): List[T] = ???
    Note: Both merge and merge2 are expected to have a linear running time.
*/

package question4

object Mergesort extends App {
  
  def merge[T](as: List[T], bs: List[T])(cmp: (T, T) => Boolean): List[T] = {
      (as, bs) match {
        case (_, Nil) => as
        case (Nil, _) => bs
        case (a::ass, b::bss) => 
          if (cmp(a,b)) a::merge(ass,bs)(cmp)                 
          else b::merge(as,bss)(cmp)
      }
  } 
  
  def mergeTail[T](as: List[T], bs: List[T])(cmp: (T, T) => Boolean): List[T] = {
    
    def loop(listOne:List[T], listTwo:List[T], result:List[T]):List[T] = {
      (listOne, listTwo) match {
        case (_, Nil) => result.reverse ++ listOne
        case (Nil, _) => result.reverse ++ listTwo
        case (a::ass, b::bss) => 
          if (cmp(a,b)) loop(ass, listTwo, a :: result)
          else loop(listOne, bss, b :: result)
      }
    }
      
      loop(as, bs, Nil)
  }
  
  println(merge(List(1, 4, 7, 10, 11), List(2, 3, 5, 7, 12, 16))((x, y) => x <= y))
  println(mergeTail(List(1, 4, 7, 10, 11), List(2, 3, 5, 7, 12, 16))((x, y) => x <= y))
}