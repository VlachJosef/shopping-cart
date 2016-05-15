package io.vlach

import org.scalatest.{FlatSpec, Matchers}

class CheckoutSystemSuite extends FlatSpec with Matchers {

  "Checkout System" should "be able to handle checkout of empty List" in {
    val empty = CheckoutSystem.checkout(List.empty[Fruit])
    empty should be(0L)
  }

  it should "checkout List of one orange" in {
    val res = CheckoutSystem.checkout(List(Orange))
    res should be(25L)
  }

  it should "checkout List of one Apple" in {
    val res = CheckoutSystem.checkout(List(Apple))
    res should be(60L)
  }

  it should "checkout List of Fruits" in {
    val fruits = List(Apple, Apple, Orange, Apple)
    val res = CheckoutSystem.checkout(fruits)
    res should be(205L)
  }

  import convertors._

  it should "checkout List of Fruits and print result in pounds" in {
    val fruits = List(Apple, Apple, Orange, Apple)
    val res = CheckoutSystem.checkout(fruits).toPounds
    res should be("£2.05")
  }
}
