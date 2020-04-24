def fib(n: Long): Long = {
  @annotation.tailrec
  def loop(n: Long, prev:Long, next:Long) : Long = n match{
    case 0 => prev
    case 1 => next
    case _ => loop(n-1,next,(next+prev))
  }
  loop(n,0,1)
}
fib(1)
fib(2)
fib(10)
fib(20)
fib(30)
fib(40)
fib(50)