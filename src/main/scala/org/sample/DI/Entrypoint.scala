package org.sample.DI

object Entrypoint extends App {
  val worker = new Worker(ProductionService)
  println(worker.work())
}
