package Day13.Assignment

object PartialPractice extends App {
  def add(a: Int, b: Int, c: Int): Int = a + b + c

  val add5and7 = add(5, 7, _: Int) // Partially applied function
  println(add5and7(10))

  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => s"$x is even"
  }

  val numbers3 = List(1, 2, 3, 4, 5)
  val evenNumbers = numbers3.collect(isEven)
  println(evenNumbers)
}
