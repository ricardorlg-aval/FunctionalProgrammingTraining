package capitulo3


fun increment(xs: List<Int>): List<Int> = foldRight(xs, List.empty()) { a, b -> Cons(a + 1, b) }