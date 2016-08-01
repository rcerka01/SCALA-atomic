package revision1

sealed trait EvaluationTree 
final case class Term(i: Int) extends EvaluationTree
final case class Func(s:String, args:Seq[EvaluationTree]) extends EvaluationTree

object Run extends App {
  
  def print(e:EvaluationTree):String = 
    e match {
      case Term(i)       => i.toString()
      case Func(s, args) => "Func(" + s + "," + pt(args, ",") + ")"
    }
  
  
  def pt(t:Seq[EvaluationTree], sep:String):String =
    t match {
    case Nil => ""
    case hd::tl => hd + sep + pt(tl, sep)
    case s::Nil => print(s)
  }
  
  println(
     print(Func("-", Seq(Term(3),Term(4),Func("+",Seq(Term(1))))))
     )
}