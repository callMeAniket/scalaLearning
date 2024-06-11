package Day13.Assignment

import scala.language.implicitConversions

object Implict extends App {
  implicit class RichString(val s: String) {
    def asInt: Option[Int] = scala.util.Try(s.toInt).toOption
  }

  println("123".asInt) // Output: Some(123)
  println("abc".asInt) // Output: None
  val sum: Int = "123".toInt + 4
  println(sum) // Output: 127
}
