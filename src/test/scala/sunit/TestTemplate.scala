package sunit

object TestTemplate {

  def testBeforeRunAfterOrder(): Unit = {
    var order = ""
    new TestCase(() => order += " run ")
     .before(order += "before")
      .after(order += "after")
      .run()
    Assert.assertEquals(order,"before run after2")
  }


}
