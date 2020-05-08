package capitulo3


fun <A> tail(xs: List<A>): List<A> = when(xs){
    Nil -> throw IllegalStateException()
    is Cons -> xs.tail
}
