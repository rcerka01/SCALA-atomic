object nFlatten extends App {
  
 val listOne = List(1, 2)
 val listTwo = List(3, 4)
 
 println("listOne: " + listOne)
 println("listTwo: " + listTwo + "\n")
 
 println("Concatination: " + {listOne ::: listTwo} +"\n")
 
 println("Definitions:")
 println(1 :: 2 :: List(3))
 println(1 :: 2 :: 3 :: Nil)
 println(listOne ++ listTwo)
 println(listOne + "ok")
 println()

def flattenLeft[A](xs: List[List[A]]): List[A] =
    (xs :\ (Nil: List[A])) 
       { (a, b) => a ::: b }

def flattenRight[A](xs: List[List[A]]): List[A] =
    ((Nil: List[A]) /: xs)
       {(a, b) => a ::: b}

val testList = List(List(1,2),List(3,4))
 
println("testList: " + testList)
println("flattenLeft: " + flattenLeft(testList))
println("flattenRight: " + flattenRight(testList) + "\n")
 
 
println("foldLeft for listOne, listOne.foldLeft(0)(_+_): " + listOne.foldLeft(0)(_+_))
println("(0 /: listOne) {(a,b)=>a+b} " + (0 /: listOne) {(a,b)=>a+b})
println("(listOne :\\ 0) {(a,b)=>a+b} " + (listOne :\ 0) {(a,b)=>a+b})


}