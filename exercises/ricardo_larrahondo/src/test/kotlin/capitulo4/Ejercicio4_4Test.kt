package capitulo4

import capitulo3.List
import capitulo4.Ejercicio4_4.sequence
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class Ejercicio4_4Test : WordSpec({
    "sequence" should {
        "turn a list of some options into an option of list" {
            val lo = List.of(Some(10), Some(20), Some(30))
            sequence(lo) shouldBe Some(List.of(10, 20, 30))
        }
        "turn a list of options containing none into a none" {
            val lo = List.of(Some(10), None, Some(30))
            sequence(lo) shouldBe None
        }
    }

})
