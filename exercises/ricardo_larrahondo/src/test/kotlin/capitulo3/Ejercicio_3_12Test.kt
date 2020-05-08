package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_12Test : WordSpec({
    "list foldLeftR" should {
        "implement foldLeft functionality using foldRight" {
            foldLeftR(
                    List.of(1, 2, 3, 4, 5),
                    0,
                    { x, y -> x + y }) shouldBe 15
        }
    }

    "list foldRightL" should {
        "implement foldRight functionality using foldLeft" {
            foldRightL(
                    List.of(1, 2, 3, 4, 5),
                    0,
                    { x, y -> x + y }) shouldBe 15
        }
    }
})
