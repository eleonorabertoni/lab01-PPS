package u02

import org.junit.*
import org.junit.Assert.*
import BTrees.Tree.*
import Ex5.*

class Ex5Test :
  def composeTest(): Unit =
    assertEquals(9, compose(_ - 1, _ * 2)(5))

  def genericComposeTest(): Unit =
    assertEquals(9, genericCompose[Int, Int, Int](_ - 1, _ * 2)(5))
