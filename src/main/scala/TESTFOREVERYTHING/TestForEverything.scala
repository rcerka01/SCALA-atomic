package revision2

object Runer extends App {


  val al = List(1,2,3)
  val bl = List(3,4,5)

  
  // LIST TO LIST BUT CAN USE ALSO FOR ELEMENTS
  // Returns a new list containing the elements from the left hand operand followed by the elements from the
  // right hand operand. The element type of the list is the most specific superclass encompassing the element types
  // of the two operands.
  println("++")
  // a left hand elements + right hand elements
  println(
    al ++ bl
  )
  // this is no problem
  println(
    al ++ "a" ++ "1"
  )




  println("++:")
  // It differs from ++ in that the right operand determines the type of the resulting collection rather than the left one.
  // Mnemonic: the COLon is on the side of the new COLlection type.
  // same as ++ but new list will be with type as right side element (usually add more specific type, example LinkedList etc.)
  println(
    al ++: bl
  )
  // ok
  println(
    al ++: "a" ++: "1"
  )
  // :++ not exist
  //  println(
  //    a :++ "a" :++ "1"
  //    )


  // ELEMENT TO LIST ONLY
  // copy of the list with an element prepended.
  println("+:")
  println(
    al :+ 9
  )
  // or :+
  //  A copy of this list with an element appended.
  println(
    9 +: al
  )



  // :: takes List and produces List, while +: is more generic form, that can build other collections - like Vector or ArrayBuffer
  // :: prepends a single item whereas ::: prepends a complete list. So, if you put a List in front of :: it is taken as one item,
  // which results in a nested structur
  // Adds an element at the beginning of this list.
  println("::")
  println(
    al :: bl
  )

  // Adds the elements of a given list in front of this list.
  println(":::")
  println(
    al ::: bl
  )


 
  /////////////// RANGE
  val r: Range = 1 until 10 by 3 
  println("Range: " + r)
  
  /////////////// ZIP  
  val l = List(1,2,3) zip List("a", "b", List("a", "b", "c"))
  println("List zip: " + l)
  val t = List(1,2) zip Seq(1,2,3)
  println("zip diferent types: " + t)
  
  /////////////// FLATMAP only work on List of Lists
  //it applies higher level function and concatinate lists together 
  val l2 = List(List(1,2,3),List(4,5,6)).flatMap { x => x}
  println("flatMap: " +l2)  
  // not work val l3 = List(1,2,3).flatMap(x => x) 
  val s1 = Seq(Seq(1,2,3),Seq(4,5,6)).flatMap { x => x.map(_*2) }
  println("Sequence *2 : " + s1)
  val v1 = Vector(Vector(1,2,3),Vector(4,5,6)).flatMap { x => x.zip(List('a','b','c','d')) }
  println("Vector zip: " + v1)
  
  /////////////// ARRAY
  val a1 = Array(Array(1,2,3),Array(4,5,6)).flatMap { x => x.filter(_ > 2)  }
  a1 foreach {x => print(x.toString)}
  
  /////////////// TUPLE
  // groups two elements without using class
  val t1 = (1,2)
  println("\nTuple: " + t1._1)
  //t1.filter
  
  /////////////// FLATTEN
  val v2 = Vector(Vector(1,2),List('a','b')).flatten
  println("Flatten diferent types: " + v2)
  // val v22 = List(1,2,3,4,List(1),List(2)).flatMap{x=>x}
  
  /////////////// FIND vs FILTER
  // find returns first element that match
  val s2 = Seq(1,2,3,4)
  println("filter: " + s2.filter { x => x > 1 })
  println("find: " + s2.find { x => x > 1 })
  
  /////////////// PARTITION
  val l3 = List(1,2,3,4,5,6,7,8,9).partition { x => x % 3 == 0 }
  println("partition: " + l3)
  
  /////////////// DROP
  // drops first n elements
  val v3 = Vector(1,2,3,4,5).drop(2)
  println("drop: " + v3)
  
  
  /////////////// FOLD
  val v6 = Vector(1,2,3,4).fold(5)(_+_)
  println("fold: " + v6)
  val v66 = List(1,2,3).fold(0){(x:Int, y:Int)=>x+y}
  //((x, y)=>x+y)
  println(v66)
  
  /////////////// MAP
  val l4 = List(1,2,3).map(x=> x+2)
  val l5 = List(1,2,3).map(_+2)
  val l6 = List(1,2,3).map(_ + l.length)
  println("map: " + l4)
  println("map: " + l5)
  println("map: " + l6)
  
  /////////////// REDUCE
  val s3 = Seq(1,2,3,4).reduce((x,y) => x + y)
  val s4 = Seq(1,2,3,4).reduce(_*_)
  val s44 =Seq(List(1,2),List(3,4),List(5,6)) reduce ((x,y) => x)
  println("r" + s44)
  println("reduce: + " + s3)
  println("reduce: * " + s4)
  
  /////////////// COLLECT
  val l7 = Seq(1,2,3,"asa", List(1,2)).collect {case x:Int=>x+1 
                       case y:String => "String value: " + y 
                       case _        => "Error"
                       }
  println("collect: " + l7)
  
  /////////////// MAP
  val m1 = Map(1->2, "a"->"b", 2->"a")
  val m2 = Map(1->2, "a"->"b", 2->"a").size
  println("map size: " + m2)
  println("map('1'): " + m1(1))
  println("map.contains: " + m1.contains(1))
  
  /////////////// ADD ELEMENT
  val a = Vector('a','b')
  println('f' +: a)
  println(a :+ 'f')
  
  ////////////// MIN MAX
  val l8 =List(1,2,3).max
  val l9 =List('a', 'b', 'c').min
  // not work List(1,2,3,"a").max
  val a2 = Array(1,2,3).max
  println("max: " + l8)
  println("min: " + l9)
  
  ////////////// ALL COMBINATIONS
  val comb = (1 to 4) map (x => (4 to 8) map (y => (x,y)))
  val comb2 = (1 to 4) flatMap (x => (4 to 8) map (y => (x,y)))
  println(comb)
  println(comb2)
  
  ////////////// TUPLE
  val v = (1,2,3)
  println(v._3)
  
  ////////////// PRODUCT WITH TWO VECTORS
  def product(x:Vector[Double], y:Vector[Double]):Double =
    x zip y  map {v => v._1 * v._2} sum
    
  println(product(Vector(1,2,3,4),Vector(5,6,7,8)))  
    
  def product2(x:Vector[Double], y:Vector[Double]):Double =
    x zip y map {
                  case (a,b) => a * b
                } sum
    
  println(product2(Vector(1,2,3,4),Vector(5,6,7,8)))  
                
  ///////////// TAKE
  val s5 = Seq(1,2,3,4) take(2)
  println("take: " + s5)

  //////////////////////
  
  def avrg(a:Int, b:Int):Double = {
       def helper(a:Int, b:Int, result:Int):Double = {
           if (a == b) result
           else helper(a+1, b, a+b)        
       }
       helper(a,b,0)/b-a
   }
                
  println(avrg(3,5))   
  
  /////////////////////////////////
  def avrg2(s: Seq[Int], a:Int, b:Int):Double = {
    val t1 = s.drop(a)
    val t2 = t1.take(b-a)
    (t2 reduce ((x,y)=>x+y)) / (t2 length)
  }
  
  println(avrg2(Seq(1,2,3,4,5,6), 4,5))
  
  ////////////////////////////////////////////
  
  def pict(n:Int):List[String] = {
    
    def helper(n:Int, r:List[String]):List[String] = {
      n match {
        case 1 => r
        case n => {
                   var top = r.map(x => " " * x.length + x )
                   var bottom = r.map(x => x + x)
      
                   helper(n-1, top:::bottom) 
                   }      
        } 
    }
    
    helper(n, List(" |","/|"))
  }
  
  pict(3).foreach { x => println(x)} 
  
  ///////////////////////////////
  
  def rev[T](l:List[T]):List[T] = {
    l.foldLeft(List[T]())((a,b) => b::a);
  }
  
  println(rev(List(1,2,3)))
  
  ///////////////////////////////
//  
//  def filt[T](f:T => Boolean)(l:List[T]):List[T] = {
//      l match {
//        case Nil => List()
//        case x::y =>
//                if (f(x)) List(x)
//                else y.filt(f)
//      }
//  }
  
  //////////////////////////
  
  def leng[T](l:List[T]):Int = {
    def help(l:List[T], r:Int):Int ={
     l match {
       case Nil  => r
       case x::y => help(y, r+1)
      }
    }
    help(l, 0)
  }
  
  println(leng(List(1,2,3,4,"edf")))
  
  /////////////////////////////////////////
  def car(a:Int)(b:Int):Int = {
    a+b
  }
  
  println(car(2)_)
  
  ////////////////////////////////////////
  
  def func(f:Int=>Boolean)(l:List[Int]):List[Int] = {
    l match {
      case Nil   => Nil
      case h::tl => if (f(h)) h::func(f)(tl)
                    else func(f)(tl)
    }
  }
  
     println(
        func(x=> x>2)(List(1,2,3,4,5))
        )
        
   ///////////////////////////////////////
   
   def map[T](f:T=>T)(l:List[T]):List[T] = {
       l match {
         case Nil => Nil
         case h::t => f(h)::map(f)(t)
       }
     }
     
    println( map ((x:Int) => x + 1)(List(1,2,3,4)) )
  
}
  
