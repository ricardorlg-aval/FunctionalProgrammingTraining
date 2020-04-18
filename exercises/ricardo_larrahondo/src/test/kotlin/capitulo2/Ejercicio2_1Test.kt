package capitulo2

import capitulo2.Ejercicio2_1.fibonacciNoTailRecursion
import capitulo2.Ejercicio2_1.fibonacciTailRecursion
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.longs.shouldBeLessThan
import io.kotest.matchers.shouldBe
import kotlinx.collections.immutable.persistentMapOf
import kotlin.system.measureTimeMillis
import kotlin.time.milliseconds

class Ejercicio2_1Test : WordSpec({

    "Fibbonacci with tail recursion" should {

        "return the nth fibonacci number" {
            persistentMapOf(
                Pair(1, 1),
                Pair(2, 1),
                Pair(3, 2),
                Pair(4, 3),
                Pair(5, 5),
                Pair(6, 8),
                Pair(7, 13),
                Pair(8, 21)
            ).forEach { (n, num) ->
                fibonacciTailRecursion(n) shouldBe num
            }
        }

        "has a better time perfomance than classic recurssion implementation"{
            val n = 40
            val timeWithTail = measureTimeMillis {
                fibonacciTailRecursion(n)
            }.also {
                println("Tiempo con tail recurssion: ${it.milliseconds}")
            }
            val timeNoTail = measureTimeMillis {
                fibonacciNoTailRecursion(n)
            }.also {
                println("Tiempo sin tail recurssion: ${it.milliseconds}")
            }
            timeWithTail shouldBeLessThan timeNoTail
        }
    }

})