object Closures {
  def wrapper(outer: Int): Unit = {
    var outerscope = outer // 100

    def inner(data: Int): String = {
      outerscope = outerscope + data
      println(s"inside inner data is $data and outerscope data is $outerscope")
      "InnerFinished"
    }

    inner(30)
    inner(40)
    inner(50)
  }

  def main(args: Array[String]): Unit = {
    wrapper(100)
  }
}
