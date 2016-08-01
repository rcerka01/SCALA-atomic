package implicits

/**
  * Created by raitis on 23/03/2016.
  */
package object implicitClass {

  implicit class ExtendedString(val text: String) extends AnyVal {

    def addMyString = s"Yo $text"

  }

}
