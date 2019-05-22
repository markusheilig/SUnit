package sunit

object TestTestResult {

  def testErrorIncrementErrorCounter(): Unit = {
    val testResult = TestResult(1, 0)
    Assert.assertEquals(testResult.error(), TestResult(1, 1))
  }

}
