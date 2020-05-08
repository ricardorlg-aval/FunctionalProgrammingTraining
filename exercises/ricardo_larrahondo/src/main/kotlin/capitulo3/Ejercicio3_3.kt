package capitulo3


tailrec fun <A> drop(l: List<A>, n: Int): List<A> =
        if (n == 0) l
        else when (l) {
            Nil -> throw IllegalStateException("Cannot drop more elements")
            is Cons -> drop(l.tail, n - 1)
        }
