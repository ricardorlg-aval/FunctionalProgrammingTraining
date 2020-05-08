package capitulo3


fun <A> reverse(xs: List<A>): List<A> = foldLeft(xs, List.empty()) { x, y -> Cons(y, x) }