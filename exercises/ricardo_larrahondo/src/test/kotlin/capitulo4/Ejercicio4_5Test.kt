package capitulo4

import capitulo3.List
import capitulo4.Ejercicio4_5.sequence
import capitulo4.Ejercicio4_5.traverse
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class Ejercicio4_5Test : WordSpec({
    fun <A> catches(a: () -> A): Option<A> =
            try {
                Some(a())
            } catch (e: Throwable) {
                None
            }

    "traverse" should {
        """return some option of a transformed list if all
            transformations succeed""" {
            val xa = List.of(1, 2, 3, 4, 5)
            traverse(xa) { a: Int ->
                catches { a.toString() }
            } shouldBe Some(List.of("1", "2", "3", "4", "5"))
        }

        "return a none option if any transformations fail" {
            val xa = List.of("1", "2", "x", "4")
            traverse(xa) { a ->
                catches { a.toInt() }
            } shouldBe None
        }
    }

    "sequence" should {
        "turn a list of some options into an option of list" {
            val lo =
                    List.of(Some(10), Some(20), Some(30))
            sequence(lo) shouldBe Some(List.of(10, 20, 30))
        }

        "turn a list of options containing a none into a none" {
            val lo =
                    List.of(Some(10), None, Some(30))
            sequence(lo) shouldBe None
        }
    }

})
