package sunit

class TestCase(method: () => Any) extends Test {

  def run(): TestResult = {
    val testResult = TestResult(1, 0)
    try {
      method.apply()
      testResult
    } catch {
      case _: Throwable =>
        testResult.error()
    }
  }

}
