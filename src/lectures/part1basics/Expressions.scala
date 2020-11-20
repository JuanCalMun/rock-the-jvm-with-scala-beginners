package lectures.part1basics

object Expressions extends App {

  val x = 3
  val y = 5

  println(s"x + y = ${x + y}")
  println(s"x - y = ${x - y}")
  println(s"x * y = ${x * y}")
  println(s"x / y = ${x.toDouble / y}")

  println(s"is x != 3 : ${x != 3}")

  val aCondition = true
  val aFalseCondition = false

  println(if (aCondition) "aCondition true" else "aCondition false")
  println(if (aFalseCondition) "aFalseCondition true" else "aFalseCondition false")

  var a = 1
  var b = 10
  var c = 5
  var d = 6
  a += 3
  b -= 2
  c *= 4
  d /= 2
  println(s"a=$a")
  println(s"b=$b")
  println(s"c=$c")
  println(s"d=$d")

  var unitValue: Unit = d = 1
  println(s"UnitValue= $unitValue")


  val codeBlock = {
    val x = 1
    val y = x + 3
    if (x < y) "Hello" else "Goodbye"
  }
  println(codeBlock.getClass)
  println(codeBlock)

}
