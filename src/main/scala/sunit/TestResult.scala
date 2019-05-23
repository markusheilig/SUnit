package sunit

case class TestResult(testCount: Int, errorCount: Int, beforeFailed: Boolean = false) {

  def combine(other: TestResult): TestResult = {
    copy(testCount = testCount + other.testCount, errorCount = errorCount + other.errorCount)
  }

  def error(): TestResult = {
    copy(errorCount = errorCount + 1)
  }

}
