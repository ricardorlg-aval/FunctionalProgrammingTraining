package capitulo2

import capitulo2.Ejercicio2_4.uncurry
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class Ejercicio2_4Test : WordSpec({

    "uncurry" should {
        """take a function accepting two values and then apply that
            function to the components of the pair which is the
            second argument""" {

            val f: (Int, Int) -> String =
                uncurry<Int, Int, String> { a -> { b -> "$a:$b" } }
            f(1, 2) shouldBe "1:2"
            f(1, 3) shouldBe "1:3"
        }
    }
})
