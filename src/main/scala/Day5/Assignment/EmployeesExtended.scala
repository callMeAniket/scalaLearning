package Day5.Assignment

import scala.io.Source
import scala.util.{Try, Success, Failure}
import java.sql.{Connection, DriverManager, ResultSet}

// Case classes for Employee and Department
case class Employee(sno: Int, name: String, city: String, salary: Double, departmentId: Int)
case class Department(id: Int, name: String)

object EmployeeApp extends App {

  val fileName = "src/main/scala/day4/assignment/employees.csv"

  def readCsv(file: String): List[(Int, String, String, Double, String)] = {
    val bufferedSource = Source.fromFile(file)
    val employees = bufferedSource.getLines().drop(1).flatMap { line =>
      val Array(sno, name, city, salary, department) = line.split(",").map(_.trim)
      Try((sno.toInt, name, city, salary.toDouble, department)) match {
        case Success(employee) => Some(employee)
        case Failure(_) => None
      }
    }.toList
    bufferedSource.close()
    employees
  }

  val rawEmployees = readCsv(fileName)

  // Extracting unique departments
  val departments = rawEmployees.map(_._5).distinct.zipWithIndex.map { case (name, idx) =>
    Department(idx + 1, name)
  }

  // Creating Employee objects with department IDs
  val employees = rawEmployees.map { case (sno, name, city, salary, department) =>
    val departmentId = departments.find(_.name == department).map(_.id).getOrElse(0)
    Employee(sno, name, city, salary, departmentId)
  }

  // Database setup
  val url = "jdbc:sqlite:employees.db"
  val conn: Connection = DriverManager.getConnection(url)

  def createTables(): Unit = {
    val stmt = conn.createStatement()
    stmt.execute(
      """CREATE TABLE IF NOT EXISTS Department (
        | id INTEGER PRIMARY KEY,
        | name TEXT NOT NULL
        |)""".stripMargin)

    stmt.execute(
      """CREATE TABLE IF NOT EXISTS Employee (
        | sno INTEGER PRIMARY KEY,
        | name TEXT NOT NULL,
        | city TEXT NOT NULL,
        | salary REAL NOT NULL,
        | departmentId INTEGER,
        | FOREIGN KEY (departmentId) REFERENCES Department(id)
        |)""".stripMargin)
  }

  def insertDepartments(departments: List[Department]): Unit = {
    val sql = "INSERT INTO Department (id, name) VALUES (?, ?)"
    val pstmt = conn.prepareStatement(sql)
    departments.foreach { dept =>
      pstmt.setInt(1, dept.id)
      pstmt.setString(2, dept.name)
      pstmt.executeUpdate()
    }
  }

  def insertEmployees(employees: List[Employee]): Unit = {
    val sql = "INSERT INTO Employee (sno, name, city, salary, departmentId) VALUES (?, ?, ?, ?, ?)"
    val pstmt = conn.prepareStatement(sql)
    employees.foreach { emp =>
      pstmt.setInt(1, emp.sno)
      pstmt.setString(2, emp.name)
      pstmt.setString(3, emp.city)
      pstmt.setDouble(4, emp.salary)
      pstmt.setInt(5, emp.departmentId)
      pstmt.executeUpdate()
    }
  }

  // Create tables and insert data
  createTables()
  insertDepartments(departments)
  insertEmployees(employees)

  // Function to print the department and its employees in a tree structure
  def printDepartmentTree(): Unit = {
    val deptStmt = conn.createStatement()
    val deptRs = deptStmt.executeQuery("SELECT * FROM Department")

    while (deptRs.next()) {
      val deptId = deptRs.getInt("id")
      val deptName = deptRs.getString("name")
      println(s"Department: $deptName")
      println("Employees:")

      val empStmt = conn.prepareStatement("SELECT * FROM Employee WHERE departmentId = ?")
      empStmt.setInt(1, deptId)
      val empRs = empStmt.executeQuery()
      while (empRs.next()) {
        println(s"  ${empRs.getString("name")} from ${empRs.getString("city")} with salary ${empRs.getDouble("salary")}")
      }
      empStmt.close()
    }
    deptStmt.close()
  }

  // Print the department and employees
  printDepartmentTree()

  // Close the database connection
  conn.close()
}
