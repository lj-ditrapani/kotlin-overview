package overview04

fun main() {
    val array = "Hello world from kotlin!".toCharArray().toTypedArray()
    val list = newLst<Char>(*array)
    println(list.asString())
    println("List size: ${list.size()}")
    val list2 = list.map { x -> Integer.toHexString(x.toInt()) }
    println("List as ASCII values: ${list2.asString()}")
    println("Reversed list: ${list.reverse().asString()}")
}
