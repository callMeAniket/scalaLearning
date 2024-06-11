package Day13.Assignment

import scala.collection.mutable._

object PracticeDay13 extends App{
  val numbers = List(1, 2, 3, 4, 5)
  val doubled = numbers.map(_ * 2)
  println(doubled)

  val buffer = ArrayBuffer(1, 2, 3)

  val numbers2 = List(1, 2, 3, 4, 5)
  numbers2.foreach { _ => println("Ignored value") }
}
