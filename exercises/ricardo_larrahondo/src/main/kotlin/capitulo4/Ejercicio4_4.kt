package capitulo4

import capitulo3.Cons
import capitulo3.List
import capitulo3.Nil
import capitulo4.Boilerplate.foldRight
import capitulo4.Ejercicio4_3.map2

object Ejercicio4_4 {
    fun <A> sequence(xs: List<Option<A>>): Option<List<A>> = xs.foldRight(Some(Nil))
    { option: Option<A>, some: Option<List<A>> ->
        map2(option, some) { a, list ->
            Cons(a, list)
        }
    }
}