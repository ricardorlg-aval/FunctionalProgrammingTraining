package capitulo3


fun add(xa: List<Int>, xb: List<Int>): List<Int> =
        when (xa) {
            Nil -> Nil
            is Cons -> when (xb) {
                Nil -> Nil
                is Cons -> Cons(xa.head + xb.head, add(xa.tail, xb.tail))
            }
        }

