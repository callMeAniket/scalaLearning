package Day4

class Store private(storename: String) {
  override def toString = s"storename: $storename"
  def showIt = println(s"storename: $storename")
}

object Store  {
  def apply(storename: String): Store = new Store(storename)  //factory
  def apply(): Store = new Store("MyStore")

}
/* only once
object Store {
    def moreExtension = println("Doing it getting away")
}*/
/*
object Day {
    def apply(storename: String): Store = new Store(storename)
}*/

object Execute extends App {
  val store: Store = Store("AppStore")
  val store2: Store = Store()
  //val doAgain: Store = Store("NewStore")
  println(store)
  println(store2)
  //println(doAgain)
  //val day: Store= Day("AppStore")
}
