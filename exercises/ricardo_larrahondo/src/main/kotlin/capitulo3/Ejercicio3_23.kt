package capitulo3


tailrec fun <A> hasSubsequence(xs: List<A>, sub: List<A>): Boolean =
        when (xs) {
            is Nil -> false
            is Cons -> when (sub) {
                is Nil -> false
                is Cons -> if (startsWith(xs, sub)) true
                else hasSubsequence(xs.tail, sub)
            }
        }

tailrec fun <A> startsWith(l1: List<A>, l2: List<A>): Boolean =
        when (l1) {
            Nil -> l2 == Nil
            is Cons -> when (l2) {
                Nil -> true
                is Cons ->
                    if (l1.head == l2.head)
                        startsWith(l1.tail, l2.tail)
                    else false
            }
        }



