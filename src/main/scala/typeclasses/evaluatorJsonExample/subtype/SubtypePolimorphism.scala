package typeclasses.evaluatorJsonExample.subtype


/**
  * Created by raitis on 01/08/2016.
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

  // use converter
  def write(value: JsonConvertible): String = write(value.convertToJson)

}


trait JsonConvertible {
  def convertToJson: JsonValue
}

// converting interface
// but it is a dependency
// subtype polimorphism
sealed trait Expression extends JsonConvertible

case class Number(v: Int) extends Expression {
  def convertToJson: JsonValue = JsonNumber(v)
}
case class Plus(leftExpression: Expression, rightEhpression: Expression) extends Expression {
  def convertToJson: JsonValue = JsonObject(
    Map(
      "op"  -> JsonString("+"),
      "lhs" -> leftExpression.convertToJson,
      "rhs" -> rightEhpression.convertToJson
    ))
}
case class Minus(leftExpression: Expression, rightEhpression: Expression) extends Expression {
  def convertToJson: JsonValue = JsonObject(
    Map(
      "op"  -> JsonString("-"),
      "lhs" -> leftExpression.convertToJson,
      "rhs" -> rightEhpression.convertToJson
    ))
}






object ExpressionEvaluator {
  def eval(expression: Expression): Int = expression match {
    case Number(x) => x
    case Plus(x,y) => eval(x) + eval(y)
    case Minus(x,y) => eval(x) - eval(y)
  }
}




object EvaluatorJsonExample extends App {
  println(
    ExpressionEvaluator.eval(Plus(Number(3),Number(3)))
  )
  println(
    ExpressionEvaluator.eval(Minus(Number(3),Number(2)))
  )
  println(
    ExpressionEvaluator.eval(Number(5))
  )
  println(
    JsonOutput.write(Minus( Number(12), Plus( Number(3), Number(4) ) ))
  )
}
