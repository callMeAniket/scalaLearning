package Day1

object CallBacks {

  def bigTaskLibrary(data: String, callback: (String) => String): Unit = {
    println("Task Started")
    println(s"Processing $data")
    val userp = callback(s"Process the process $data")
    println(s"Process the $userp that is given by the user")
    val finaldata = callback("Finish")
    if (finaldata == "success")
      println("Wrapping the task")
    else
      println("It seems the user logic has not been done properly")
  }

  // User1
  def userActivity(info: String): String = {
    if (info == "Finish") {
      println("Finishing the user function")
      return "success"
    } else {
      println("User logic is running")
      return s"[User Processed $info]"
    }
  }

  @main def runTheBlock(): Unit = {
    // Calling the library
    bigTaskLibrary("Callback Scala Task", userActivity)
    println("------------------------------------------------")
    bigTaskLibrary("Simple Lambda oriented task", x => if (x == "Finish") "success" else s"Done with processing $x")
  }
}
