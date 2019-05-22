package sunit

import Assert.assertEquals

object Main {

  def main(args: Array[String]): Unit = {

    assertEquals(new TestCase(TestTestCase.testDoNothing).run(), TestResult(1, 0))
    assertEquals(new TestCase(TestAssert.testAssertDoesNotThrowIfActualEqualsExpected).run(), TestResult(1, 0))
    assertEquals(new TestCase(TestAssert.testAssertThrowsIfActualDoesNotEqualExpected).run(), TestResult(1, 1))
    assertEquals(new TestCase(TestTestResult.testErrorIncrementErrorCounter).run(), TestResult(1, 0))

    val testSuite: TestSuite = new TestSuite()
    testSuite.addTest(new TestCase(TestTestCase.testDoNothing))
    testSuite.addTest(new TestCase(TestAssert.testAssertDoesNotThrowIfActualEqualsExpected))
    testSuite.addTest(new TestCase(TestAssert.testAssertThrowsIfActualDoesNotEqualExpected))
    assertEquals(testSuite.run(), TestResult(3, 1))

    val templateTest = new TestCase(TestTemplate.testBeforeRunAfterOrder)
    assertEquals(templateTest.run(), TestResult(1,0))
  }


}
