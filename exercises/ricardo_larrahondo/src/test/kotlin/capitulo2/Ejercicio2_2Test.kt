package capitulo2

import capitulo2.Ejercicio2_2.isSorted
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import kotlinx.collections.immutable.persistentListOf

class Ejercicio2_2Test : WordSpec({

    "isSorted" should {
        "detect ordering of a list of correctly ordered Ints based on an ordering HOF" {
            isSorted(persistentListOf(1, 2, 3)) { a, b -> b > a } shouldBe true
        }
        "detect ordering of a list of incorrectly ordered Ints based on an ordering HOF" {
            isSorted(
                persistentListOf(1, 3, 2)
            ) { a, b -> b > a } shouldBe false
        }
        "verify ordering of a list of correctly ordered Strings based on an ordering HOF" {
            isSorted(
                persistentListOf("a", "b", "c")
            ) { a, b -> b > a } shouldBe true
        }
        "verify ordering of a list of incorrectly ordered Strings based on an ordering HOF" {
            isSorted(
                persistentListOf("a", "z", "w")
            ) { a, b -> b > a } shouldBe false
        }
        "return true for an empty list" {
            isSorted(persistentListOf<Int>()) { a, b ->
                b > a
            } shouldBe true
        }
    }
})
