package lectures.part1basics

object ValuesVariablesTypes extends App {
  println("Hello world, I'm on scala App")

  //  Specific types
  val x: Int = 42
  val z: Float = 34F
  val v: Long = 1111111L
  val s: Short = 123

  val t: Boolean = true
  val f: Boolean = false

  val a: String = "This is a String"
  val b: Char = 'b'


  //  Inferred types
  val aInt = 3
  val aFloat = 3F
  val aDuble = 11111D
  val otherDouble = 11.111
  val aLong = 11111L

  val aChar = 'b' //Char
  val aString = "a" //String

  //  String to numerics
  val y: Double = "52".toDouble
}
