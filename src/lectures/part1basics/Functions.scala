package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def inlineFunction(a: String, b: Int) = s"a $b"

  def senseLessFunction(a: String, b: Int, c: Int): String = {
    if (a.isEmpty) {
      return s"b + c = ${b + c}"
    }
    if (b > c) b.toString else c.toString
  }

  def repeatStringFunction(string: String, times: Int): String = {
    if (times == 1) string
    else string.concat(" ").concat(repeatStringFunction(string, times - 1))
  }

  println(repeatStringFunction("Hello", 5))

  def bigRepeatString(string: String, times: Int) = {
    println("Start bigRepeatString")

    def concatStringRepeat(n: Int): String =
      if (n == 1) string
      else string.concat(" ").concat(concatStringRepeat(n - 1))

    println("Finish bigRepeatString")
    concatStringRepeat(times)
  }

  println(bigRepeatString("Goodbye", 5))


  /*
  *  1. Greeting function (name,age) -> "Hi my name is name and im age years old"
  */

  def greetings(name: String, age: Int) = s"Hi my name is $name and I'm $age years old"

  println(greetings("Juan", 27))

  /*
  *  2. Factorial function 1 * 2 * 3 * .... * n
  */

  def factorial(n: Int): Long =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println(s"Factorial: ${factorial(5)}")

  /*
  *  3. Fibonacci function: 1, 1, 2, 3, 5, ....
  *   f(1) = 1
  *   f(2) = 1
  *   f(n) = f(n-1) + f(n-2)
  */
  def fibonacci(n: Int): Long = {
    if (n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(s"Fibonacci ${fibonacci(10)}")

  def improvedFibonacci(n: Int): Long = {
    @tailrec
    def fibonacci(n: Int, a: Long = 0, b: Long = 1): Long = n match {
      case 0 => a
      case 1 => b
      case _ => fibonacci(n - 1, b, a + b)
    }

    fibonacci(n)
  }

  println(s"ImprovedFibonacci ${improvedFibonacci(10)}")


  /*
  *  4. Test if number is prime
  */
  def isPrime(a: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else a % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(a / 2)
  }


  println(s"Is prime 6 ${isPrime(6)}")
  println(s"Is prime 11 ${isPrime(11)}")
  println(s"Is prime 21 ${isPrime(21)}")
}
