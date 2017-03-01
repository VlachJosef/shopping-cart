package io.vlach

abstract class Fruit(val cost: Long)
case object Apple extends Fruit(cost = 60L)
case object Orange extends Fruit(cost = 25L)

object CheckoutSystem {

  def checkout(items: List[Fruit]): Long = {
    val (apples, oranges) = items.partition(_ == Apple)
    (twoForOne(apples) ++ threeForTwo(oranges)).map(_.cost).sum
  }

  private def twoForOne(apples: List[Fruit]): List[Fruit] = List.fill(calculateTotalSize(apples, 2, 1))(Apple)

  private def threeForTwo(oranges: List[Fruit]): List[Fruit] = List.fill(calculateTotalSize(oranges, 3, 2))(Orange)

  private def calculateTotalSize(xs: List[Fruit], buy: Int, free: Int): Int = ((s: Int) => (s % buy) + ((s / buy) * free)) (xs.size)
}

package object convertors {
  implicit class CurrencyConvertor(cost: Long) {
    def toPounds = "£" + (cost / 100.0)
  }
}
