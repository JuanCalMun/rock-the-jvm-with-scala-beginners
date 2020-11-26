package lectures.part3fp

object AnonymousFunctions extends App {

  //  Anonymous function (Lambda)
  val doubler = (x: Int) => x * 2

  //  Multiple params in a lambda
  val adder: (Int, Int) => Int = (a, b) => a + b

  //  No params in a lambda
  val justDoSomething = () => 3
  /*
  *   Its important use the ( ) with lambdas
  */
  println(justDoSomething) // lectures.part3fp.AnonymousFunctions$$$Lambda$4/10449826@b1d79b
  println(justDoSomething()) // 3

  //  Sintactic sugar
  val niceIncrementer: Int => Int = _ + 1 //  equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //  equivalent to (a,b) => a + b
  println("niceAdder(3, 4) = " + niceAdder(3, 4))
  println("niceIncrementer(4) = " + niceIncrementer(4))

}
