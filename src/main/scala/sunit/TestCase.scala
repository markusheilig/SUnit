package sunit

class TestCase(method: () => Any) extends Test {

  override def run(): TestResult = {
    val testResult = TestResult(1, 0)
    try {
      method()
      testResult
    } catch {
      case t: Throwable =>
        println(t.getMessage)
        testResult.error()
    }
  }

}
