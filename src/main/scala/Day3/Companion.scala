package Day3

class PersonC(sno: Int, name: String, city: String) {
  def showIt: Unit = {
    println(s"sno: $sno name: $name city: $city")
    println(PersonC.generalMethod)
  }
  /* def setName(name: str):Unit = {
       this.name=name
   }*/
} //instance variables(property tupes) are not supposed to be accessed outside the class

// they dont have visibility outside
object PersonC {
  val info: String = "Organization ABC"

  def generalMethod: Unit = {
    println(s"I do general things in the organization in $info")
  }
}

object Companion {
  @main def checkPerson = {
    val person1: PersonC = new PersonC(1, "Ravi", "Chennai")
    val person2: PersonC = new PersonC(2, "Rohan", "Mumbai")
    person1.showIt
    person2.showIt
    //person1.setName("RAjesh")
    person1.showIt
    println(PersonC.info)
  }
}
