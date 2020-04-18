package capitulo2

object Ejercicio2_4 {
    fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C = { a:A, b: B -> f(a).invoke(b) }
}