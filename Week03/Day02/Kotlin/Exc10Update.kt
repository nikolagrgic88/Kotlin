import java.io.File
import kotlin.random.Random

class Employee(
    var fistName: String,
    var lastName: String,
    var id: Int,
    var age: Int,
    var occupation: String
)

val employees = ArrayList<Employee>()
var file = File("")

fun printEml() {
    println("Name  LastName ID  Age  Occupation")
    for (emp in employees) {
        println("${emp.fistName} ${emp.lastName} ${emp.id} ${emp.age} ${emp.occupation}")
    }
}

fun readingCsv(csvFile: File) {
    //val employees = ArrayList<Employee>()

    for (line in csvFile.bufferedReader().lines().skip(1)) {
        val spl = line.split(",")
        val name = spl[0]
        val lastName = spl[1]
        val eId = spl[2].toInt()
        val employeeAge = spl[3].toInt()
        val occupation = spl[4]
        employees.add(Employee(name, lastName, eId, employeeAge, occupation))
    }
    printEml()

}

fun search(line: List<String>) {
    val params = line[2]

    when (params) {
        "ID" -> {
            println("${line[0]} BY ${line[2]}: ")
            for (value in employees) {
                if (value.id == line[3].toInt()) {
                    println("${value.fistName} ${value.lastName} ${value.id} ${value.age} ${value.occupation}")
                }
            }
        }

        "FIRST" -> {

            println("${line[0]} BY ${line[2]}: ")
            for (value in employees) {
                if (value.fistName == line[3]) {
                    println("${value.fistName} ${value.lastName} ${value.id} ${value.age} ${value.occupation}")
                }
            }
        }

        "LAST" -> {
            println("${line[0]} BY ${line[2]}: ")
            for (value in employees) {
                if (value.lastName == line[3]) {
                    println("${value.fistName} ${value.lastName} ${value.id} ${value.age} ${value.occupation}")
                }
            }
        }

        else -> println("error")
    }

}

fun printingToCsv(file: File) {
    val writer = file.printWriter()
    for (employee in employees) {
        writer.println("${employee.fistName},${employee.lastName},${employee.id},${employee.age},${employee.occupation}")
        writer.flush()
    }
}

fun loading(line: String) {
    val splt = line.split(" ")


    when (val command = splt[0]) {

        "LOAD" -> {
            file = File(splt[1])
            if (file.exists()) {
                readingCsv(file)
            } else {
                println("File not found")
            }
        }

        "SEARCH" -> {
            search(splt)
        }

        "NEW" -> {
            val name = splt[2]
            val lastName = splt[3]
            val age = splt[4].toInt()
            val occupation = splt[5]
//            adding employee to an array
            employees.add(Employee(name, lastName, Random.nextInt(1, 1001), age, occupation))
            printEml()
        }

        "SAVE" -> {
//            checking if fileSave is null
            val fileSave = splt.getOrNull(1)?.let { File(it) }//code suggested by Kotlin

            if (file == fileSave || fileSave == null) {
//                if saved is called before LOAD
                if (file != File("")) {
//                calling helper function write in existing file
                    printingToCsv(file)
                } else {
                    println("You didn't load a file, or specified a new one!!!")
                }
            } else if (file != fileSave) {
//                if it's a new file
                printingToCsv(File(splt[1]))
            } else {
                println("You didn't load a file, or specified a new one!!!")
            }
        }

        else -> print("ERROR")
    }
}

fun main() {
    var line = readlnOrNull()
    while (line != null) {
        if (line == "EXIT") break
        loading(line)
        line = readlnOrNull()
    }

}
