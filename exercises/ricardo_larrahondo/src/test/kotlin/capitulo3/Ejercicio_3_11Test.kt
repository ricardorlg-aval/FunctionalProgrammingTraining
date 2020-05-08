package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_11Test : WordSpec({
    "list reverse" should {
        "reverse list elements" {
            reverse(List.of(1, 2, 3, 4, 5)) shouldBe
                    List.of(5, 4, 3, 2, 1)
        }
    }
})
