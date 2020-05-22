package capitulo4

import capitulo3.List
import capitulo4.Ejercicio4_1.getOrElse
import capitulo4.Ejercicio4_2.variance
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe


class Ejercicio4_2Test : WordSpec({

    "variance" should {
        "determine the variance of a list of numbers" {
            val ls = List.of(1.0, 1.1, 1.0, 3.0, 0.9, 0.4)
            variance(ls).getOrElse { 0.0 } shouldBe
                    (0.675).plusOrMinus(0.005)
        }
    }
})
