package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3, 4, 5, 6, 7, 8)

  println("\n\n\n \t\t\t*******\t LIST\t*******")
  println(s"list : $list")
  println(s"list.head : ${list.head}")
  println(s"list.tail : ${list.tail}")

  println("\n\n\n \t\t\t*******\t MAP\t*******")
  println(s"list.map(_+1) : ${list.map(_ + 1)}")
  println(s"list.map(_+10) : ${list.map(_ + 10)}")

  println("\n\n\n \t\t\t*******\t FILTER\t*******")
  println(s"list.filter(_%2==0) : ${list.filter(_ % 2 == 0)}")
  println(s"list.map(_*2).filter(_%2==0) : ${list.map(_ * 2).filter(_ % 2 == 0)}")

  println("\n\n\n \t\t\t*******\t FLAT MAP\t*******")
  val toPair = (x: Int) => List(x, x + 1)
  val pairListMap = list.map(toPair)
  val pairListFlatMap = list.flatMap(toPair)
  println(s"pairListMap : $pairListMap")
  println(s"pairListFlatMap : $pairListFlatMap")

  /*
  *   1.  Print all combinations between two lists
  */
  println("\n\n\n \t\t\t*******\t ITERATING EXERCISE\t*******")
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  println(numbers.flatMap(number => chars.map(char => s"$number$char")))

  println("\n\n\n \t\t\t*******\t FOR EACH\t*******")
  list.foreach(println)

  println("\n\n\n \t\t\t*******\t FOR - COMPREHENSIONS\t*******")
  val colors = List("orange", "blue", "white", "red")
  val forCombinations = for {
    n <- numbers
    ch <- chars
    c <- colors
  } yield s"$n$ch:$c"
  println(s"forCombinations: $forCombinations")
  val conditionalForCombinations = for {
    n <- numbers if n % 2 == 0
    ch <- chars
    c <- colors if c.contains("r")
  } yield s"$n$ch:$c"
  println(s"conditionalForCombinations: $conditionalForCombinations")

  /*
  *   2.  A small collection of At Most One element - Maybe[+T]
  *         - Map
  *         - FlatMap
  *         - Filter
  */

}
