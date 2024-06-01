class Person(var name: String, var age: Int, var yearBorn: Int) {}

fun interface FieldCheck {
    fun isEqualTo(p1: Person, p2: Person): Boolean
}

fun checkPerson(p1: Person, p2: Person, obj: FieldCheck): Boolean {
    return obj.isEqualTo(p1, p2)
}

fun main() {
    val p1 = Person("Nikola", 35, 1988)
    val p2 = Person("Alex", 38, 1985)
    val p3 = Person("Alex", 38, 1985)

    val nameCheck: FieldCheck = FieldCheck { n1, n2 -> n1.name == n2.name }
    val ageCheck: FieldCheck = FieldCheck { a1, a2 -> a1.age == a2.age }
    val yearBornCheck: FieldCheck = FieldCheck { y1, y2 -> y1.yearBorn == y2.yearBorn }

    println(checkPerson(p1, p2, nameCheck))
    println(checkPerson(p1, p2, ageCheck))
    println(checkPerson(p3, p2, yearBornCheck))
}