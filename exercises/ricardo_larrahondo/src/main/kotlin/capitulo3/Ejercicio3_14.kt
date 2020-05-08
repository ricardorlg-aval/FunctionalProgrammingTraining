package capitulo3


fun <A> concat(xxs: List<List<A>>): List<A> =
        foldRight(xxs, List.empty()) { xs1, xs2 -> foldRight(xs1, xs2) { a, list -> Cons(a, list) } }

fun <A> concat2(xxs: List<List<A>>): List<A> =
        foldRight(xxs, List.empty()) { xs1, xs2 -> appendR(xs1, xs2) }