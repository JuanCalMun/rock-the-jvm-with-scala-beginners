package lectures.part1basics

object CalledByNameVSCalledByValue extends App {

  def calledByValue(x: Long): Unit = {
    //    Both are identicals
    //    In the call by value the variable have te value of the inital expression
    println(s"by value: $x")
    println(s"by value: $x")
  }

  def calledByName(x: => Long): Unit = {
    //    Not the same print.
    //    In the call by name the variable have te expression, is executed when is used
    println(s"by value: $x")
    println(s"by value: $x")
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

}
