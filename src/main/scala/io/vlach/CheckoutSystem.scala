package io.vlach

abstract class Fruit(val cost: Long)
case object Apple extends Fruit(cost = 60L)
case object Orange extends Fruit(cost = 25L)

object CheckoutSystem {
  def checkout(items: List[Fruit]): Long = {
    items.foldRight(0L)((fruit, acc) => fruit.cost + acc)
  }
}

package object convertors {
  implicit class CurrencyConvertor(cost: Long) {
    def toPounds = "£" + (cost / 100.0)
  }
}
