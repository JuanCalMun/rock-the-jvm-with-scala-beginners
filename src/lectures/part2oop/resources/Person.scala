package lectures.part2oop.resources

class Person(val name: String, val age: Int) {

  def greet(): String =
    s"$name: Hi, I'm $name"

  def greet(person: Person): String =
    s"${this.name}: Hi, ${person.name}. Nice to meet you "

  def apply(): String =
    s"$name is busy"

  def apply(minutes: Int): String =
    s"${this ()} for $minutes minutes"

  def +(alias: String): Person =
    new Person(s"$name($alias)", age)

  def unary_+ : Person =
    new Person(name, age + 1)

  def shoot(projectile: String): String = s"$name throws $projectile"

  def shoot: String = this shoot "fireball"

  override def toString =
    s"Person($name, $age)"
}
