package lectures.part2oop.resources

import java.time.Year

class Writer(val firstName: String,
             val surname: String,
             val year: Int) {
  def fullName(): String = s"$firstName $surname ($year)"

  def age(): Int = Year.now.getValue - year

  override def toString = s"Writer($firstName $surname born in $year)"
}
