package sunit

class After(after: => Any, test: Test) extends Test {

  override def run(): TestResult = {
    val testResult = test.run()
    try {
      after
    } catch {
      // ignore
      case _: Throwable =>
    }
    testResult
  }
}
