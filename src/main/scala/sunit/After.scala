package sunit

import scala.util.Try

class After(after: => Any, test: Test) extends Test {

  override def run(): TestResult = {
    val testResult = test.run()
    if (!testResult.beforeFailed) {
      val _ = Try(after)
    }
    testResult
  }
}
