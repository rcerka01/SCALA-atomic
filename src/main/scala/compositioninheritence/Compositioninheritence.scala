package compositioninheritence

class AwesomeLogger

object Compositioninheritence {
  def main(args: Array[String]) {


    trait Logger


    trait HasLogger {
      def logger: Logger
    }

    // composition with lazy val
    trait HasAwesomeLogger {
      lazy val logger = new AwesomeLogger
    }


  }
}
