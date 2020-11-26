package lectures.part3fp

object WhatsAFunction extends App {

  val double = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println("double of 5 = " + double(5))

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println("string converter: " + stringToIntConverter("1345") + 3)

  val adder = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println("adder 3 and 4 = " + adder(3, 4))

  val stringToIntConverterSintaticSugar = new (String => Int) {
    override def apply(string: String): Int = string.toInt
  }
  println("string converter sintatic sugar: " + stringToIntConverterSintaticSugar("1345") + 3)

  val adderSintaticSugar = new ((Int, Int) => Int) {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println("adderSintaticSugar 3 and 4 = " + adderSintaticSugar(3, 4))


  /*
  *   1.  A function with takes 2 strings and concatenates them
  *   2.  Transform the MyPredicate and MyTransformer into function types
  *   3.  Define a function wich takes an int and returns another function wich takes an int and returns an int
  *       - what's the type of this function
  *       - how to do it
  * */

  val concatenateStrings = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(concatenateStrings("Hello, ", "Scala"))

  val superAdder = new Function[Int, Int => Int] {
    override def apply(x: Int): Int => Int = (y: Int) => x + y
  }
  private val superAdder3: Int => Int = superAdder(3)
  println("superAdder3(4) = " + superAdder3(4))
  println("superAdder(3)(4) = " + superAdder(3)(4))

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
