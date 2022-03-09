package u02

import org.junit.*
import org.junit.Assert.*
import BTrees.Tree.*
import Ex3.*

class Ex3Test :
  val empty: String => Boolean = _ == ""

  @Test def testParityMethodSyntax(): Unit =
    checkParity(parityMethodSyntax)

  @Test def testParityLambda(): Unit =
    checkParity(parityLambda)

  @Test def testNegMethodSyntax(): Unit =
    checkNeg(negMethodSyntax(empty))

  @Test def testNegLambda(): Unit =
    checkNeg(negMethodSyntax(empty))

  @Test def testNegGenericString(): Unit =
    checkNeg(negGeneric(empty))

  @Test def testNegGenericInt(): Unit =
    val f: Int => Boolean = _ == 1
    assertTrue(f(1))
    assertFalse(f(5))

  private def checkNeg(f: String => Boolean): Unit =
    assertTrue(f("foo"))
    assertFalse(f(""))
    assertTrue(f("foo") && !f(""))

  private def checkParity(f: Int => String): Unit =
    assertEquals("odd", f(3))
    assertEquals("even", f(4))
