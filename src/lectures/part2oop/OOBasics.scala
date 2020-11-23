package lectures.part2oop

object OOBasics extends App {

  class Person(var name: String, var age: Int = 0) {
    def greet(): String =
      s"$name: Hi, I'm $name"

    def greet(person: Person): String =
      s"${this.name}: Hi, ${person.name}. Nice to meet you "

    def apply(): String =
      s"$name is busy now"

    def +(person: Person): Person = {
      println(s"CONGRATS, ${this.name} and ${person.name}. Here is your baby ")
      new Person("Mario Jr", 0)
    }

    def unary_!(): Person =
      if (name equals "Mario") new Person("Bowser", 25)
      else null

    override def toString =
      s"Person($name, $age)"
  }

  private val mario = new Person("Mario", 19)
  private val peach = new Person("Peach", 21)

  println(mario.greet(peach))
  println(mario greet peach)
  println(mario + peach)
  println(mario())
  println(!mario)
  println(!peach)

}
