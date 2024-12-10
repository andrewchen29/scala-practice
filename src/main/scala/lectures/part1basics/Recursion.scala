package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n : BigInt): BigInt = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I First need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }

  println(factorial(10))
  // println(factorial(20000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  println(anotherFactorial(20000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  // 1. Concatenate a string n times
  @tailrec
  def concatStr(str: String, n: Int, accstr: String): String =
    if (n <= 1) accstr
    else concatStr(str, n-1, accstr + str)

  println(concatStr("Hello", 500, ""))

  // 2. IsPrime function tail recursive


  def isPrime(n: BigInt): Boolean = {
    @tailrec
    def isPrimeHelper(accn: BigInt): Boolean =
      if (accn <= 1) true
      else if (n % accn == 0) false
      else isPrimeHelper(accn-1)
    isPrimeHelper(n/2)
  }

  println(isPrime(2003))
  println(isPrime(629))

  // 3. Fibonacci function, tail recursive

  def fib(n: Int): BigInt = {
    @tailrec
    def fibHelper(i: Int, accu0: BigInt, accu1: BigInt): BigInt = {
      if (i == n) accu1
      else fibHelper(i+1, accu1, accu0 + accu1)
    }
    fibHelper(1, 1, 1)
  }

  println(fib(8))


}
