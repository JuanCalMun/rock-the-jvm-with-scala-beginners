package lectures.part2oop

object InheritanceAndTraits extends App {

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

  val nora = new Cat("Nora")
  val siggy = new Cat("Siggy")
  val sansa = new Dog("Sansa")
  val unknownPet: Pet = new Dog()

  println("*************    EAT TIME")
  siggy.eat
  nora.eat
  sansa.eat
  println("*************    TALK TIME")
  siggy.talk
  sansa.talk
  unknownPet.talk /* Guof guof!!! instead ...(silence)... */


}
