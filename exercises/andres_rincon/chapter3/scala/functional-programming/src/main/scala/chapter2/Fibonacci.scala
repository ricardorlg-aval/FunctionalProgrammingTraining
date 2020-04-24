package chapter2

import scala.annotation.tailrec

object Fibonacci {

  def fibonacci(n: Long): Long = {
    @tailrec
    def loop(current: Long, first: Long, second: Long): Long =
      current match {
        case 0 => first
        case 1 => second
        case _ => loop(current - 1, second, (second + first))
      }

    loop(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    println(fibonacci(10))
  }
}
