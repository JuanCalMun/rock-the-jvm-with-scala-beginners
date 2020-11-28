package lectures.part3fp

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

  def map[B](transformer: A => B): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def ++[B >: A](list: MyList[B]): MyList[B]

  override def toString = s"[$printElements]"

  def forEach(f: A => Unit): Unit

  def sort(s: (A, A) => Int): MyList[A]

  def zipWith[B](list: MyList[B], f: (A, B) => B): MyList[B]

  def fold[B](start: B)(f: (B, A) => B): B
}


/*
*   1.  Expand MyList
*       - Foreach method A => Unit
*         [1,2,3].foreach(x=>println(x))
*
*       - Sort function ((A,A) => Int) => MyList
*         [1,2,3].sort((x, y) => y - x) => [3, 2, 1]
*
*       - zipWith (list, (A, A) => B) => MyList[B]
*         [1,2,3].zipWith(([4,5,6], x * y) => [4, 10, 18]
*
*       - fold (start)(function) => a value
*         [1,2,3].fold(0))(x + y) = 6
*
*/

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = Cons(element, Empty)

  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def forEach(f: Nothing => Unit): Unit = ()

  override def sort(s: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B](list: MyList[B], f: (Nothing, B) => B): MyList[B] = Empty

  override def fold[B](start: B)(f: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = Cons(element, this)

  override def printElements: String =
    if (tail isEmpty) head.toString
    else s"$head, ${tail printElements}"

  override def map[B](transformer: A => B): MyList[B] =
    new Cons[B](transformer(h), t.map(transformer))

  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  override def ++[B >: A](list: MyList[B]): MyList[B] =
    Cons(h, t ++ list)

  override def forEach(f: A => Unit): Unit = {
    f(h)
    t.forEach(f)
  }

  override def sort(sortBy: (A, A) => Int): MyList[A] = {
    def insertSorted(head: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList isEmpty) Cons(head, Empty)
      else if (sortBy(head, sortedList.head) <= 0) Cons(head, sortedList.sort(sortBy))
      else Cons(sortedList.head, insertSorted(head, sortedList.tail))

    val sortedTail = tail.sort(sortBy)
    insertSorted(h, sortedTail)
  }

  override def zipWith[B](list: MyList[B], f: (A, B) => B): MyList[B] =
    if (list.tail.isEmpty || tail.isEmpty) Cons(f(h, list.head), Empty)
    else Cons(f(h, list.head), tail.zipWith(list.tail, f))

  override def fold[B](start: B)(f: (B, A) => B): B = {
    t.fold(f(start, h))(f)
  }
}


object ListTest extends App {

  val evenPredicate: Int => Boolean = _ % 2 == 0

  val stringToIntTrasnformer: String => Int = _.toInt

  val duplicate: Int => Int = _ * 2

  val list: MyList[Int] = Cons(1, Empty)
  val list2: MyList[Int] = Cons(1, Cons(2, Cons(3, Cons(4, Empty))))
  val list2Clone: MyList[Int] = Cons(1, Cons(2, Cons(3, Cons(4, Empty))))
  val list3: MyList[Int] = list add 2 add 3 add 4 add 5 add 6 add 7 add 8
  val stringList: MyList[String] =
    Cons("Hello",
      Cons("my",
        Cons("name",
          Cons("is",
            Cons("Jesus",
              Empty)))))
  var stringNumberList: MyList[String] = Cons[String]("4", Empty).add("3").add("2").add("1")
  println("list: " + list)
  println("list2: " + list2)
  println("list3: " + list3)
  println("reverse list3: " + list3.reverse)
  println("stringList: " + stringList)
  println("reverse stringList: " + stringList.reverse)

  println("\n\n\n-----------------  Functions with traits")
  println("list2: " + list2)
  println("evenList2: " + list2.filter(evenPredicate))
  println("tramsformList2 x2: " + list2.map(duplicate))
  println("tramsformList2 x2: " + list2.map(e => e * 2))

  println("stringNumberList: " + stringNumberList)
  println("stringToNumberList: " + stringNumberList.map(stringToIntTrasnformer))

  println("list2 ++ list3: " + (list2 ++ list3))

  println("list3 flatMap [n,n+1]: " + list3.flatMap(e => Cons[Int](e, Cons[Int](e + 1, Empty))))

  println("\n\n\n-----------------  Use of Case")
  println("list2: " + list2)
  println("list2Clone: " + list2Clone)
  println("list2 == list2Clone: " + (list2 == list2Clone))


  println("\n\n\n-----------------  For Each")
  println("list2.forEach(println)")
  list2.forEach(println)

  println("\n\n\n-----------------  Sort")
  println("list2.sort((x, y) => y - x)")
  println(list2.sort((x, y) => y - x))

  println("\n\n\n-----------------  Fold")
  println(list2.fold(20)(_ + _))

  println("\n\n\n-----------------  For comprehensions")
  private val forComprehensions: MyList[String] = for {
    l2 <- list2
    l3 <- list3
  } yield s"$l2:$l3"
  println(s"forComprehensions: $forComprehensions")


}