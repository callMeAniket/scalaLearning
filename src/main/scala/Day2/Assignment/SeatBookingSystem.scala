package Day2.Assignment

object SeatBookingSystem {
  def main(args: Array[String]): Unit = {
    seatBookingSystem(printMatrix)
  }

  def printMatrix(matrix: Array[Array[String]]): Unit = {
    for (row <- matrix) {
      println(row.mkString(" "))
    }
  }

  def seatBookingSystem(callback: Array[Array[String]] => Unit): Unit = {
    var matrix: Array[Array[String]] = Array.tabulate(10, 10)((row, col) => (row * 10 + col + 1).toString)

    def allocateSeats(seatNumbers: List[Int]): Unit = {
      for (seat <- seatNumbers) {
        val row = (seat - 1) / 10
        val col = (seat - 1) % 10
        matrix(row)(col) = "X"
      }
    }

    var continueBooking = true

    while (continueBooking) {
      callback(matrix)

      println("Enter seat numbers to book (comma separated), or type 'stop' to finish:")
      val input = scala.io.StdIn.readLine()

      if (input.toLowerCase == "stop") {
        continueBooking = false
      } else {
        try {
          val seatNumbers = input.split(",").map(_.trim.toInt).toList
          allocateSeats(seatNumbers)
        } catch {
          case _: NumberFormatException => println("Invalid input, please enter seat numbers or 'stop'.")
        }
      }
    }
  }
}
