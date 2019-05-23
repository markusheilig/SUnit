package sunit

class TestTestSuite extends {

  def testSuiteRunsManyTests(): Unit = {
    val testSuite: TestSuite = new TestSuite()
    val sampleTest = new SampleTest()

    //testSuite.add(sampleTest.)
  }

  class SampleTest() {
    def doesNothing(): Unit = {

    }

    def throws(): Unit = {

    }

    def assertionError(): Unit = {

    }
  }

}
