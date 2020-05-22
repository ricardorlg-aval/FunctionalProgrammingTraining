package capitulo4

import capitulo4.Ejercicio4_1.flatMap
import capitulo4.Ejercicio4_1.map

object Ejercicio4_3 {
    fun <A, B, C> map2(optionA: Option<A>, optionB: Option<B>, f: (A, B) -> C): Option<C> =
            optionA.flatMap { a ->
                optionB.map { b ->
                    f(a, b)
                }
            }
}