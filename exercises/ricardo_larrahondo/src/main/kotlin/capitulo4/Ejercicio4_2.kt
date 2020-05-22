package capitulo4

import capitulo3.List
import capitulo4.Boilerplate.isEmpty
import capitulo4.Boilerplate.map
import capitulo4.Boilerplate.size
import capitulo4.Boilerplate.sum
import capitulo4.Ejercicio4_1.flatMap
import kotlin.math.pow

object Ejercicio4_2 {
    fun mean(xs: List<Double>): Option<Double> =
            if (xs.isEmpty()) None
            else Some(xs.sum() / xs.size())

    fun variance(xs: List<Double>): Option<Double> =
            mean(xs).flatMap { m ->
                mean(xs.map { x -> (x - m).pow(2) })
            }
}