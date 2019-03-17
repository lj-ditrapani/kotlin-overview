package overview03

tailrec fun <A, B> _reduce(list: Lst<A>, zero: B, f: (B, A) -> B): B = when (list) {
    is Nil -> zero
    is Cons -> _reduce(list.tail, f(zero, list.head), f)
}

sealed class Lst<out A> {
    fun <B> reduce(zero: B, f: (B, A) -> B): B = _reduce(this, zero, f)
}

object Nil : Lst<Nothing>()

data class Cons<A>(val head: A, val tail: Lst<A>) : Lst<A>()
