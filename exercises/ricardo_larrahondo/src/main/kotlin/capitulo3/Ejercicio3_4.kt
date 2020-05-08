package capitulo3


tailrec fun <A> dropWhile(l: List<A>, f: (A) -> Boolean): List<A> =
        when (l) {
            Nil -> l
            is Cons -> if (f(l.head)) dropWhile(l.tail, f) else l
        }
