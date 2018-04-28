package org.sample.DI

class Worker(service: ServiceImplementation) {
  def work(): String = service.doStuff()
}
