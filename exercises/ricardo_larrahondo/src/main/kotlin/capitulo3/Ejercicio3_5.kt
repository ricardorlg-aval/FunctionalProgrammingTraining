package capitulo3


fun <A> init(l: List<A>): List<A> =
        when (l) {
            Nil -> throw IllegalStateException("Cannot init Nil list")
            is Cons -> if (l.tail == Nil) Nil
            else Cons(l.head, init(l.tail))
        }
