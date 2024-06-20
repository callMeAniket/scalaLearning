case class Person(var a: Int)

object Person{
  def main(args: Array[String]): Unit = {
    val p1 = Person(5)
    val p2 = Person(5)

    println(p1 == p2)
    println(p1.equals(p2))
    println(System.identityHashCode(p1))
    println(System.identityHashCode(p2))
    println(p1.a == p2.a)
  }
}

class Person2(val a: Int)

object Person2{
  def main(args: Array[String]): Unit = {
    val p1 = Person2(5)
    val p2 = Person2(5)
    println(p1.equals(p2))
    println(p1 == p2)
  }
}