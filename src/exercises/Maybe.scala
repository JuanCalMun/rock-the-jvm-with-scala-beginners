package exercises

abstract class Maybe[+T] {
  def map[E](f: T => E): Maybe[E]

  def flatMap[E](f: T => Maybe[E]): Maybe[E]

  def filter[E >: T](condition: T => Boolean): Maybe[E]
}

case class MaybeNot() extends Maybe[Nothing] {
  override def map[E](f: Nothing => E): Maybe[E] = MaybeNot()

  override def flatMap[E](f: Nothing => Maybe[E]): Maybe[E] = MaybeNot()

  override def filter[E >: Nothing](condition: Nothing => Boolean): Maybe[E] = MaybeNot()
}

case class Just[+T](value: T) extends Maybe[T] {
  override def map[E](f: T => E): Maybe[E] = Just(f(value))

  override def flatMap[E](f: T => Maybe[E]): Maybe[E] = f(value)

  override def filter[E >: T](condition: T => Boolean): Maybe[E] =
    if (condition(value)) Just(value)
    else MaybeNot()
}

object MaybeTest extends App {
  private val just3: Just[Int] = Just(3)
  println("just3.map(_ * 4): " + just3.map(_ * 4))
  println("just3.filter(_ > 5): " + just3.filter(_ > 5))
}

