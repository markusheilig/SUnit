package sunit

object TestAssert {

  def testAssertDoesNotThrowIfActualEqualsExpected(): Unit = {
    Assert.assertEquals(1, 1)
  }

  def testAssertThrowsIfActualDoesNotEqualExpected(): Unit = {
    Assert.assertEquals(1, 2)
  }
}
