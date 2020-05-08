package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_13Test : WordSpec({
    "list append" should {
        "append two lists to each other using foldRight" {
            appendR(
                    List.of(1, 2, 3),
                    List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }
    "list appendL" should {
        "append two lists to each other using foldLeft" {
            appendL(
                    List.of(1, 2, 3),
                    List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }
})
