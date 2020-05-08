package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_20Test : WordSpec({
    "list filter" should {
        "filter out elements not compliant to predicate" {
            filter2(
                    List.of(1, 2, 3, 4, 5)
            ) { it % 2 == 0 } shouldBe List.of(2, 4)
        }
    }
})
