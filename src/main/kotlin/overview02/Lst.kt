package overview02

tailrec fun <B> _reduce(list: Lst, zero: B, f: (B, Int) -> B): B = when(list) {
  is Nil -> zero
  is Cons -> _reduce(list.tail, f(zero, list.head), f)
}

sealed class Lst {
  fun <B> reduce(zero: B, f: (B, Int) -> B): B = _reduce(this, zero, f)
}

object Nil: Lst()

data class Cons(val head: Int, val tail: Lst): Lst()
