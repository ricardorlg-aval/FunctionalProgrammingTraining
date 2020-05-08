package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_14Test : WordSpec({
    "list concat" should {
        "concatenate a list of lists into a single list" {
            concat(
                    List.of(
                            List.of(1, 2, 3),
                            List.of(4, 5, 6)
                    )
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
            concat2(
                    List.of(
                            List.of(1, 2, 3),
                            List.of(4, 5, 6)
                    )
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }
})
