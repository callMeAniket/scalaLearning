object MapOperationPractice {
  def main(args: Array[String]): Unit = {

    //Declaring and Initialization
    var emptyMap: Map[String, String] = Map.empty
    var mapWithInitial: Map[String, String] = Map("name" -> "Aniket", "age" -> "24")

    //Adding new entry / Updated
    emptyMap = emptyMap + ("name" -> "Aniket")  // adding one value
    emptyMap = emptyMap + ("name" -> "Sharma")  // updating same key
    mapWithInitial = mapWithInitial.updated("deleteLater","Wqe")

    //Check contains // Get element
    if(mapWithInitial.contains("name")) {
      println("Exists")
    }
    println(mapWithInitial.get("name")) //option

    mapWithInitial.get("name") match {
      case Some(value)  =>  println(value)
      case None => println("No key with this name")
    }

    val usingDefaultHere = mapWithInitial.getOrElse("notPresent", "Default")
    println(usingDefaultHere)

    println(emptyMap)
    println(mapWithInitial)

    // remove element
    mapWithInitial = mapWithInitial.removed("deleteLater")
    println(mapWithInitial)

    //traversing elements of map
    println("-----traversing-------")
    for(key <- mapWithInitial.keySet) {
      println("Printing with key- " + key + " : " + mapWithInitial(key))
    }
    println(mapWithInitial.get("name")) //option
    println(mapWithInitial.get("name").get) //value
    println(mapWithInitial("name")) //value

    println(mapWithInitial.get("none")) //option
//    println(mapWithInitial.get("none").get) //value   -   get operation on null
//    println(mapWithInitial("none")) //  value --- Only do if the key is confirmed, otherwise exception will, like in this case

    for((key, value) <- mapWithInitial) {
      println(key + " : " + value)
    }

    mapWithInitial.foreach {
      case (k,v) => println(k + " : " + v)
    }

  }
}
