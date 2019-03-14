package overview01

sealed class Lst
object Nil: Lst()
class Cons(val head: Int, val tail: Lst): Lst()
