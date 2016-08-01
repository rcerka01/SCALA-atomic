/**
  * Created by raitis on 04/04/2016.
  */
package object packageobjects {

  // When case classes are involved, by default each parameter has val modifier.
  // HOWEVER
  // CAN NOT be an implicit and case class!!
  // Error:(6, 23) illegal combination of modifiers: implicit and case for: class ExtendedString

  implicit class ExtendedString(val txt: String) extends AnyVal {

    def magicRay = s"$txt Magic Ray"

  }



  implicit class ExtendedInt(val i: Int) extends AnyVal {

    def magicRayIncrement = i + 1

  }



}
