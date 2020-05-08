package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_17Test : WordSpec({
    "list map" should {
        "apply a function to every list element" {
            map(List.of(1, 2, 3, 4, 5)) { it * 10 } shouldBe
                    List.of(10, 20, 30, 40, 50)
        }
    }
})
