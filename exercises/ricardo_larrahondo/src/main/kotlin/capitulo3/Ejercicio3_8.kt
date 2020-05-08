package capitulo3


fun <A> length(xs: List<A>): Int = foldRight(xs, 0) { _, acc -> acc + 1 }
