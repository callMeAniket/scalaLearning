object Basics {
  def main(args: Array[String]): Unit = {
    var count = 10
    while(count>0) {
      println(count)
      count -= 1
    }

    for(i <- 1 to 10) {
      i match {
        case i if(i%2==0) => println("even")
        case _ => println("odd")
      }
    }

    var arrayNum = for(i <- 0 to 10 by 2) yield i
    println(arrayNum.toList)

    var tuple2Ex =  Tuple2("aniket", "sharma")
    println(tuple2Ex._1)
    var tuple2Shortcut = ("sharma", "snuggle")
    println(tuple2Shortcut)

    var optionString : Option[String] = Some("ten")
    println(optionString.get)

    var optionNoneString : Option[String] = None
    println(optionNoneString)
    println(optionNoneString.getOrElse("hello i am default"))

    var integerValue = optionString match {
      case Some(x) => x
      case None => "minus 5"
    }
    println(integerValue)

    var anyTopLevelAsObjectInJava : Any = 5
    println(anyTopLevelAsObjectInJava)

    var anyValueExample : AnyVal = 5
    println(anyValueExample)

    var anyRefExample : AnyRef = "5"
    println(anyRefExample)

    def firstFunction() : String = {
      println("I am in function")
      "hello"
    }

    println(firstFunction())

    def functionWithParams(param1 : String) = {
      "returning same " + param1
    }
    println(functionWithParams("I am parameter 1"))

    def functionWithDefaultParamValues(intVal : Int, stringValue : String = "default if not passes") : Unit = {
      print(intVal)
      println(stringValue)
    }
    functionWithDefaultParamValues(5," 2nd param passed")
    functionWithDefaultParamValues(5)
  }
}