package sunit

object TestTemplate {

  def testBeforeRunAfterOrder(): Unit = {
    var order = ""
    new TestCase(() => order += " run ")
     .before(order += "before")
      .after(order += "after")
      .run()
    Assert.assertEquals(order,"before run after")
  }

  def testExceptionInBeforeMethodIsNotCountedAsFailure(): Unit = {
    val result = new TestCase(() => {})
      .before(throw new RuntimeException)
      .run()
    Assert.assertEquals(result, TestResult(0, 0))
  }

  def testExceptionInAfterMethodIsNotCountedAsFailure(): Unit = {
    val result = new TestCase(() => {})
      .after(throw new RuntimeException)
      .run()
    Assert.assertEquals(result, TestResult(1, 0))
  }

}
