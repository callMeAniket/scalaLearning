package Day4.assignment

import scala.io.Source
import scala.util.{Try, Success, Failure}

case class Employee(sno: Int, name: String, city: String, salary: Double, department: String)

object EmployeeApp extends App {

  val fileName = "src/main/scala/day4/assignment/employees.csv"

  def readCsv(file: String): List[Employee] = {
    val bufferedSource = Source.fromFile(file)
    val employees = bufferedSource.getLines().drop(1).flatMap { line =>
      val Array(sno, name, city, salary, department) = line.split(",").map(_.trim)
      Try(Employee(sno.toInt, name, city, salary.toDouble, department)) match {
        case Success(employee) => Some(employee)
        case Failure(_) => None
      }
    }.toList
    bufferedSource.close()
    employees
  }

  val employees = readCsv(fileName)

  val highSalaryEmployees = employees.filter(_.salary > 60000)
  val engineeringEmployees = employees.filter(_.department == "Engineering")

  val formattedReport = employees.map(e => s"${e.name} from ${e.city} works in ${e.department} with a salary of ${e.salary}")

  val departmentWiseStats = employees.groupBy(_.department).map { case (department, empList) =>
    val totalSalary = empList.map(_.salary).sum
    val averageSalary = totalSalary / empList.size
    val numberOfEmployees = empList.size
    (department, totalSalary, averageSalary, numberOfEmployees)
  }

  println("High Salary Employees (> 60000):")
  highSalaryEmployees.foreach(println)

  println("\nEngineering Employees:")
  engineeringEmployees.foreach(println)

  println("\nFormatted Report:")
  formattedReport.foreach(println)

  println("\nDepartment Wise Stats (Department, Total Salary, Average Salary, Number of Employees):")
  departmentWiseStats.foreach(println)
}
