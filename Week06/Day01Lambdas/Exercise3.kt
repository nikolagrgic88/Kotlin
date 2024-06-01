class Person(val name: String, val age: Int) {}

fun getNames(personMap: (Person) -> String, people: List<Person>): List<String> {
    val newList = ArrayList<String>();
    for (p in people) {
        newList.add(personMap(p));
    }
    return newList
}

fun main() {
    val names: List<Person> =
        listOf(Person("Nikola", 25), Person("Natasha", 21), Person("Alexander", 5), Person("Alexis", 9))

    val findName: (Person) -> String = { p: Person -> p.name }

    getNames(findName, names).forEach { println(it) }

}

