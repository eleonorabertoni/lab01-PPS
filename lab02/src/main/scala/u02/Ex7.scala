package u02
import scala.math.Pi
import scala.math.pow

object Ex7 extends App{
  enum Shape:
    case Rectangle(base: Double, height: Double)
    case Circle(radius: Double)
    case Square(side: Double)

  def perimeter(shape: Shape): Double = shape match
    case Shape.Rectangle(base, height) => 2 * (base + height)
    case Shape.Circle(radius) => 2 * Pi * radius
    case Shape.Square(side) => 4 * side

  def area(shape: Shape): Double = shape match
    case Shape.Rectangle(base, height) => base * height
    case Shape.Circle(radius) => pow(radius, 2) * Pi
    case Shape.Square(side) => pow(side, 2)


}
