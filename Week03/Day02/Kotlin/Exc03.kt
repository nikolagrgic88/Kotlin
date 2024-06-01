import java.io.File

class Employee(var fistName: String, var lastName: String, var id: Int, age: Int, var occupation: String) {}


fun main() {
    var employees = Array<Employee>(4) { Employee("", "", 0, 0, "") }
    var file = File("example1.csv")
    var index = 0
    for (line in file.bufferedReader().lines().skip(1)) {

        var split = line.split(",")

        var firstN = split.get(0)
        var lastN = split.get(1)
        var eId = split.get(2).toInt()
        var empAge = split.get(3).toInt()
        var empOccupation = split.get(4)

        var newEmployee = Employee(firstN, lastN, eId, empAge, empOccupation)

        employees[index] = newEmployee
        index++

    }

    for (i in employees) {
        println(i.fistName)
    }

}
