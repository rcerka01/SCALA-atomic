package revision1

object Expression extends App {

  println(Exp.evaluate(Plus(Mul(Num(3), Num(4)), Sub(Num(3), Num(4)))))
  println(Integr.evaluation(Div2(Num2(15),Num2(3))))
}

sealed trait Exp

final case class Num(n: Int) extends Exp

final case class Plus(n1: Exp, n2: Exp) extends Exp

final case class Mul(n1: Exp, n2: Exp) extends Exp

final case class Sub(n1: Exp, n2: Exp) extends Exp

object Exp {
  def evaluate(e: Exp): Int = e match {
    case Num(n) => n
    case Plus(n1, n2) => evaluate(n1) + evaluate(n2)
    case Mul(n1, n2) => evaluate(n1) * evaluate(n2)
    case Sub(n1, n2) => evaluate(n1) - evaluate(n2)
  }
}























sealed trait Integr

final case class Num2(n1:Int) extends Integr
final case class Sum2(n1:Integr, n2:Integr) extends Integr
final case class Min2(n1:Integr, n2:Integr) extends Integr
final case class Div2(n1:Integr, n2:Integr) extends Integr

object Integr {
  def evaluation(i: Integr):Int ={
    i match {
      case Num2(x)   => x
      case Sum2(x,y) => evaluation(x) + evaluation(y)
      case Min2(x,y) => evaluation(x) - evaluation(y)
      case Div2(x,y) => evaluation(x) / evaluation(y)    
    }
  }
  
}