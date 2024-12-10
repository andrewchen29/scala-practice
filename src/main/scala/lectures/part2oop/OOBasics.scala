package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Andrew", 22)
  println(person.x)

  person.greeting("Jay")
  person.greeting()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(imposter))

  val counter = new Counter()
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).dec(5).print
  
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + 5)

  // method
  def greeting(name: String = "Jay"): Unit = println(s"${this.name} said: Hi, $name")

  // overloading
  def greeting(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("Ashton")


}

// class parameters are NOT FIELDS


// Exercise
class Writer(firstname: String, surname: String, val yob: Int) {
  def fullname(): String = firstname + " " + surname
}

class Novel(name: String, yor: Int, author: Writer) {
  def authorAge(): Int = yor - author.yob
  def isWrittenBy(author: Writer): Boolean = (author.fullname() == this.author.fullname() && author.yob == this.author.yob)
  def copy(nyor: Int): Novel = new Novel(this.name, nyor, this.author)
}

class Counter(val cnt: Int = 0) {
  def print = println(cnt)
  def inc: Counter = {
    println("incrementing")
    new Counter(cnt + 1)
  }
  def dec: Counter = {
    println("decrementing")
    new Counter(cnt - 1)
  }
  def inc(amt: Int): Counter =
    if (amt <= 0) this
    else inc.inc(amt - 1)
  def dec(amt: Int): Counter =
    if (amt <= 0) this
    else dec.dec(amt - 1)
}
