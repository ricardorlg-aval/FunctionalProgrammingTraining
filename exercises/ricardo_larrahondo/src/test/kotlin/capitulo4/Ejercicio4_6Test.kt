package capitulo4

import capitulo4.Ejercicio4_6.flatMap
import capitulo4.Ejercicio4_6.map
import capitulo4.Ejercicio4_6.map2
import capitulo4.Ejercicio4_6.orElse
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class Ejercicio4_6Test : WordSpec({
    val right: Either<Throwable, Int> = Right(1)

    val left: Either<Throwable, Int> = Left(Throwable("boom"))

    "Either.map" should {
        "transform a right value" {
            right.map { it.toString() } shouldBe Right("1")
        }
        "pass over a left value" {
            left.map { it.toString() } shouldBe left
        }
    }

    "Either.orElse" should {
        "return the either if it is right" {
            right.orElse { left } shouldBe right
        }
        "pass the default value if either is left" {
            left.orElse { right } shouldBe right
        }
    }

    "Either.flatMap" should {
        "apply a function yielding an either to a right either" {
            right.flatMap { a ->
                Right(a.toString())
            } shouldBe Right("1")
        }
        "pass on the left value" {
            left.flatMap { a ->
                Right(a.toString())
            } shouldBe left
        }
    }

    "Either.map2" should {
        val right1: Right<Int> = Right(3)
        val right2: Right<Int> = Right(2)
        val left1: Either<Throwable, Int> =
                Left(IllegalArgumentException("boom"))
        val left2: Either<Throwable, Int> =
                Left(IllegalStateException("pow"))

        "combine two either right values using a binary function" {
            map2(
                    right1,
                    right2
            ) { a, b ->
                (a * b).toString()
            } shouldBe Right("6")
        }
        "return left if either is left" {
            map2(
                    right1,
                    left1
            ) { a, b ->
                (a * b).toString()
            } shouldBe left1
        }
        "return the first left if both are left" {
            map2(
                    left1,
                    left2
            ) { a, b ->
                (a * b).toString()
            } shouldBe left1
        }
    }

})
