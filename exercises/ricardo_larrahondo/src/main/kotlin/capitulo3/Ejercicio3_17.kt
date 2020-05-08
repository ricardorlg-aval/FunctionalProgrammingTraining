package capitulo3


fun <A, B> map(xs: List<A>, f: (A) -> B): List<B> = foldRightL(xs, List.empty()) { a, list -> Cons(f(a), list) }