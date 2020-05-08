package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_8Test : WordSpec({
    "list length" should {
        "calculate the length" {
            length(List.of(1, 2, 3, 4, 5)) shouldBe 5
        }

        "calculate zero for an empty list" {
            length(Nil) shouldBe 0
        }
    }
})
