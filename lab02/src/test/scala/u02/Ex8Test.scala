package u02
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import u02.Ex8.*


class Ex8Test :

  @Test def testFilter(): Unit =
    assertEquals(Option.Some(5), Option.filter(Option.Some(5))(_ > 2))
    assertEquals(Option.None(), Option.filter(Option.Some(5))(_ > 8))
    assertEquals(Option.None(), Option.filter(Option.None[Int]())(_ > 8))

  @Test def testMap(): Unit =
    assertEquals(Option.Some(true), Option.map(Option.Some(5))(_ > 2))
    assertEquals(Option.Some(false), Option.map(Option.Some(5))(_ > 8))
    assertEquals(Option.None(), Option.map(Option.None[Int]())(_ > 8))

  @Test def testMap2(): Unit =
    assertEquals(Option.None(), Option.map2(Option.None[Int]())(Option.Some(5)))
    assertEquals(Option.None(), Option.map2(Option.Some(5))(Option.None[Int]()))
    assertEquals(Option.Some(1, 2), Option.map2(Option.Some(1))(Option.Some(2)))
    assertEquals(Option.Some(2, 1), Option.map2(Option.Some(2))(Option.Some(1)))
