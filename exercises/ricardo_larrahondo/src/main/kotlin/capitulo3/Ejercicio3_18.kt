package capitulo3


fun <A> filter(xs: List<A>, f: (A) -> Boolean): List<A> =
        foldRightL(xs, List.empty()) { a, list ->
            if (f(a)) Cons(a, list)
            else list
        }