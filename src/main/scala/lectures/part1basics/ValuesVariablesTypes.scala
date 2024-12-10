package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x = 42
  println(x)

  // VALS ARE IMMUTABLE

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613 // two bytes
  val aLong: Long = 34524523452345L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects

}
