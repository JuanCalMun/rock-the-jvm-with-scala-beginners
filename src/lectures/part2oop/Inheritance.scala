package lectures.part2oop


/*
*   Traits and abstract classes are very similar
*
*   TRAIT           ~=   Java Interface       =>    What they DO
*   ABSTRACT CLASS  ~=   Java Abstract class  =>    What they ARE
*/
object Inheritance extends App {

  trait Carnivore {
    def eat(animal: Pet): Unit
  }

  sealed class Pet(val name: String) {
    def talk = println("... (silence) ...")

    protected def eat = {
      println(s"---- $name is going to eat")
      println("nom nom nom")
    }

  }

  final class Cat(name: String = "Cat") extends Pet(name) {
    override def talk = println("Meooow!!!")

    override def eat = {
      super.eat
      if (name eq "Nora") puke
      println(s"---- $name is going to sleep now")
    }

    private def puke = println(s"Oh no!!! $name is puking the meal")
  }

  final class Dog(name: String = "Dog") extends Pet(name) {
    override def talk = println("Guof guof!!!")

    override def eat {
      println(s"---- $name is going to eat")
      println("crunch crunch crunch")
      println(s"---- $name is going to run now")
    }
  }

  final class Snake(name: String = "Snake")
    extends Pet(name) with Carnivore {
    def eat(animal: Pet): Unit =
      println(s"${name} is eating ${animal.name}")
  }

  final class Mouse(name: String = "Mouse") extends Pet(name)

  val nora = new Cat("Nora")
  val siggy = new Cat("Siggy")
  val sansa = new Dog("Sansa")
  val unknownPet: Pet = new Dog()

  val scabbers = new Mouse("Scabbers")
  val nagini = new Snake("Nagini")


  println("*************    EAT TIME")
  siggy.eat
  nora.eat
  sansa.eat
  nagini.eat(scabbers)
  println("*************    TALK TIME")
  siggy.talk
  sansa.talk
  nagini.talk
  unknownPet.talk /* Guof guof!!! instead ...(silence)... */


}
