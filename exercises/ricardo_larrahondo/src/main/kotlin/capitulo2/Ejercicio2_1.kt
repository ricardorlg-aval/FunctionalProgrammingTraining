package capitulo2

//Write a recursive function to get the th n Fibonacci number

object Ejercicio2_1 {
    fun fibonacciTailRecursion(n: Int): Int {
        tailrec fun fib(k: Int, current: Int, previous: Int): Int = when (k) {
            0 -> previous
            1 -> current
            else -> fib(k - 1, current + previous, current)
        }
        return fib(n, 1, 0)
    }

    fun fibonacciNoTailRecursion(n: Int): Int {
        return when {
            n > 1 -> {
                fibonacciNoTailRecursion(n - 1) + fibonacciNoTailRecursion(n - 2)
            }
            n == 1 -> {
                1
            }
            n == 0 -> {
                0
            }
            else -> { //error
                error("El número debe ser mayor a 0")
            }
        }
    }

}