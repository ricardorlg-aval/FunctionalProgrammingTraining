package capitulo3

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_5Test : WordSpec({
    "list init" should {
        "return all but the last element" {
            init(List.of(1, 2, 3, 4, 5)) shouldBe
                    List.of(1, 2, 3, 4)
        }

        "return Nil if only one element exists" {
            init(List.of(1)) shouldBe Nil
        }

        "throw an exception if no elements exist" {
            shouldThrow<IllegalStateException> {
                init(List.empty<Int>())
            }
        }
    }
})
