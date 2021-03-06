package sunit

import Assert.assertEquals

object Main {

  def main(args: Array[String]): Unit = {


    assertEquals(new TestCase(TestTestCase.testDoNothing).run(), TestResult(1, 0))
    assertEquals(new TestCase(TestAssert.testAssertDoesNotThrowIfActualEqualsExpected).run(), TestResult(1, 0))
    assertEquals(new TestCase(TestAssert.testAssertThrowsIfActualDoesNotEqualExpected).run(), TestResult(1, 1))
    assertEquals(new TestCase(TestTestResult.testErrorIncrementErrorCounter).run(), TestResult(1, 0))

    val testSuite: TestSuite = new TestSuite(
      new TestCase(TestTestCase.testDoNothing),
      new TestCase(TestAssert.testAssertDoesNotThrowIfActualEqualsExpected),
      new TestCase(TestAssert.testAssertThrowsIfActualDoesNotEqualExpected)
    )
    assertEquals(testSuite.run(), TestResult(3, 1))

    val templateTest = new TestCase(TestTemplate.testBeforeRunAfterOrder)
    assertEquals(templateTest.run(), TestResult(1, 0))

    val exceptionInBeforeTest = new TestCase(TestTemplate.testExceptionInBeforeMethodIsNotCountedAsFailure)
    assertEquals(exceptionInBeforeTest.run(), TestResult(1, 0))

    val exceptionInAfterTest = new TestCase(TestTemplate.testExceptionInAfterMethodIsNotCountedAsFailure)
    assertEquals(exceptionInAfterTest.run(), TestResult(1, 0))

    val chainBeforeAndAfterTest = new TestCase(TestTemplate.testChainMultipleAfterAndBeforeMethods)
    assertEquals(chainBeforeAndAfterTest.run(), TestResult(1, 0))


    val afterIsNotCalledWhenBeforeThrowsAnExceptionTest = new TestCase(TestTemplate.testAfterIsNotCalledWhenBeforeThrowsAnException)
    assertEquals(afterIsNotCalledWhenBeforeThrowsAnExceptionTest.run(), TestResult(1, 0))
  }


}
