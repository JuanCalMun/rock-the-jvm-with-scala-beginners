package lectures.part2oop.resources

object AbstractDataTypes extends App {

  abstract class Animal(val creatureType: String) {
    def eat: Unit
  }

  class Dog extends Animal("Dog") {
    override def eat: Unit = println("crunch crunch")
  }

}
