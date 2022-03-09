package u02

import scala.annotation.tailrec

object Ex6 extends App{

  def fib(num: Int): Int =
    @annotation.tailrec
    def _tail(n: Int, acc1: Int, acc2: Int): Int = n match
      case 0 => acc1
      case 1 => acc2
      case _ => _tail(n - 1, acc2, acc1 + acc2)
    _tail(num, 0, 1)
}
