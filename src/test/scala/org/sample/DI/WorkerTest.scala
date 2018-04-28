package org.sample.DI

import org.scalatest.FlatSpec

class WorkerTest extends FlatSpec {

  class FakeService extends ServiceImplementation {
    val fakeStuff = "test"
    override def doStuff(): String = fakeStuff
  }

  "A Workder" should "use the stuff that 'service' provides" in {
    val fakeService = new FakeService()
    val worker = new Worker(fakeService)
    assert(worker.work() == fakeService.fakeStuff)
  }

}
