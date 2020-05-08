package capitulo3


fun <A, B> flatMap(xa: List<A>, f: (A) -> List<B>): List<B> =
        foldRight(xa, List.empty()) { a, list ->
            appendR(f(a), list)
        }

fun <A, B> flatMap2(xa: List<A>, f: (A) -> List<B>): List<B> =
        foldRight(xa, List.empty()) { a, list ->
            foldRight(f(a), list) { b, l2 ->
                Cons(b, l2)
            }
        }