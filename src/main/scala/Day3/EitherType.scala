package Day3

type custom = Either[String, Int];

def roomAvailability(x: Int): custom = {
  if (x < 15)
    Right(2)
  else
    Left("No Rooms are available")
}

object EitherType extends App{
  roomAvailability(10) match {
    case Right(value) => println(s"Available: $value")
    case Left(error) => println(s"Result: $error")
  }
}
