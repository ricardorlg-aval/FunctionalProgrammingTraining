package capitulo2

import capitulo2.Ejercicio2_3.curry
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class Ejercicio2_3Test : WordSpec({

    "curry" should {
        """break down a function that takes multiple arguments into
            a series of functions that each take only oneargument""" {

            val f: (Int) -> (Int) -> String =
                curry { a: Int, b: Int -> "$a:$b" }
            val y = f(1)(2)
            val z = f(1)(3)
            y shouldBe "1:2"
            z shouldBe "1:3"
        }
    }
})
