package overview04

fun main() {
  val list = newLst<Char>(*("Hello world from kotlin!".toCharArray().toTypedArray()))
  println(list.toString())
  println("List size: ${list.size()}")
  val list2 = list.map { x -> Integer.toHexString(x.toInt()) }
  println("List as ASCII values: ${list2}")
  println("Reversed list: ${list.reverse()}")
}
