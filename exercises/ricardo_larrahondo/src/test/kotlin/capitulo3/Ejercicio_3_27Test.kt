package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_27Test : WordSpec({
    "tree map" should {
        "transform all leaves of a map" {
            val actual =
                    Branch(
                            Branch(
                                    Leaf(1),
                                    Leaf(2)
                            ),
                            Branch(
                                    Leaf(3),
                                    Leaf(4)
                            )
                    )
            val expected = Branch(
                    Branch(
                            Leaf(10),
                            Leaf(20)
                    ),
                    Branch(
                            Leaf(30),
                            Leaf(40)
                    )
            )
            map(actual) { it * 10 } shouldBe expected
        }
    }
})
