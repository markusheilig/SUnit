package sunit

class Before(before: => Any, test: Test) extends Test {

  override def run(): TestResult = {
    before
    test.run()
  }
}
