package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_26Test : WordSpec({
    "tree depth" should {
        "determine the maximum depth from the root to any leaf" {
            val tree = Branch(
                    Branch(Leaf(1), Leaf(2)),
                    Branch(
                            Leaf(3),
                            Branch(
                                    Branch(
                                            Leaf(4),
                                            Leaf(5)
                                    ),
                                    Branch(
                                            Leaf(6),
                                            Branch(
                                                    Leaf(7),
                                                    Leaf(8)
                                            )
                                    )
                            )
                    )
            )
            depth(tree) shouldBe 5
        }
    }


})
