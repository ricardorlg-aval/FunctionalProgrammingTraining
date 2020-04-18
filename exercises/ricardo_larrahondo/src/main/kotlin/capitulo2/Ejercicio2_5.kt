package capitulo2

object Ejercicio2_5 {
    fun <A, B, C> compose(
        f: (B) -> C,
        g: (A) -> B
    ): (A) -> C = { a -> f(g(a)) }
}