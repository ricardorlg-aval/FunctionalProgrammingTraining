package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_9Test : WordSpec({
    "list foldLeft" should {
        """!apply a function f providing a zero accumulator from tail
            recursive position""" {
            foldLeft(
                    List.of(1, 2, 3, 4, 5),
                    0,
                    { x, y -> x + y }) shouldBe 15
        }
    }
})
