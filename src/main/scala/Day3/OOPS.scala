package Day3

class Person(val name: String, var age: Int) {
  // Primary constructor
  println("Primary constructor")

  // Auxiliary constructor 1
  def this(name: String) = {
    this(name, 0) // Calls primary constructor
    println("Auxiliary constructor 1")
  }

  // Auxiliary constructor 2
  def this() = {
    this("Unknown")
    this.age = 45 // Calls the first auxiliary constructor
    println("Auxiliary constructor 2")
  }
  
  def myFunction(param1 : String) : String = {
    println("this is inside normal method")
    param1;
  }


  override def toString: String = s" name : $name age: $age"
}

object OOPS {
    private val sample: Person = new Person()
    println(sample.myFunction("sample string"))
    println(sample)
}
