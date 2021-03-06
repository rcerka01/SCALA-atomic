package typeclasses.evaluatorJsonExample.sugar

package typeclasses.evaluatorJsonExample

/**
  * Created by raitis on 01/08/2016.
  * https://www.youtube.com/watch?v=sVMES4RZF-8
  */

sealed trait JsonValue
case class JsonObject(values: Map[String, JsonValue]) extends JsonValue
case class JsonArray(values: Seq[JsonValue]) extends JsonValue
case class JsonString(value: String) extends JsonValue
case class JsonNumber(value: BigDecimal) extends JsonValue
case class JsonBoolean(value: Boolean) extends JsonValue
case object JsonNull extends JsonValue

object JsonOutput {

  def write(jv: JsonValue): String = jv match {
    case JsonObject(x) => {
      val objects = for ((key, value) <- x ) yield key + ": " + write(value)
      "( " + (objects mkString ", ") + " )"
    }
    case JsonArray(x) => val elements = x.map(write)
      "[ " + (elements mkString ", ") + " ]"
    case JsonString(x) => "\"" + x + "\""
    case JsonNumber(x) => x.toString()
    case JsonBoolean(x) => x.toString
    case JsonNull => "null"
    case _ => "error"
  }

  ///////////////////////////////////////// sugar
  // pass converter implicitly
  def write[A: Json](value: A): String = {
    val converter = implicitly[Json[A]]
    write(converter.convertToJson(value))
  }
  /////////////////////////////////////////

}

sealed trait Expression
case class Number(v: Int) extends Expression
case class Plus(leftExpression: Expression, rightEhpression: Expression) extends Expression
case class Minus(leftExpression: Expression, rightEhpression: Expression) extends Expression



// Type-class (- Minus, Plus, Number are subclasses of Expression)
trait Json[-A] {
  def convertToJson(value: A): JsonValue
}


object ExpressionEvaluator {
  // evaluator
  def eval(expression: Expression): Int = expression match {
    case Number(x) => x
    case Plus(x,y) => eval(x) + eval(y)
    case Minus(x,y) => eval(x) - eval(y)
  }
}




object EvaluatorJsonExample extends App {

  // converter, instance of typeclass
  // IMPLICIT!!!!
  implicit val expressionJsonConverter = new Json[Expression] {
    def convertToJson(expression: Expression): JsonValue = expression match {
      case Number(n)  => JsonNumber(n)
      case Plus(l, r) => JsonObject(
        Map(
          "op"  -> JsonString("+"),
          "lhs" -> convertToJson(l),
          "rhs" -> convertToJson(r)
        ))
      case Minus(l, r) => JsonObject(
        Map(
          "op"  -> JsonString("-"),
          "lhs" -> convertToJson(l),
          "rhs" -> convertToJson(r)
        ))
    }
  }


  println(
    ExpressionEvaluator.eval(Plus(Number(3),Number(3)))
  )
  println(
    ExpressionEvaluator.eval(Minus(Number(3),Number(2)))
  )
  println(
    ExpressionEvaluator.eval(Number(5))
  )
  // pass converter implicitly
  val e = Minus(Number(12),Plus(Number(3),Number(3)))
  println(
    JsonOutput.write(e)
  )
}
