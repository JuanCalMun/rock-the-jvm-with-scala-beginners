package lectures.part2oop.exercises

class Novel(val name: String,
            val yearOfRelease: Int,
            private var author: Writer) {

  def authorAge(): Int = author.age()

  def setWritter(author: Writer): Unit = this.author = author

  def copy(newYearOfRelease: Int): Novel =
    new Novel(name, newYearOfRelease, author)

  override def toString = s"Novel($name,$yearOfRelease,$author)"
}