import java.io.File

class Employee(var fistName: String, var lastName: String, var id: Int, age: Int, var occupation: String) {}

fun readingCsv(csvFile: File): ArrayList<Employee> {
    val employees = ArrayList<Employee>()

    for (line in csvFile.bufferedReader().lines().skip(1)) {
        val spl = line.split(",")
        val name = spl[0]
        val lastName = spl[1]
        val eId = spl[2].toInt()
        val employeeAge = spl[3].toInt()
        val occupation = spl[4]

        val newEmployee = Employee(name, lastName, eId, employeeAge, occupation)
        employees.add(newEmployee)
    }
    return employees
}

fun loading(line: String) {
    val splt = line.split(" ")

    when (val command = splt[0]) {

        "LOAD" -> {
            val listOfEmp = readingCsv(File(splt[1]))
            for (i in listOfEmp) println(i.fistName)
        }

        else -> print("ERROR")
    }
}

fun main() {
    var line = readlnOrNull()
    while (line != null) {
        loading(line)
        line = readlnOrNull()
    }
}
