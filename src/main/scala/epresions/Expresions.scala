package epresions

import scala.collection.mutable

// SCALA IS RUNNING EXPRESSIONS NOT STATEMENTS!!!
//(one line code)

/**
  * Created by raitis on 25/11/2015.
  */
case class Address(city: String)
case class People(addresses: Seq[Address])

object Expresions {
  def main(args: Array[String]) {


    val addr1 = new Address("Malmo")
    val addr2 = new Address("Geteborg")
    val addr3 = new Address("Riga")

    val somepeople = Seq( new People(Seq(addr1, addr3)), new People(Seq(addr2, addr3)) )


     // (String, Seq) => Set
     def countPeople(city:String, people: Seq[People]): Set[People] =
         for {
           person  <- people.toSet[People]
           address <- person.addresses
           if address.city == city
         } yield person

     println(countPeople("Malmo", somepeople))



    // STATEMENTS (Java style) WOULD BE

//    def countPeopleS(city:String, people: Seq[People]): Set[People] = {
//      val found = new mutable.HashSet[People]
//      for (person <- people) {
//        for (address <- person.addresses) {
//          if (address.city == city)
//            found.put(person)
//        }
//      }
//      return found
//    }

    // don't do this


  }
}
