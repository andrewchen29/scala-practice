package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)
  println(2 + 3*4)

  println(1 == x)

  println(!(1 == x))
  // ! && || logical AND OR

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= .... side effects

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(if(aCondition) 5 else 3) // -> 5
  println(1 + 3) // -> 4

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN

  // EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning (above example)

  // Code blocks
  val aCodeBlock = {
    val y =2
    val z = y+1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world"
  // 2.

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

  






}
