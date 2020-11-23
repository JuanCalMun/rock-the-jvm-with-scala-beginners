package lectures.part2oop.exercises

class Counter(count: Int) {

  def currentCount(): Int = count

  def increment(n: Int): Counter =
    if (n <= 0) this
    else increment.increment(n - 1)


  def decrement(n: Int): Counter =
    if (n <= 0) this
    else decrement.decrement(n - 1)

  def increment: Counter = new Counter(count + 1)

  def decrement: Counter = new Counter(count - 1)


  override def toString = s"Counter($count)"
}
