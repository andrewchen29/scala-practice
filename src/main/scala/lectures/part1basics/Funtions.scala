package lectures.part1basics

object Funtions extends App {

  def aFuntion(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFuntion("hello", 3))

  def aParameterFunction(): Int = 42

  def aParameterlessFunction: Int = 42

  println(aParameterFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }
  // recursive functions need to specific return type

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  // 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."

  def aGreetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

  println(aGreetingFunction("Andrew", 22))

  // 2. Factorial function 1 * 2 * 3...* n

  def aFactorialFunction(n: Int): Int = {
    if (n == 1) 1
    else n * aFactorialFunction(n - 1)
  }

  println(aFactorialFunction(5))

  /* 3. A Fibonacci function
        f(1) = 1
        f(2) = 2
        f(n) = f(n-1) + f(n-2) */

  def aFibonacciFunction(n: Int): Int = {
    if (n <= 1) 1
    else aFibonacciFunction(n - 1) + aFibonacciFunction(n - 2)
  }

  println(aFibonacciFunction(8))

  // 1, 1, 2, 3, 5, 8

  // 4. Tests if a number is prime

  def testPrime(n: Int): Boolean = {
    def checkMinusOne(a: Int): Boolean = {
      if (a <= 1) true
      else (n % a != 0) && checkMinusOne(a - 1)
    }
    checkMinusOne(n/2)
  }

  println(testPrime(37))
  println(testPrime(2003))
  println(testPrime(37*17))

}



