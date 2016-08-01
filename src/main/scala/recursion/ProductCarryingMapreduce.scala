// Carrying - divide function with (for example) two arguments int0 function with ome argument, which return a function(!) with a second argument 
package basics

object dProduct extends App {
  
  
//////////////////////// my dumy example
  def sum(f: Int => Int): (Int, Int) => Int = {
    
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
      
    sumF
  }
    
  println("my dummy " + sum(x => x + x))
  println("my dummy " + sum(x => x + x)(3, 5))
  
  
//////////////////////// PROPER EXAMPLE
  
// PRODUCT (factorial)
  
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b)  1 // 1 because of multiplication
    else f(a) * product(f)(a + 1, b)
    
  println("PROPER product: " + product(x => x)(3, 5))
    
  // FACTORIAL IN TERMS OF PRODUCT 
  def fact(n: Int) = product(x => x)(1, n)
  
  println("PROPER factorial:" + fact(4))
  
  // MORE GENERAL VERSION (mapReduce)
    
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
    
  def productR(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
  
  def sumR(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
 
  println("PROPER GENERAL product: " + productR(x => x)(3, 5))
  println("PROPER GENERAL sum: " + sumR(x => x)(3, 5))
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
//////////////////////// my later test

  def productLAA(f: Int => Int)(a: Int, b: Int): Int = 
     if (a > b) 1
     else f(a * productLAA(f)(a+1, b)) 
  
  def factLAA(n: Int): Int =
    productLAA(x => x)(1, n)
  
  println("Sum LAA: " + productLAA(x => x)(3, 5))
  println("Fact LAA: " + factLAA(4))
  
  def generalLAA(function: Int => Int, combineFunct: (Int, Int) => Int, zeroValue: Int)(a: Int, b: Int): Int =
    if (a > b) zeroValue
    else combineFunct(function(a), generalLAA(function, combineFunct, zeroValue)(a + 1, b))
    
  def productLAAgeneral(f: Int => Int)(a: Int, b: Int) =
       generalLAA(f, (y, z) => y * z, 1)(a, b)  
       
  def sumLAAgeneral(f: Int => Int)(a: Int, b: Int) =
       generalLAA(f, (y, z) => y + z, 0)(a, b)
    
  println("productLAAgenera: " + productLAAgeneral(x => x)(3, 5))
  println("sumLAAgeneral: " + sumLAAgeneral(x => x)(3, 5))
}