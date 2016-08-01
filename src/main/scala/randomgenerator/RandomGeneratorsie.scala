package randomgenerator

// case classes can be pattern matching (even optimized for compiler)
// cc do automatically define getters and setters for constructor arguments


/*
 * A companion object is an object with the same name as a class or trait and is defined 
 * in the same source file as the associated file or trait. A companion object differs from
 * other objects as it has access rights to the class/trait that other objects do not. 
 * In particular it can access methods and fields that are private in the class/trait. 
 * 
 * class MyString
 * object Mystring
 *  
 *  Used to build factories.
 */

/*
class Company[T](val company:T)
class BigCompany
class SmallCompany extends BigCompany
class Investor(val company: Company[BigCompany])
 * 
 * But what is the relation between Company[SmallCompany] and Company[BigCompany] ? 
 * It is not defined by default and we need somehow to tell compiler about this. 
 * In order to solve this we change class Company by adding +  to generics.
 * 
 * This means that subtyping is covariant (flexible) in paramter T.
 */

object Runer extends App {

trait Generator[+T] {
  
  self => def generate: T
    
  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {    
     def generate = f(self.generate).generate
  }
  
  def map[S](f: T => S): Generator[S] = new Generator[S] {
     def generate = f(self.generate)
  }

  implicit def integers: Generator[Int] = new Generator[Int] {
     def generate = scala.util.Random.nextInt()
  }
  
  implicit def choose(lo: Int, hi: Int): Generator[Int] = new Generator[Int] {
     def generate = scala.util.Random.nextInt(hi - lo) + lo
  }
  
  //////////// TASK ***
  def oneOf[T](ls: List[T]): Generator[T] = new Generator[T] {
     def generate =  ls(choose(0, ls.length).generate)
  }
 //////////// ***

}

//////////////////////////////////////////

case class Pie (kind: String)  {
  

  val pieKinds = List("Stewed Eals", "Jellied Eels", "only beef", "no mush or liquor")
  
  val pieNumbers: String => Int = {x =>
      x match {
        case "Stewed Eals"        => 1
        case "Jellied Eels"       => 2
        case "only beef"          => 1
        case "ono mush or liquor" => 3
        case _                    => throw new Error("bla bla")
      }} 

}

/////////////////////////////////////////  

val positiveInt = new Generator[Int] { 
  def generate: Int = 0
  def positives: Generator[Int] = integers.map{x => if(x < 0) -x else x}
}

val pieKinds = List("Stewed Eals", "Jellied Eels", "only beef", "no mush or liquor")

//////////// TASK *** 
val listGen = new Generator[String] { 
  def generate: String = ""
  def listGenNumb: Generator[String] = oneOf(pieKinds)
}

// val pieGen: Generator[Pie] = ???
val pieGen: Generator[Pie] = new Generator[Pie] { 
  def generate: Pie = Pie(listGen.listGenNumb.generate)
}

  /// OUT
println(positiveInt.positives.generate)
println(listGen.listGenNumb.generate)
println(pieGen.generate)
}