fun search(line: List<String>) {
    val params = line[2]

    when (params) {
        "ID" -> {

            println("Searching by ID: ${line[3]}")
        }

        "FIRST" -> {
            println("Searching by First Name: ${line[3]}")
        }

        "LAST" -> {
            println("Searching by Last Name: ${line[3]}")
        }

        else -> println("error")
    }

}

fun list(line: List<String>) {
    val params = line[2]

    when (params) {


        "FIRST" -> {
            println("List by First Name: ${line[3]}")
        }

        "LAST" -> {
            println("List by Last Name: ${line[3]}")
        }

        else -> println("ERROR")
    }

}

fun commands(line: String) {
    val splt = line.split(" ")
    when (val command = splt[0]) {

        "LOAD" -> {
            val params = splt[1]
            println("Command: $command, params: $params")
        }

        "SEARCH" -> {
            search(splt)
        }

        "LIST" -> {
            list(splt)
        }

        "NEW" -> {
            println("New employee: ${splt[2]} ${splt[3]} postion: ${splt[4]}")

        }

        else -> print("ERROR")
    }
}

fun main() {
    var line = readlnOrNull()
    while (line != null) {
        commands(line)
        line = readlnOrNull()
    }
}
