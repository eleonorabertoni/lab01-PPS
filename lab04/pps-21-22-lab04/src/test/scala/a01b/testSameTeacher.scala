/*
package a01b

import org.junit.Test
import org.junit.Assert.*
import u04lab.code.Course
import u04lab.code.Course.sameTeacher
import u04lab.code.{Course, FactoryList, FactoryListImpl, List, Option, Student}
import u04lab.code.List.*
import u04lab.code.Option.*
import u04lab.code.Option


object sameTeacher:
  def unapply(courses: List[Course]) : Option[String] = courses match
    case Cons(head, tail) if length(filter(tail)(e => e.teacher == head.teacher)) == length(courses) => Some(head.teacher)

class testSameTeacher:

  @Test
  def testSameTeacherFunction(): Unit =
    val c1: Course = Course("corso0", "p0")
    val c2: Course = Course("corso1", "p1")
    val c3: Course = Course("corso2", "p0")
    val t = "p0"
    assertEquals(List(c1, c2, c3), s1.sameTeacher("p0"))
    val factory: FactoryList = FactoryListImpl()
    val courses: List[Course] = factory.List(c1, c2, c3)
    Some("p0") match
      case sameTeacher(courses) => println( s" $courses have same teacher $t")
      case _ => println( s" $courses have different teachers ")
*/