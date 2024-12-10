package lectures.part2oop

object Exceptions extends App {

  val x: String = null
//  println(x.length)
  // this ^^ will crash with a NPE

  // 1. throwing exceptions
//  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might fail/throw
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

//  throw exception

  // 1. Crash your program with an OutOfMemoryError OOM
//  val array: Array[Int] = Array.ofDim[Int](Int.MaxValue)

  // 2. Crash with SO

  def factorial(n: BigInt): BigInt = {
    if (n <= 0) 1
    else n * factorial(n-1)
  }

  println(factorial(100))

  // 3. PocketCalculator
  //    - add (x, y)
  //    - subtract(x, y)
  //    - multiply(x, y)
  //    - divide(x, y)

  // Throw
  //    - OverflowException if add(x, y) exceeds Int.MAX_VALUE
  //    - UnderflowException if sub(x, y) exceeds Int.MIN_VALUE
  //    - MathCalculationException for division by 0

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
    def sub(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def mul(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def div(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

//  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.div(2,0))

}
