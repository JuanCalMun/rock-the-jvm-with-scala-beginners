package exercises

abstract class MyList {
  /*
  *   head      =>   first element of the list
  *   tail      =>   remainder of the list
  *   isEmpty   =>   is this list empty
  *   add(int)  =>   new list with this element added
  *   toString  =>   a string representation of the list
  */

  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(element: Int): MyList

  def printElements: String

  override def toString = s"[$printElements]"
}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new Cons(element, this)

  override def printElements: String =
    if (tail isEmpty) head.toString
    else s"$head, ${tail printElements}"
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  val list2 = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  val list3: MyList = list add 5 add 6
  println(list)
  println(list2)
  println(list3)
}