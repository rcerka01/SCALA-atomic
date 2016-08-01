package codility

/**
  * Created by raitis on 27/01/2016.
  */

class IntList(var value: Int, var next: IntList)

object PointerLinkedList extends App {

  def solution(L: IntList): Int = {
    def helper2(l: IntList, c: Int):Int = {

      if (l.next != null) helper2(l.next, c +1)
      else c

    }

    helper2(L, 1)
  }


}

