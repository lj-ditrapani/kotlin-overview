package overview04

tailrec fun <A, B> fold(list: Lst<A>, zero: B, f: (B, A) -> B): B = when (list) {
    is Nil -> zero
    is Cons -> fold(list.tail, f(zero, list.head), f)
}

sealed class Lst<out A> {
    abstract val isEmpty: Boolean

    fun <B> reduce(zero: B, f: (B, A) -> B): B = fold(this, zero, f)

    fun <B> map(f: (A) -> B): Lst<B> =
        reverse().reduce<Lst<B>>(Nil) { acc, e -> Cons(f(e), acc) }

    fun reverse(): Lst<A> =
        reduce<Lst<A>>(Nil) { acc, e -> Cons(e, acc) }

    fun size(): Int = reduce(0) { acc, _ -> acc + 1 }

    fun asString(): String = reduce("Lst( ") { acc, e -> "$acc$e " } + ")"
}

fun <A> newLst(vararg elems: A): Lst<A> =
    elems.reversed().fold<A, Lst<A>>(Nil) { acc, e -> Cons(e, acc) }

data class Cons<A>(val head: A, val tail: Lst<A>) : Lst<A>() {
    override val isEmpty = false
}

object Nil : Lst<Nothing>() {
    override val isEmpty = true
}
