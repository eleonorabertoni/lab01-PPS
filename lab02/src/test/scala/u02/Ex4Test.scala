package u02

import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import org.junit.Test
import Ex4.*

class Ex4Test :
  @Test def testCurriedVal(): Unit =
    assertTrue(p1(1)(2)(3))
    assertFalse(p1(1)(3)(2))

  @Test def testUncurriedVal(): Unit =
    assertTrue(p2(1, 2, 3))
    assertFalse(p2(1, 3, 2))

  @Test def testCurriedDef(): Unit =
    assertTrue(p3(1)(2)(3))
    assertFalse(p3(1)(3)(2))

  @Test def testUncurriedDef(): Unit =
    assertTrue(p4(1,2,3))
    assertFalse(p4(1,3,2))

