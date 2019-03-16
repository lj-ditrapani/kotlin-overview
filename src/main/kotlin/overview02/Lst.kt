package overview02

sealed class Lst {
  tailrec fun <B> reduce(zero: B, f: (B, Int) -> B): B = when(this) {
    is Nil -> zero
    is Cons -> this.tail.reduce(f(zero, this.head), f)
  }
}

object Nil: Lst()

data class Cons(val head: Int, val tail: Lst): Lst()
