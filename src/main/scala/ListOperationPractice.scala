object ListOperationPractice{
  def main(args: Array[String]): Unit = {
    // initialization or declaration
    var emptyList: List[Int] = List.empty
    var emptyList1: List[Int] = List()
    var listWithValue: List[Int] = List(1,2,3)

    //Adding new entry / Updated

//    emptyList = emptyList.updated(0,1)
//    emptyList = emptyList.updated(1, 2)
    println(emptyList)

    emptyList :+ 5
    emptyList :++ List(1,2,3,4,5)
    emptyList ++ List(6,7,8,9,10)

    emptyList = emptyList :+ 1 :+ 6         //adding single element
    println("After Appending single element : " + emptyList)
    emptyList = 1 +: emptyList              //Prepending
    println("After pre pending : " + emptyList)

    emptyList = emptyList ++ List(7,8,9,10)
    println("Concatenating another list : " + emptyList)
    emptyList = emptyList :+ (1) :++ List(6, 7, 8)
    println("Another way of concatenation : " + emptyList)

    emptyList = emptyList.updated(0, 5)
    println("After updating : " + emptyList)


    //Check contains // Get element
    println(listWithValue)
    println(listWithValue.contains(3))

    println(listWithValue(1))   // first element

    // remove element
    println(listWithValue.diff(List(2)))

    println(listWithValue.filterNot(_ == 2))

    println(listWithValue.patch(0, Nil, 1))

    //traversing elements of map

    listWithValue.foreach(c => println(c))

    for (c <- listWithValue) {
      println(c)
    }

  }
}
