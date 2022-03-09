package u02

object Ex8 extends App{
  enum Option[A]:
    case Some(a:A)
    case None()

  object  Option:
    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false

    def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
      case Some(a) => a
      case _ => orElse

    def flatMap[A,B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Some(a) => f(a)
      case _ => None()

    def filter[A, B](opt: Option[A])(f: A => Boolean): Option[A] = opt match
      case Option.Some(a: A) => f(a) match
        case true => Option.Some(a)
        case _ => None()
      case _ => None()

    def map[A,B](opt: Option[A])(f: A => Boolean): Option[Boolean] = opt match
      case Option.Some(a) => Option.Some(f(a))
      case _ => None()

    /*
    def map2[A,B,C](opt1: Option[A])(opt2: Option[B])(f: (Option[A], Option[B]) => C): Option[C] = (opt1, opt2) match
      case (Option.Some(_),Option.Some(_)) => Option.Some(f(opt1, opt2))
      case _ => Option.None()
    */
    def map2[A,B,C](opt1: Option[A])(opt2: Option[B]): Option[(A,B)] = (opt1, opt2) match
      case (Option.Some(a),Option.Some(b)) => Option.Some(a,b)
      case _ => Option.None()


}

