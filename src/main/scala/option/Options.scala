package option


object Options {
  def main(args: Array[String]) {

    // PROTECT FROM NULL EXCEPTION, can use loop etc.

    // two states
    println(
       Option(1)
    )

    val x = Option("defe")
    println(
      x.get
    )

    println(
      Option(null)
    )

  }
}