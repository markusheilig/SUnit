package sunit

class TestSuite extends Test {

  private val tests = scala.collection.mutable.ListBuffer.empty[Test]

  def run(): TestResult = {
    tests
      .map(_.run())
      .foldLeft(TestResult(0, 0)) { case (acc, result) => acc.combine(result) }
  }

  def addTest(test: Test) :Unit = {
    tests += test
  }

}
