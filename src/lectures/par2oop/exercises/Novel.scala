package lectures.par2oop.exercises

class Novel(name: String, yearOfRelease: Int, var author: Writer) {

  def authorAge(): Int = author.age()

  def setWritter(author: Writer): Unit = this.author = author

  def copy(newYearOfRelease: Int): Novel =
    new Novel(name, newYearOfRelease, author)

  override def toString = s"Novel($name,$yearOfRelease,$author)"
}