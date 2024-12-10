package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  sealed class Animal {
    def eat = println("nomnom")
    val creatureType = "wild"
  }

  // Cat is Animal's subclass while Animal is Cat's superclass
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch, crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
//    override val creatureType = "domestic"
  }

  val dog = new Dog("domestic")

  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("unknown")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1. use final on the member
  // 2. use final on the entire class
  // 3. seal the class = extend class in THIS FILE, prevent extension in other files


}


