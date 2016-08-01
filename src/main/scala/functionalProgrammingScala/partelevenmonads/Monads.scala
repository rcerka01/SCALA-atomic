package functionalProgrammingScala.partelevenmonads

/**
  * Created by raitis on 08/04/2016.
  */



trait F[_] {
  def map[A,B](fa: F[A])(f: A => B): F[B]
}



class Monads {



}
