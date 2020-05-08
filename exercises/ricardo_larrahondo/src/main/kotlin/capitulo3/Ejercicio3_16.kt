package capitulo3


fun doubleToString(xs: List<Double>): List<String> = foldRight(xs, List.empty()) { d, ls -> Cons(d.toString(), ls) }