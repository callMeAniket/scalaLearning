package Day4

abstract class Animal {
  def makeSound(): Unit
}

@main def runIt(): Unit = {
  val dog = new Animal {
    def makeSound(): Unit = println("Woof")
  }
  dog.makeSound()
}
