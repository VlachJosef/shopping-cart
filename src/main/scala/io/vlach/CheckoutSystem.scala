package io.vlach

abstract class Fruit(val cost: Long)
case object Apple extends Fruit(cost = 60L)
case object Orange extends Fruit(cost = 25L)

object CheckoutSystem {
  def checkout(items: List[Fruit]): Long = {
    val (applesUntyped, orangesUntyped) = items.partition {
      case Apple => true
      case Orange => false
    }
    val apples = applesUntyped.collect { case Apple => Apple }
    val oranges = orangesUntyped.collect { case Orange => Orange }

    val applesToCheckout = twoForOne(apples)
    val orangesToCheckout = threeForTwo(oranges)

    (applesToCheckout ++ orangesToCheckout).foldRight(0L)((fruit, acc) => fruit.cost + acc)
  }

  private def twoForOne(apples: List[Apple.type]): List[Apple.type] = {
    val totalSize = calculateTotalSize(apples, 2, 1)
    List.fill(totalSize)(Apple)
  }

  private def threeForTwo(oranges: List[Orange.type]): List[Orange.type] = {
    val totalSize = calculateTotalSize(oranges, 3, 2)
    List.fill(totalSize)(Orange)
  }

  private def calculateTotalSize(xs: List[Fruit], buy: Int, free: Int): Int = {
    val size = xs.size
    (size % buy) + ((size / buy) * free)
  }
}

package object convertors {
  implicit class CurrencyConvertor(cost: Long) {
    def toPounds = "£" + (cost / 100.0)
  }
}
