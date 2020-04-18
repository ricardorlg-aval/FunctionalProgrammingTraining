package capitulo2

object Ejercicio2_3 {

    fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C = { a -> { b -> f(a, b) } }

}