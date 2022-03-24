package a01b

import org.junit.Test
import org.junit.Assert.*
import u04lab.code.{FactoryList, FactoryListImpl}
import u04lab.code.List.*

class testFactoryList :
  @Test
  def createList(): Unit =
    val factory :FactoryList = FactoryListImpl()
    assertEquals(Cons(1, Nil()), factory.List(1))
    assertEquals(Cons(1, Cons(2, Cons(3, Nil()))), factory.List(1, 2, 3))
