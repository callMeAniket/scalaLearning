package Day3

//optionalType
val optionalInt: Option[Int] = Some(42)
val second: Option[Int] = None

val actualValue: Int = optionalInt match {
  case Some(value) => value
  case None => -1
}

object Optional extends App {
  println(actualValue)
  println(optionalInt.getOrElse(-1))
  println(second.getOrElse(-1))
  if (second.isDefined)
    println(second.get)
  val result = if (second.isDefined) second.get else -1
  println(result)
}
