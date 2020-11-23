package lectures.part2oop

object Objects extends App {

  /*
  *   Scala does not hav "static" functionality
  *   the "static" variables are in the object and the funcionality in the class
  *   object + class = Companions
  */
  object Person {
    /*    Object = singleton instance   */
    val N_EYES: Int = 2
    val BABY_NAME = "Toad"

    def canFly: Boolean = false

    /*
    *    Factory pattern, allow new instance statically
    *    val p = Person(mother,father)
    */
    def apply(mother: Person, father: Person): Person = {
      println(s"*** ${mother.name} and ${father.name} made a baby $BABY_NAME ***")
      new Person(BABY_NAME)
    }
  }

  class Person(val name: String) {
    /*    Class = regular instance    */

  }

  println(Person.N_EYES)
  println(Person.canFly)

  //  Scala objects = Singleton instance
  val mario = Person
  val luigi = Person
  println(s"Are Mario and Luigi same instance? ${mario == luigi}") //true

  //  Scala classes = regular instance
  val peach = new Person("Peach")
  val bowser = new Person("Bowser")
  println(s"Are ${peach.name} and ${bowser.name} same instance? ${peach == bowser}") //false

  //  Static instanciating, factory method
  val toad = Person(peach, bowser)
  println(toad.name)

}
