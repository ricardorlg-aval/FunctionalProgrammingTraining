package capitulo2

import utils.head
import utils.tail

//Implement isSorted, which checks whether a List<A> is sorted according to a given comparison function.
object Ejercicio2_2 {
    fun <A> isSorted(list: List<A>, ordered: (A, A) -> Boolean): Boolean {
        tailrec fun loop(x: A, xs: List<A>): Boolean =
            if (xs.isEmpty()) true
            else if (!ordered(x, xs.head)) false
            else loop(xs.head, xs.tail)
        return list.isEmpty() || loop(list.head, list.tail)
    }
}