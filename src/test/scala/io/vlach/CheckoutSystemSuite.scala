package io.vlach

import org.scalatest.{FlatSpec, Matchers}

class CheckoutSystemSuite extends FlatSpec with Matchers {

  "Checkout System" should "be able to handle checkout of empty List" in {
    val empty = CheckoutSystem.checkout(List.empty[Fruit])
    empty should be(0L)
  }

  it should "checkout one orange" in {
    val res = CheckoutSystem.checkout(List(Orange))
    res should be(25L)
  }

  it should "checkout one apple" in {
    val res = CheckoutSystem.checkout(List(Apple))
    res should be(60L)
  }

  import convertors._

  it should "checkout 1 and 2 apples for the price of 1 apple" in {
    val apple1 = List(Apple)
    val apple2 = List(Apple, Apple)
    val apple1Res = CheckoutSystem.checkout(apple1).toPounds
    val apple2Res = CheckoutSystem.checkout(apple2).toPounds
    apple1Res should be(apple2Res)
    apple1Res should be("£0.6")
  }

  it should "checkout 3 and 4 apples for the price of 2 apples" in {
    val apple3 = List(Apple, Apple, Apple)
    val apple4 = List(Apple, Apple, Apple, Apple)
    val apple3Res = CheckoutSystem.checkout(apple3).toPounds
    val apple4Res = CheckoutSystem.checkout(apple4).toPounds
    apple3Res should be(apple4Res)
    apple3Res should be("£1.2")
  }

  it should "checkout 2 and 3 oranges for the price of 2 oranges" in {
    val oranges2 = List(Orange, Orange)
    val oranges3 = List(Orange, Orange, Orange)
    val oranges2Res = CheckoutSystem.checkout(oranges2).toPounds
    val oranges3Res = CheckoutSystem.checkout(oranges3).toPounds
    oranges2Res should be(oranges3Res)
    oranges2Res should be("£0.5")
  }

  it should "checkout 5 and 6 oranges for the price of 4 oranges" in {
    val oranges5 = List(Orange, Orange, Orange, Orange, Orange)
    val oranges6 = List(Orange, Orange, Orange, Orange, Orange, Orange)
    val oranges5Res = CheckoutSystem.checkout(oranges5).toPounds
    val oranges6Res = CheckoutSystem.checkout(oranges6).toPounds
    oranges5Res should be(oranges6Res)
    oranges5Res should be("£1.0")

  }

}
