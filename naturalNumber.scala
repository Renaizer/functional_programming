// recursive data Structures for the Natural numeber

abstract class Nat {
  def isZero:Boolean
  def predecessor:Nat
  def successor:Nat
  def +(that:Nat) :Nat
  def -(that:Nat) :Nat
}

object Zero extends Nat{
  def isZero: Boolean = true
  def predecessor: Nat = ???
  def successor: Nat = Succ(this)
  def +(that: Nat): Nat = that
  def -(that: Nat): Nat = if (that.isZero) this else ???

  override def toString: String = "Zero"
}

case class Succ(n:Nat) extends Nat{
  def isZero: Boolean = false
  def predecessor: Nat = n
  def successor: Nat = Succ(this)
  def +(that: Nat): Nat = Succ(n + that)
  def -(that: Nat): Nat = if (that.isZero) this else (n - that.predecessor)
  override def toString: String = s"Succ($n)"
}

object sample4 extends App{
 val two = Succ(Succ(Zero))
 val one = Succ(Zero)

 val three= two + one

  println(one)
  println(two)
  println(three)

}





