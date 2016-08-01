package basics

object cdefProductSumFactorialMapReduce extends App {
  
/* 3. The sum function uses linear recursion. Can you write a tail-recursive version by filling in the ??’s?

   def sum(f: Int => Int)(a: Int, b: Int): Int = {
     def iter(a: Int, result: Int): Int = {
       if (??) ??
       else iter(??, ??)
     }
    iter(??, ??)
   }
*/
  
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
      
    def helper(a: Int, result: Int): Int = {
      if (a == b) result
      else helper(a + 1, result + f(a))
    }
    helper(a, b)
  } 
    
   println("Sum: " + sum(x => x)( 3, 5))  
   
// 4. Write a function product that computes the product of the values of functions at points over a given range.

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b)  1 // 1 because of multiplication, * by 1 and finish.
    else f(a) * product(f)(a + 1, b)
    
  println("Product: " + product(x => x)(3, 5))
  
// 5. Write factorial in terms of product.
  
   def fact(n: Int) = product(x => x)(1, n)
  
   println("Factorial:" + fact(4))

// 6. Can you write a more general function which generalises both sum and product?
   
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  
  def sumR(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
   
  def productR(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
 
  println("MapReduce sum: " + sumR(x => x)(3, 5))
  println("MapReduce product: " + productR(x => x)(3, 5))
 
}