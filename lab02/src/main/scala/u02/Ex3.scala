package u02

object Ex3 extends App {

  def parityMethodSyntax(n: Int): String = n % 2 match
    case 0 => "even"
    case _ => "odd"

  val parityLambda: Int => String = n => n % 2 match
    case 0 => "even"
    case _ => "odd"

  def negMethodSyntax(f: String => Boolean): String => Boolean =
    !f(_)

  val negLambda : (String => Boolean) => String => Boolean =
    f => i => !f(i)

  def negGeneric[X](f : X => Boolean): X => Boolean =
    !f(_)

}
