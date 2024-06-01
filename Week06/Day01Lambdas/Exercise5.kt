class Person(var name: String, var age: Int, var yearBorn: Int){
}


interface FieldCheck {
    fun isEqualTo(p1: Person, p2: Person): Boolean
}

class NameCheck() : FieldCheck {
    override fun isEqualTo(p1: Person, p2: Person): Boolean {
        return p1.name == p2.name
    }
}

class AgeCheck() : FieldCheck {
    override fun isEqualTo(p1: Person, p2: Person): Boolean {
        return p1.age == p2.age
    }
}

class YearBornCheck() : FieldCheck {
    override fun isEqualTo(p1: Person, p2: Person): Boolean {
        return p1.yearBorn == p2.yearBorn
    }
}

fun checkPerson(p1: Person, p2: Person, obj: FieldCheck):Boolean {
return obj.isEqualTo(p1,p2)
}

fun main() {
    var p1 = Person("Nikola", 35, 1988)
    var p2 = Person("Alex", 38, 1985)
    var p3 = Person("Alex", 38, 1985)


    println(checkPerson(p1,p2,NameCheck()))
    println(checkPerson(p1,p2,AgeCheck()))
    println(checkPerson(p3,p2,YearBornCheck()))
}