package u04lab.polyglot.a01b
import scala.jdk.javaapi.OptionConverters
import u04lab.polyglot.OptionToOptional
import u04lab.code.Option
import u04lab.code.Option.*

import scala.util.Random
import u04lab.code.List.*
import u04lab.code.List
import u04lab.code.Stream.*
import u04lab.code.Stream

import scala.annotation.tailrec

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */

class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:
  val random: Random = Random(3)
  val minesList: List[(Int, Int)] = minesSetup(mines, Nil())
  var selected: List[(Int, Int)] = Nil()
  print(minesList)

  @tailrec
  private def minesSetup(nElements: Int, list: List[(Int, Int)]): List[(Int, Int)] = (length(list), random.nextInt(size), random.nextInt(size)) match
    case (l, _, _) if l == mines => list
    case (l, a, b) if !contains(list, (a, b)) => minesSetup(nElements-1, Cons((a,b), list))
    case _ => minesSetup(nElements, list)

  private def neighbours(x: Int, y: Int): Int =
    var n = 0
    for x <- x-1 to x + 1 do n = n + length(List.filter(toList(Stream.take(Stream.iterate(x, y -1)((x,y) => (x,y+1)))(3)))(e => contains(minesList, e)))
    n

  def hit(x: Int, y: Int): java.util.Optional[Integer] = contains(minesList, (x,y)) match
    case true => OptionToOptional(None()) // Option => Optional converter
    case _ => selected = append(Cons((x,y), Nil()), selected); OptionToOptional(Some(neighbours(x, y)))

  def won: Boolean = mines != size * size && size * size - mines == length(selected)
