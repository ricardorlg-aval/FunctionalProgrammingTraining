package capitulo2

import capitulo2.Ejercicio2_5.compose
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class Ejercicio2_5Test : WordSpec({

    "compose" should {
        "apply function composition over two functions" {
            val fahrenheit2celsius: (Double) -> String =
                compose<Double, Double, String>(
                    { b -> "$b degrees celsius" },
                    { a -> (a - 32.0) * (5.0 / 9.0) }
                )

            fahrenheit2celsius(68.0) shouldBe "20.0 degrees celsius"
        }
    }
})
