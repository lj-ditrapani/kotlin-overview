package overview03

tailrec fun <A, B> fold(list: Lst<A>, zero: B, f: (B, A) -> B): B = when (list) {
    is Nil -> zero
    is Cons -> fold(list.tail, f(zero, list.head), f)
}

sealed class Lst<out A> {
    fun <B> reduce(zero: B, f: (B, A) -> B): B = fold(this, zero, f)
}

object Nil : Lst<Nothing>()

data class Cons<A>(val head: A, val tail: Lst<A>) : Lst<A>()
