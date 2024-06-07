package Day4

case class  Project(pno: Int,name: String, members: List[String])

object DoProjectRun extends App {
  val project1: Project = Project(1, "Erp Project ", List("Raghav","Naresh","Lokesh") )
  val project2: Project = Project(2, "API Project", List("Ajay","Kiran","Lokesh") )
  val project3: Project = Project(1, "Erp Project ", List("Raghav","Naresh","Lokesh") )
  println(project1)
  println(project2)
  println(project1.equals(project3))
  println(project1 == project3)
  println(project1 == project2)
  println(project1.name)
}
