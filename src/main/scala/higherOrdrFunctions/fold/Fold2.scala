/*
15. Complete the missing expressions in the following definitions of some basic listmanipulation
    operations as fold operations.
       def mapFun[A, B](xs: List[A], f: A => B): List[B] =
          (xs :\ List[B]()){ ?? }
       def lengthFun[A](xs: List[A]): Int =
          (0 /: xs){ ?? }
 */
object oFold extends App {
  
  def mapFun[A, B](xs: List[A], f: A => B): List[B] =
    (xs :\ List[B]()) { 
                        (x, xs) => f(x) :: xs
                      }
  
  def lengthFun[A](xs: List[A]): Int =
    (0 /: xs) { 
                 (sum, _) => sum + 1
              }
  
  def f(x: Int): Int = x + 1
  val list = List(1, 2, 3)
  
  println(lengthFun(list))
  println(mapFun(list, f))
  // or
  println(mapFun(list, {(x:Int) => x+1}))
}