package capitulo4

import capitulo3.Cons
import capitulo4.Ejercicio4_6.map2
import capitulo3.List
import capitulo3.Nil
import capitulo4.Boilerplate.foldRight

object Ejercicio4_7 {
    fun <E, A, B> traverse(
            xs: List<A>,
            f: (A) -> Either<E, B>
    ): Either<E, List<B>> = xs.foldRight(Right(Nil)) { a: A, right: Either<E, List<B>> ->
        map2(f(a), right) { b: B, list: List<B> ->
            Cons(b, list)
        }
    }


    fun <E, A> sequence(es: List<Either<E, A>>): Either<E, List<A>> =
            traverse(es) { it }
}