package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 22) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    // exercise
    def +(title: String): Person = new Person(name + s" ($title)", favoriteMovie, age)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(sth: String): String = s"$name learns $sth"
    def learnsScala: String = this learns "Scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }


  val mary = new Person("Mary", "500 days of Summer")
  println(mary.likes("500 days of Summer"))
  println(mary likes "500 days of Summer") // equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(tom + mary)
  println(tom.+(mary))

  println(1+3)
  println(1.+(3)) // press ctrl + space to see all the available operators

  // ALL OPERATORS ARE METHODS.

  // prefix notation
  val x = -1  // equivalent to 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with + - ~ !
  println(y)

  println(tom.unary_!)
  println(!tom)

  // postfix notation
  println(mary isAlive)
  println(mary.isAlive)

  // apply
  println(mary.apply())
  println(mary())

  // Exercise
  println((mary + "the Rockstar")())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(199))

}
