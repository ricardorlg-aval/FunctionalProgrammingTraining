package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_16Test : WordSpec({
    "list doubleToString" should {
        "convert every double element to a string" {
            doubleToString(
                    List.of(1.1, 1.2, 1.3, 1.4)
            ) shouldBe List.of("1.1", "1.2", "1.3", "1.4")
        }
    }
})
