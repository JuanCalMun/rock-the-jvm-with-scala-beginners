package exercises

import scala.annotation.tailrec

abstract class MyList[+A] {
  /*
  *   head      =>   first element of the list
  *   tail      =>   remainder of the list
  *   isEmpty   =>   is this list empty
  *   add(int)  =>   new list with this element added
  *   toString  =>   a string representation of the list
  */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  @tailrec
  private def reverseHelper[B >: A](acc: MyList[B] = Empty): MyList[B] =
    if (tail isEmpty) acc.add(head)
    else tail.reverseHelper(acc.add(head))

  def reverse: MyList[A] = this.reverseHelper()

  override def toString = s"[$printElements]"
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if (tail isEmpty) head.toString
    else s"$head, ${tail printElements}"
}

object ListTest extends App {
  val list: MyList[Int] = new Cons(1, Empty)
  val list2: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  val list3: MyList[Int] = list add 2 add 3 add 4 add 5 add 6 add 7 add 8
  val stringList: MyList[String] =
    new Cons("Hello",
      new Cons("my",
        new Cons("name",
          new Cons("is",
            new Cons("Jesus",
              Empty)))))
  println("list: " + list)
  println("list2: " + list2)
  println("list3: " + list3)
  println("rlist3: " + list3.reverse)
  println("stringList: " + stringList)
  println("rstringList: " + stringList.reverse)
}