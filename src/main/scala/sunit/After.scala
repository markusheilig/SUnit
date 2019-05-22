package sunit

class After(after: => Any, test: Test) extends Test {

  override def run(): TestResult = {
    val testResult = test.run()
    after
    testResult
  }
}
