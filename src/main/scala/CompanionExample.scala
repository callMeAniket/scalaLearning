class CompanionExample (name : String, num : Int){
  def print = println(s"name = $name and num = $num")
}
class CompanionExampleA(name : String, num : Int) extends CompanionExample(name : String, num : Int) {

}
class CompanionExampleB(name : String, num : Int) extends CompanionExample(name : String, num : Int) {

}
object CompanionExample {
  def apply(name : String, num : Int): CompanionExample = {
    name match {
      case "A" => new CompanionExampleA(name, num)
      case "B" => new CompanionExampleB(name, num)
    }
  }
}
object mainCall{
  def main(args: Array[String]): Unit = {
    val aCompanionExample = CompanionExample("A", 4)
    aCompanionExample.print
    val bCompanionExample = CompanionExample("B", 5)
    bCompanionExample.print
  }
}

