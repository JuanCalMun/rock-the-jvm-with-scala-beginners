package lectures.par2oop.exercises

import java.time.Year

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = s"$firstName $surname ($year)"

  def age(): Int = Year.now.getValue - year

  override def toString = s"Writer($year, ${fullName()})"
}
