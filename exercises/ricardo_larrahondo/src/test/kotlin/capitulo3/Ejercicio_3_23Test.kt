package capitulo3

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


class Ejercicio_3_23Test : WordSpec({
    "list subsequence" should {
        "determine if a list starts with" {
            startsWith(
                    List.of(1, 2, 3),
                    List.of(1)
            ) shouldBe true
            startsWith(
                    List.of(1, 2, 3),
                    List.of(1, 2)
            ) shouldBe true
            startsWith(
                    List.of(1, 2, 3),
                    List.of(1, 2, 3)
            ) shouldBe true
            startsWith(
                    List.of(1, 2, 3),
                    List.of(2, 3)
            ) shouldBe false
            startsWith(
                    List.of(1, 2, 3),
                    List.of(3)
            ) shouldBe false
            startsWith(
                    List.of(1, 2, 3),
                    List.of(6)
            ) shouldBe false
        }

        "identify subsequences of a list" {
            hasSubsequence(
                    List.of(1, 2, 3, 4, 5),
                    List.of(1)
            ) shouldBe true
            hasSubsequence(
                    List.of(1, 2, 3, 4, 5),
                    List.of(1, 2)
            ) shouldBe true
            hasSubsequence(
                    List.of(1, 2, 3, 4, 5),
                    List.of(2, 3)
            ) shouldBe true
            hasSubsequence(
                    List.of(1, 2, 3, 4, 5),
                    List.of(3, 4)
            ) shouldBe true
            hasSubsequence(
                    List.of(1, 2, 3, 4, 5),
                    List.of(3, 4, 5)
            ) shouldBe true
            hasSubsequence(
                    List.of(1, 2, 3, 4, 5),
                    List.of(4)
            ) shouldBe true

            hasSubsequence(
                    List.of(1, 2, 3, 4, 5),
                    List.of(1, 4)
            ) shouldBe false
            hasSubsequence(
                    List.of(1, 2, 3, 4, 5),
                    List.of(1, 3)
            ) shouldBe false
            hasSubsequence(
                    List.of(1, 2, 3, 4, 5),
                    List.of(2, 4)
            ) shouldBe false
        }
    }
})
