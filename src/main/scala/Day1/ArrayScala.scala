package Day1

object ArrayScala {
  @main def arrays(): Unit = {
    val numbers: Array[Int] = Array(1, 2, 3, 4, 5)
    println(numbers)
    println(numbers(3))
    numbers(2) = 34
    println(numbers(2))

    for (num <- numbers) {
      println(num)
    }
    println("-----------------------------")
    numbers.foreach(println)
  }
}