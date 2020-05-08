package capitulo3


fun <A> setHead(xs: List<A>, x: A): List<A> = when (xs) {
    Nil -> throw IllegalStateException()
    is Cons -> Cons(x, xs.tail)
}
