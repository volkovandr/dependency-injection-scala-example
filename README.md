# Dependency Injection in Scala

Here is an example of how to do Dependency Injection in Scala.

# The problem

We have a Service and a Worker. The Worker uses the Service to do some work.
We would like to have a unit test for Worker. But the problem is that
the Service is so heavy and complex that we do not want to
instantiate it in the unit test. But Worker uses it and cannot be
initialized without the Service...

# Solution
Dependency Injection is a solution for this kind of problems.

The Worker should not try on instantiate the Service by itself.
Instead the external environment, that creates the Worker should
"give" an instance of the Service to the Worker.

In this way in production we will be able to use the real Service and in
testing a fake Service that is lightweight and is used only for testing if
the Worker does the right thing.

A classical implementation of this would be creation of a class that extends
the Service class and using it when testing the Worker. There is a small
difficulty here that is in Scala it is impossible to extend an Object.

A solution for this is to move the actual implementation of the Service into a
trait and let the productive Service object to extend the trait and also
the fake testing Service class extend the same trait.

# Implementation
There are:
- trait ServiceImplementation
- class Worker that takes an instance of ServiceImplementation as an argument
- object ProductionService that extends ServiceImplementation and does
something that makes it not possible to be used during testing
- test class WorkerTest that has an internal class FakeService extending
ServiceImplementation and overriding the heavy functions that a Worker would call.

# Usage

Assuming you already have `sbt` installed. Simply clone the repository and execute

```
sbt test
```
