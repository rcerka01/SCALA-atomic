package objects

// Objects cannot be istantiated (obviously)

object Obj1 { def inst = new Cl1("Artur") }

case class Cl1(s: String)

object Examples {
  def main(args: Array[String]) {

  val o = Obj1.inst.s

    println(o)

  }
}
