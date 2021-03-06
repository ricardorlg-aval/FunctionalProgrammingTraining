package capitulo4

import capitulo4.Ejercicio4_1.filter
import capitulo4.Ejercicio4_1.filter_2
import capitulo4.Ejercicio4_1.flatMap
import capitulo4.Ejercicio4_1.flatMap_2
import capitulo4.Ejercicio4_1.getOrElse
import capitulo4.Ejercicio4_1.map
import capitulo4.Ejercicio4_1.orElse
import capitulo4.Ejercicio4_1.orElse_2
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class Ejercicio4_1Test : WordSpec({

    val none = Option.empty<Int>()

    val some = Some(10)

    "option map" should {
        "transform an option of some value" {
            some.map { it * 2 } shouldBe Some(20)
        }
        "pass over an option of none" {
            none.map { it * 10 } shouldBe None
        }
    }

    "option flatMap" should {
        """apply a function yielding an option to an
            option of some value""" {
            some.flatMap { a ->
                Some(a.toString())
            } shouldBe Some("10")

            some.flatMap_2 { a ->
                Some(a.toString())
            } shouldBe Some("10")
        }
        "pass over an option of none" {
            none.flatMap { a ->
                Some(a.toString())
            } shouldBe None

            none.flatMap_2 { a ->
                Some(a.toString())
            } shouldBe None
        }
    }

    "option getOrElse" should {
        "extract the value of some option" {
            some.getOrElse { 0 } shouldBe 10
        }
        "return a default value if the option is none" {
            none.getOrElse { 10 } shouldBe 10
        }
    }

    "option orElse" should {
        "return the option if the option is some" {
            some.orElse { Some(20) } shouldBe some
            some.orElse_2 { Some(20) } shouldBe some
        }
        "return a default option if the option is none" {
            none.orElse { Some(20) } shouldBe Some(20)
            none.orElse_2 { Some(20) } shouldBe Some(20)
        }
    }

    "option filter" should {
        "return some option if the predicate is met" {
            some.filter { it > 0 } shouldBe some
            some.filter_2 { it > 0 } shouldBe some
        }
        "return a none option if the predicate is not met" {
            some.filter { it < 0 } shouldBe None
            some.filter_2 { it < 0 } shouldBe None
        }
    }
})