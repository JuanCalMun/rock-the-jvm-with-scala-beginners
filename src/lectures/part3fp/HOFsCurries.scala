package lectures.part3fp

import scala.annotation.tailrec

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  //  Higher Order Function (HOF)

  //  Create a function that applies a function n times over a value x
  //  nTimes(f,n,x)
  //  nTimes(f,3,x) = f(f(f(x))) = nTimes(f,2,f(x)) = nTimes(f,1,f(f(x)))
  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println("nTimes(plusOne, 20, 1) = " + nTimes(plusOne, 20, 1))

  def nTimesBetter(f: Int => Int, n: Int): Int => Int =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println("plus10(1) = " + plus10(1))

  //  Curried functions
  val superAdder: Int => Int => Int =
    x => y => x + y
  val add3 = superAdder(3)
  println("add3(10) = " + add3(10))
  println("superAdder(3)(10)= " + superAdder(3)(10))

  def curriedFormatter(pattern: String)(x: Double): String =
    pattern.format(x)

  def standarFormat: Double => String =
    curriedFormatter("%4.2f")

  def preciseFormat: Double => String =
    curriedFormatter("%10.8f")

  println(s"standarFormat ${standarFormat(Math.PI)}")
  println(s"preciseFormat ${preciseFormat(Math.PI)}")


  /*
  *   1.  - toCurry(f: (Int,Int) => Int) => (Int => Int => Int)
  *       - fromCurry(f: (Int => Int => Int) => (Int,Int) => Int)
  *   2.  compose(f,g) => x => f(g(x))
  *       anThen(f,g) => x => g(f(x))
  */

  def toCurry(f: (Int, Int) => Int): Int => Int => Int =
    x => y => f(x, y)

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose[A, B, T](f: A => B, g: T => A): T => B =
    (x: T) => f(g(x))

  def andThen[A, B, T](f: T => A, g: A => B): T => B =
    (x: T) => g(f(x))


  def superAdder2: Int => Int => Int = toCurry(_ + _)

  println("\n\n\n-----------------  toCurry")
  println(superAdder2(4)(5))

}
