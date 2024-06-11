package Day9.Assignment

import scala.concurrent.{Future, ExecutionContext}
import scala.util.{Success, Failure}

object FutureExample extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global

  // Define a future
  val future: Future[Int] = Future {
    // Simulate a long-running task
    Thread.sleep(1000)
    42
  }

  // Attach callbacks
  future.onComplete {
    case Success(value) => println(s"Future completed with value: $value")
    case Failure(e) => println(s"Future failed with exception: $e")
  }

  val transformedFuture: Future[String] = future.map(value => s"The answer is $value")

  transformedFuture.foreach(println) // Output: The answer is 42

  // Keep the application running to wait for the future to complete
  Thread.sleep(2000)
}

