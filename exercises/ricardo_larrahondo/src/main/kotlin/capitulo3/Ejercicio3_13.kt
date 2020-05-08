package capitulo3


fun <A> appendL(a1: List<A>, a2: List<A>): List<A> = foldLeft(reverse(a1), a2) { y, x ->
    Cons(x, y)
}

fun <A> appendR(a1: List<A>, a2: List<A>): List<A> = foldRight(a1, a2) { x, y ->
    Cons(x, y)
}