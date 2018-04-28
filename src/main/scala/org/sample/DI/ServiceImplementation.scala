package org.sample.DI

trait ServiceImplementation {
  private val delay = 5000
  var stuff = "Hello from production!"
  def doStuff(): String = {Thread.sleep(delay); stuff}

  def doRealHeavyStuff(): Unit = {
    println("Doing heavy stuff!")
    throw new NotImplementedError()
  }
}
