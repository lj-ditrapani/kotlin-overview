package overview04

fun main() {
  val array = "Hello world from kotlin!".toCharArray().toTypedArray()
  val list = newLst<Char>(*array)
  println(list.toString())
  println("List size: ${list.size()}")
  val list2 = list.map { x -> Integer.toHexString(x.toInt()) }
  println("List as ASCII values: ${list2}")
  println("Reversed list: ${list.reverse()}")
}
