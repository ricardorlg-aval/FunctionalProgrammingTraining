package capitulo4

import capitulo3.Cons
import capitulo3.List
import capitulo3.Nil
import capitulo4.Ejercicio4_3.map2

object Ejercicio4_5 {
    fun <A, B> traverse(
            xa: List<A>,
            f: (A) -> Option<B>
    ): Option<List<B>> = when (xa) {
        Nil -> Some(Nil)
        is Cons -> map2(f(xa.head), traverse(xa.tail, f)) { b: B, list: List<B> ->
            Cons(b, list)
        }
    }

    fun <A> sequence(xs: List<Option<A>>): Option<List<A>> = traverse(xs) { it }

}