package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_21Test : WordSpec({
    "list add" should {
        "add elements of two corresponding lists" {
            add(
                    List.of(1, 2, 3),
                    List.of(4, 5, 6)
            ) shouldBe List.of(5, 7, 9)
        }
    }
})
