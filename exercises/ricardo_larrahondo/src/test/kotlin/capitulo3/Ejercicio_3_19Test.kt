package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_19Test : WordSpec({
    "list flatmap" should {
        "map and flatten a list" {

            flatMap(List.of(1, 2, 3)) { i ->
                List.of(i, i)
            } shouldBe List.of(1, 1, 2, 2, 3, 3)

            flatMap2(List.of(1, 2, 3)) { i ->
                List.of(i, i)
            } shouldBe List.of(1, 1, 2, 2, 3, 3)
        }
    }
})
