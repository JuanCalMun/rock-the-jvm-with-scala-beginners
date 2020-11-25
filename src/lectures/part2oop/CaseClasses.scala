package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  //  0. Companion objects
  val gandalfTheGrey = Person("Gandalf", 452)
  val gandalfTheWhite = Person("Gandalf", 452)
  val frodo = Person("Frodo", 120)

  //  1.  Class parameters are fields
  println(gandalfTheGrey.name)

  //  2.  Sensible toString
  println(gandalfTheGrey)

  //  3.  Equals and hashCode
  println(s"gandalfTheGrey == frodo ${gandalfTheGrey == frodo}")
  println(s"gandalfTheGrey == gandalfTheWhite ${gandalfTheGrey == gandalfTheWhite}")

  //  4.  Copy
  val mithrandir = gandalfTheGrey.copy()
  val sam = frodo.copy(name = "Sam")
  println(s"Mithrandir: $mithrandir")
  println(s"Frodo: $frodo")
  println(s"Sam: $sam")

  //  5.  Are serializable

}
