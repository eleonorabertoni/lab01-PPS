package u04lab.code
import u04lab.code.List.*
import u04lab.code.List

trait FactoryList:
  def List[A](e: A*) : List[A]

case class FactoryListImpl() extends FactoryList:
  override def List[A](e: A*): List[A] =
    var l: List[A] = Nil()
    e foreach (x => l = append(l, Cons(x, Nil())))
    l