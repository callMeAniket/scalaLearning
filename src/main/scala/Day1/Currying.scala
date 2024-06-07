package Day1

object Currying {
  def preProcess(input: String): String = s"Preprocessed $input"

  def process(preprocessedinput: String): String = s"Processing $preprocessedinput"

  @main def doActivity = {
    val activity = (preProcess).andThen(process)
    println(activity("Employee Data Set"))
  }

  @main def partialFunction(): Unit = {
    def add(a: Int, b: Int): Int = a + b

    val add3 = add(3, _: Int)
    println(add3(4)) // Outputs 7
  }
}
