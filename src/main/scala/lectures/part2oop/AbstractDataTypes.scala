package lectures.part2oop

object AbstractDataTypes extends App {
  // abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch, crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdAnimal(name: String)
  class Crocodile extends Animal with Carnivore with ColdAnimal("Snake") {
    val creatureType = "croc"
    def eat = println("nomnom")
    def eat(animal: Animal) = println(s"I am croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1. multiple traits may be inherited by the same class
  // 2. traits = behavior, abstract class = thing


}
