package Day1.Assignments

object AlgorithmFactory {

  def getAlgorithm(algorithmType: String): (Array[Int] => Unit) = {
    algorithmType.toLowerCase match {
      case "bubblesort" => bubbleSort
      case "insertionsort" => insertionSort
      case "quicksort" => quickSort
      case "mergesort" => mergeSort
      case "radixsort" => radixSort
      case "binarysearch" => binarySearch
      case _ => throw new IllegalArgumentException(s"Unknown algorithm type: $algorithmType")
    }
  }

  private def bubbleSort(arr: Array[Int]): Unit = {
    for (i <- arr.indices) {
      for (j <- 0 until arr.length - 1 - i) {
        if (arr(j) > arr(j + 1)) {
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
    }
    println(s"Bubble Sorted: ${arr.mkString(", ")}")
  }

  def insertionSort(arr: Array[Int]): Unit = {
    for (i <- 1 until arr.length) {
      val key = arr(i)
      var j = i - 1
      while (j >= 0 && arr(j) > key) {
        arr(j + 1) = arr(j)
        j -= 1
      }
      arr(j + 1) = key
    }
    println(s"Insertion Sorted: ${arr.mkString(", ")}")
  }

  def quickSort(arr: Array[Int]): Unit = {
    def sort(start: Int, end: Int): Unit = {
      if (start < end) {
        val pivotIndex = partition(start, end)
        sort(start, pivotIndex - 1)
        sort(pivotIndex + 1, end)
      }
    }

    def partition(start: Int, end: Int): Int = {
      val pivot = arr(end)
      var pIndex = start
      for (i <- start until end) {
        if (arr(i) <= pivot) {
          val temp = arr(i)
          arr(i) = arr(pIndex)
          arr(pIndex) = temp
          pIndex += 1
        }
      }
      val temp = arr(pIndex)
      arr(pIndex) = arr(end)
      arr(end) = temp
      pIndex
    }

    sort(0, arr.length - 1)
    println(s"Quick Sorted: ${arr.mkString(", ")}")
  }

  def mergeSort(arr: Array[Int]): Unit = {
    def sort(start: Int, end: Int): Array[Int] = {
      if (start >= end) Array(arr(start))
      else {
        val mid = (start + end) / 2
        val left = sort(start, mid)
        val right = sort(mid + 1, end)
        merge(left, right)
      }
    }

    def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
      var result = Array[Int]()
      var i = 0
      var j = 0
      while (i < left.length && j < right.length) {
        if (left(i) <= right(j)) {
          result = result :+ left(i)
          i += 1
        } else {
          result = result :+ right(j)
          j += 1
        }
      }
      result ++ left.drop(i) ++ right.drop(j)
    }

    val sortedArray = sort(0, arr.length - 1)
    Array.copy(sortedArray, 0, arr, 0, arr.length)
    println(s"Merge Sorted: ${arr.mkString(", ")}")
  }

  def radixSort(arr: Array[Int]): Unit = {
    val max = arr.max
    var exp = 1
    var output = new Array[Int](arr.length)

    while (max / exp > 0) {
      val count = new Array[Int](arr.length)
      for (i <- arr.indices) count((arr(i) / exp) % 10) += 1
      for (i <- 1 until 10) count(i) += count(i - 1)
      for (i <- arr.indices.reverse) {
        output(count((arr(i) / exp) % 10) - 1) = arr(i)
        count((arr(i) / exp) % 10) -= 1
      }
      for (i <- arr.indices) arr(i) = output(i)
      exp *= 10
    }
    println(s"Radix Sorted: ${arr.mkString(", ")}")
  }

  def binarySearch(arr: Array[Int]): Unit = {
    println("Array before sorting (required for binary search):")
    println(arr.mkString(", "))
    quickSort(arr)

    def search(target: Int): Int = {
      var left = 0
      var right = arr.length - 1
      while (left <= right) {
        val mid = left + (right - left) / 2
        if (arr(mid) == target) return mid
        if (arr(mid) < target) left = mid + 1
        else right = mid - 1
      }
      -1
    }

    val target = 7 // Example target value
    val result = search(target)
    if (result != -1) println(s"Element found at index $result")
    else println("Element not found")
  }

  @main def runTheBlock(): Unit = {
    val algorithm = getAlgorithm("bubblesort")
    algorithm(Array(5, 1, 4, 2, 8))


        println("------------------------------------------------")

        val algorithm2 = getAlgorithm("insertionsort")
        algorithm2(Array(9, 7, 3, 6, 2, 1, 5))

        println("------------------------------------------------")

        val algorithm3 = getAlgorithm("quicksort")
        algorithm3(Array(3, 7, 8, 5, 2, 1, 9, 5, 4))

        println("------------------------------------------------")

        val algorithm4 = getAlgorithm("mergesort")
        algorithm4(Array(12, 11, 13, 5, 6, 7))

        println("------------------------------------------------")

//        val algorithm5 = getAlgorithm("radixsort")
//        algorithm5(Array(170, 45, 75, 90, 802, 24, 2, 66))

        println("------------------------------------------------")

        val algorithm6 = getAlgorithm("binarysearch")
        algorithm6(Array(2, 3, 4, 10, 40))
  }
}

