import java.text.SimpleDateFormat
import scala.io.StdIn._

/**
  * Created by raitis on 30/06/2016.
  */

object Main extends App {

  val roughInput = readLine()

  // to Array
  val preInput: Array[String] = roughInput.split("/")

  // normalize Array (add 0, if missing)
  val input: Array[String] = preInput map (d => if (d.length == 1) "0" + d else d)

  // input Date format
  var dateFormat = new SimpleDateFormat("yy/MM/dd")
  dateFormat.set2DigitYearStart(dateFormat.parse("2000/01/01"))
  dateFormat.setLenient(false)

  // run all combinations and try to built an Option Date objects
  val dates = for {
    i <- input.indices
    j <- input.indices
    k <- input.indices
    if i != j && j != k && k != i
  } yield {
    try {
      Some(dateFormat.parse(input(i) + "/" + input(j) + "/" + input(k)))
    }
    catch {
      case e: Exception => None
    }
  }

  // flatten and sort resulting Seq
  val result = dates.flatten sortBy (_.getTime)

  // format for output
  val dateFormatForOutput = new SimpleDateFormat("yyyy-MM-dd")

  // try first, if cannot built Date, input is invalid
  try {
     println(dateFormatForOutput.format(result.head))}
  catch {
    case e: Exception => println(s"$roughInput is illegal")
  }

}
