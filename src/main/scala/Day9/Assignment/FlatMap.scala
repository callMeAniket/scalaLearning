package Day9.Assignment

import scala.concurrent.{ExecutionContext, Future}

object FlatMap extends App{

  implicit val ec: ExecutionContext = ExecutionContext.global

  val nestedNumbers = List(List(1, 2, 3), List(4, 5, 6))
  val flattened = nestedNumbers.flatten
  println(flattened) // Output: List(1, 2, 3, 4, 5, 6)

  val future1: Future[Int] = Future {
    Thread.sleep(1000)
    42
  }

  val future2: Future[String] = future1.flatMap { value =>
    Future {
      Thread.sleep(1000)
      s"The answer is $value"
    }
  }

  future2.foreach(println)  // Output: The answer is 42

  Thread.sleep(10000)
}
