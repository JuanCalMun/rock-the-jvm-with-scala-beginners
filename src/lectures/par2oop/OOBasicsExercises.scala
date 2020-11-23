package lectures.par2oop

import lectures.par2oop.exercises.{Counter, Novel, Person, Writer}

object OOBasicsExercises extends App {

  /*
  * Novel and Writer
  *
  * Writer: first name, surname,year
  *   -method fullname
  *
  * Novel: name, year of release, author
  *   - authorAge
  *   - isWrittenBy(author)
  *   - copy (new year of release) = new instance of Novel
  */
  private val lorca = new Writer("Federico", "Garcia Lorca", 1990)
  private val quevedo = new Writer("Francisco", "Quevedo", 1980)

  private val bodasDeSangre = new Novel("Bodas de sangre", 2010, quevedo)
  private val bodasDeSangreReview: Novel = bodasDeSangre.copy(2019)

  println("------------- Novels and Writers")
  println(bodasDeSangre.authorAge())
  println(bodasDeSangre)
  println(bodasDeSangreReview)
  bodasDeSangre.setWritter(lorca)
  println(bodasDeSangre)

  /*
  * Counter class
  *   -receives an int value
  * method current count
  * method to increment/decrement => new Counter
  * overload inc/dec to receive an amount
  */
  println("------------- Counters")
  private val c1 = new Counter(4)
  private val c1dec: Counter = c1.decrement(2)
  private val c1inc: Counter = c1.increment(2)

  println(c1)
  println(c1dec)
  println(c1inc)


  println("------------- Persons")
  /*
  *   Overload the + operator
  *   mary + "the rockstar" => new Person "Mary (the rockstar)"
  */
  private val mario = new Person("Mario", 34)
  private val luigi = new Person("Luigi", 31)

  private val bigMario: Person = mario + "Big"

  println(mario)
  println(bigMario)


  /*
  *   Add an age to the Person class
  *   Add a unary + opeartor => new person with the age + 1
  *   +mary => mary with the age incrementer
  */
  private val oldMario: Person = +mario
  println(oldMario)

  /*
  *   Add a "learns" metho in the Person class => "Mary learns Scala"
  *   add a learnsScala method, calls learns method with "Scala"
  *   Use it in postfix notation
  */
  println(mario shoot())
  println(luigi shoot "a turtle shell")

  /*
  *   Overload the apply method
  *   mary.apply(2) => "Mary watched Inception 2 times"
  */
  println(mario())
  println(luigi(4))
}
