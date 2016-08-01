package exercises

/**
  * Created by raitis on 02/12/2015.
  */

object EX2015 extends App {

  type Result = (String, Int)
  type Quiz   = Seq[Result]
  type Course = Seq[Quiz]

  val r1: Result = ("Tom", 5)
  val r2: Result = ("Tom", 6)
  val r3: Result = ("Bob", 6)
  val r4: Result = ("Ali", 1)

  val q1: Quiz  = Seq(r1, r3)
  val q2: Quiz  = Seq(r2, r4)

  val c1: Course = Seq(q1, q2)


  def quizMeans(course: Course): Seq[Float] = {
    course map ( quiz => (quiz map ( result => result._2.toFloat )).sum / quiz.length )
  }

  def studentMeans(course: Course): Map[String, Float] = {
    course flatMap (students => students) groupBy( group => group._1 ) map ( part=> (part._1, (part._2).map( sublist =>sublist._2.toFloat ).sum / part._2.length ))
  }

  def topStudents(course: Course, n: Int):Seq[String]  = {
    studentMeans(course)
      .toList
      .sortBy(value =>value._2)
      .reverse.take(n)
      .map(result=>result._1)
  }

  def passingStudents(course: Course): Seq[String] = {
    studentMeans(course)
      .toList
      .filter(grade => grade._2 > 3.5)
      .map(result => result._1)
  }

  type Histogram = Map[Int, Int]

  def histogram(course: Course):Histogram  = {

     studentMeans(course)
       .toList
       .map(s=>(s._1,math.round(s._2)))
       .groupBy( group => group._2 )
       .map (r => (r._1, r._2.length))
  }



  println(quizMeans(c1))
  println(studentMeans(c1))
  println(topStudents(c1, 3))
  println(passingStudents(c1))
  println(histogram(c1))

}