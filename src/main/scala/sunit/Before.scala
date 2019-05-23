package sunit

import scala.util.{Failure, Success, Try}

class Before(before: => Any, test: Test) extends Test {

  override def run(): TestResult = {
    Try(before) match {
      case Success(_) =>
        test.run()
      case Failure(_) =>
        TestResult(0, 0, beforeFailed = true)
    }
  }

}
