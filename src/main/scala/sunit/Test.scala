package sunit

trait Test {

  def after(action: => Any): Test = new After(action, this)

  def before(action: => Any): Test = new Before(action, this)

  def run(): TestResult

}
