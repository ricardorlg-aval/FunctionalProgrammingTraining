package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_28Test : WordSpec({
    "tree fold" should {

        val tree = Branch(
                Branch(Leaf(1), Leaf(2)),
                Branch(
                        Leaf(3),
                        Branch(
                                Branch(Leaf(4), Leaf(5)),
                                Branch(
                                        Leaf(21),
                                        Branch(Leaf(7), Leaf(8))
                                )
                        )
                )
        )
        "generalise size" {
            sizeF(tree) shouldBe 15
        }

        "generalise maximum" {
            maximumF(tree) shouldBe 21
        }

        "generalise depth" {
            depthF(tree) shouldBe 5
        }

        "generalise map" {
            mapF(tree) { it * 10 } shouldBe
                    Branch(
                            Branch(Leaf(10), Leaf(20)),
                            Branch(
                                    Leaf(30),
                                    Branch(
                                            Branch(Leaf(40), Leaf(50)),
                                            Branch(
                                                    Leaf(210),
                                                    Branch(Leaf(70), Leaf(80))
                                            )
                                    )
                            )
                    )
        }
    }
})
