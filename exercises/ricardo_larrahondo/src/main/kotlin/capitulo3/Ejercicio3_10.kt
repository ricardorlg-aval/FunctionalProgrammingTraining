package capitulo3


fun sumL(xs: List<Int>): Int = foldLeft(xs, 0) { x, y -> x + y }

fun productL(xs: List<Double>): Double = foldLeft(xs, 1.0) { x, y -> x * y }

fun <A> lengthL(xs: List<A>): Int = foldLeft(xs, 0) { x, _ -> x + 1 }