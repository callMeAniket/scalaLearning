package Day3

import scala.io.StdIn

// Tuple representing employee information
type EmployeeTuple = (Int, String, String)

// Tree node representing a department
class DepartmentNode(val name: String, var employees: List[EmployeeTuple], var children: List[DepartmentNode]) {

  // Method to add an employee to this department
  def addEmployee(employee: EmployeeTuple): Unit = {
    employees = employee :: employees
  }

  // Method to add a child department
  def addChild(child: DepartmentNode): Unit = {
    children = child :: children
  }

  // Recursive method to print the department tree
  def printTree(indent: Int = 0): Unit = {
    val spaces = "  " * indent
    println(s"$spaces$name")

    for (emp <- employees.reverse) {
      println(s"$spaces  - $emp")
    }

    for (child <- children.reverse) {
      child.printTree(indent + 1)
    }
  }
}

object OrganizationApp {

  // Root department node
  var rootDepartment: DepartmentNode = new DepartmentNode("Organization", Nil, Nil)

  // Method to handle user input and manage organization tree
  def main(args: Array[String]): Unit = {
    var continue = true

    while (continue) {
      println("Enter employee details (sno, name, city, department) or type 'exit' to quit:")
      val input = StdIn.readLine().trim()

      if (input.equalsIgnoreCase("exit")) {
        continue = false
      } else {
        val Array(snoStr, name, city, department) = input.split(",", 4).map(_.trim())

        try {
          val sno = snoStr.toInt
          val employee = (sno, name, city)
          addEmployeeToDepartment(employee, department)
        } catch {
          case e: NumberFormatException =>
            println("Invalid input for sno. Please enter a valid integer.")
        }
      }
    }

    println("Organization Tree:")
    rootDepartment.printTree()
  }

  // Method to add an employee to the correct department in the organization tree
  def addEmployeeToDepartment(employee: EmployeeTuple, departmentPath: String): Unit = {
    val departmentNames = departmentPath.split("/").map(_.trim())
    var currentNode = rootDepartment

    for (deptName <- departmentNames) {
      val childOption = currentNode.children.find(_.name == deptName)

      childOption match {
        case Some(childNode) => currentNode = childNode
        case None =>
          val newChild = new DepartmentNode(deptName, Nil, Nil)
          currentNode.addChild(newChild)
          currentNode = newChild
      }
    }

    currentNode.addEmployee(employee)
  }
}
