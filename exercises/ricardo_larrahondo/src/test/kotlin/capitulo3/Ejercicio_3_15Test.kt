package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_15Test : WordSpec({
    "list increment" should {
        "add 1 to every element" {
            increment(
                    List.of(1, 2, 3, 4, 5)
            ) shouldBe List.of(2, 3, 4, 5, 6)
        }
    }
})
