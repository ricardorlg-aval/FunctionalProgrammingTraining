package capitulo3


fun <A> filter2(xa: List<A>, f: (A) -> Boolean): List<A> =
        flatMap(xa) { a ->
            if (f(a)) List.of(a)
            else List.empty()
        }
