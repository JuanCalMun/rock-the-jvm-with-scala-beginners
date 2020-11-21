package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorialImproved(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt = 1): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n)
  }

  println(factorialImproved(5))
  println(s"size ${factorialImproved(5).toString().length}")


  /*
    *   Implement with tail recursion concatenate a string n times
    */
  def concatenateString(n: Int, text: String): String = {
    @tailrec
    def concatenateStringHelper(n: Int, text: String, acc: String = ""): String =
      if (n == 1) acc
      else concatenateStringHelper(n - 1, text, text.concat(acc))

    concatenateStringHelper(n, text)
  }

  println(concatenateString(5, "Tailrec"))

  /*
  *   Implement with tail recursion IsPrime function
  */
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int, isStillPrime: Boolean = true): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0)
    }

    isPrimeHelper(n / 2)
  }

  println(s"Is 4 prime:${isPrime(4)}")
  println(s"Is 5 prime:${isPrime(5)}")
  println(s"Is 7 prime:${isPrime(7)}")
  println(s"Is 11 prime:${isPrime(11)}")

  /*
  *   Fibonacci function, tail recursive
  */

}
