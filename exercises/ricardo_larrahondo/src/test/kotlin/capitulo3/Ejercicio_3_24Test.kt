package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_24Test : WordSpec({
    "tree size" should {
        "determine the total size of a tree" {
            val tree =
                    Branch(
                            Branch(Leaf(1), Leaf(2)),
                            Branch(Leaf(3), Leaf(4))
                    )
            size(tree) shouldBe 7
        }
    }
})
