package AssertRequireAssume

/**
  * Created by raitis on 12/01/2016.
  *
  * they are methods for performing certain checks during runtime to verify certain conditions.
  * They do not use the Java assert framework and therefore are always evaluated regardless of whether or not assertions are enabled.
  *
  * Very similar, only different Errors
  */

object Base extends App {


  // ASSERT
  // demonstrating that the method is in fact called when the assertion fails

  var called = 0
  // var called = 1

  assert (called == 0, { called += 1; println("called is not 0, now: " + called) })


  // REQUIRE
  // Require is intended to be used as a precondition of a method so
  // it throws an IllegalArgumentException, not an AssertionError

  var called1 = 0
  // var called1 = 1

  require ( called1 == 0, {called1 += 1; println("called is not 0. now: " + called1) })


  // ASSUME

  //var called2 = 0
  var called2 = 1

  assume ( called2 == 0, {called2 += 1; println("called is not 0. now: " + called2) })

}
