package lectures.part2oop

import scala.util.Random

object Exceptions extends App {

  def getRandomInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else Random.between(0, 99999)

  println("\n\n\n------------------ Try catch basis")
  try {
    println("random without exception: " + getRandomInt(false))
    println("rando with exception" + getRandomInt(true))
    println("This is never printed cause exception")
  } catch {
    case e: RuntimeException => println(s"Caught a RunTimeException: ${e.getMessage}")
  } finally {
    println("Finally")
  }

  println("\n\n\n------------------ Put try catch in variable")
  private val potentialFail: Int = try {
    val throwException = Random.nextBoolean
    println(s"throwException: $throwException")
    getRandomInt(throwException)
  } catch {
    case _: RuntimeException => -1
  } finally {
    println("finally dont change try catch return type")
  }
  println(s"potentialFail: $potentialFail")
  println(s"potentialFailType: ${potentialFail.getClass}")


  println("\n\n\n------------------ Creating own exceptions")

  object PocketCalculator {

    class OverflowException extends RuntimeException("Number overflow exception")

    class UnderflowException extends RuntimeException("Number underflow exception")

    class MathCalculationException extends RuntimeException("Divion by 0 exception")

    def add(x: Int, y: Int): Int = {
      val sum = x + y
      if (x > 0 && y > 0 && sum < 0) throw new OverflowException
      else if (x < 0 && y < 0 && sum > 0) throw new UnderflowException
      else sum
    }

    def subtract(x: Int, y: Int): Int = {
      val sub = x - y
      if (x > 0 && y < 0 && sub < 0) throw new OverflowException
      else if (x < 0 && y > 0 && sub > 0) throw new UnderflowException
      else sub
    }

    def multiply(x: Int, y: Int): Int = {
      val mul = x * y
      if (((x > 0 && y > 0) || (x < 0 && y < 0)) && mul < 0) throw new OverflowException
      else if (((x > 0 && y < 0) || (x < 0 && y > 0)) && mul > 0) throw new UnderflowException
      else mul
    }

    def divide(x: Int, y: Int): Int =
      if (y == 0) throw new MathCalculationException
      else x / y


  }


  //  println(PocketCalculator.add(Int.MaxValue, 1))
  //  println(PocketCalculator.subtract(Int.MinValue, 1))
  //  println(PocketCalculator.multiply(Int.MaxValue, 2))
  println(PocketCalculator.divide(2, 0))


}
