package sunit

class TestSuite(private val tests: Test*) extends Test {

  def run(): TestResult = {
    tests
      .map(_.run())
      .foldLeft(TestResult(0, 0)) { case (acc, result) => acc.combine(result) }
  }

}
