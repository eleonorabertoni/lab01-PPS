package u02

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import Ex7.*
import scala.math.Pi

class Ex7Test :

  @Test def testRectanglePerimeter(): Unit =
    val r = Shape.Rectangle(5, 10)
    assertEquals(30, perimeter(r), 0)

  @Test def testRectangleArea(): Unit =
    val r = Shape.Rectangle(5, 10)
    assertEquals(50, area(r), 0)

  @Test def testCirclePerimeter(): Unit =
    val c = Shape.Circle(10)
    assertEquals(20*Pi, perimeter(c), 0)

  @Test def testCircleArea(): Unit =
    val c = Shape.Circle(10)
    assertEquals(100*Pi, area(c), 0)

  @Test def testSquarePerimeter(): Unit =
    val s = Shape.Square(10)
    assertEquals(40, perimeter(s), 0)

  @Test def testSquareArea(): Unit =
    val s = Shape.Square(10)
    assertEquals(100, area(s), 0)



