package lectures.par2oop

import lectures.par2oop.exercises.{Counter, Novel, Writer}

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
}
