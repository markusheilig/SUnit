package sunit

import scala.util.{Failure, Success, Try}

class TestCase(method: () => Any) extends Test {

  override def run(): TestResult = {
    val testResult = TestResult(1, 0)
    Try(method()) match {
      case Success(_) =>
        testResult
      case Failure(err) =>
        println(err.getMessage)
        testResult.error()
    }
  }

}
