package sunit


object Assert {

  class AssertError(message: String) extends RuntimeException(message)

  def assertEquals[T](actual: T, expected: T): Unit = {
    if (actual != expected) {
      val message =
        s"""
           |Actual value does not match expected value:
           |'$actual' != '$expected'
        """.stripMargin
      throw new AssertError(message)
    }
  }

}


