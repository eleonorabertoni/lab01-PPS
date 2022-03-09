package u02

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import Ex6.*

class Ex6Test :
  @Test def fibTest(): Unit =
    assertEquals(0,fib(0))
    assertEquals(1,fib(1))
    assertEquals(1,fib(2))
    assertEquals(2,fib(3))
    assertEquals(3,fib(4))
    assertEquals(5,fib(5))
    assertEquals(8,fib(6))