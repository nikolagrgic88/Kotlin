fun main() {
    print("Enter binary: ")
    var binary = readlnOrNull()
    var value = 0
    var j = 1

    while (binary != null) {
        var isBinary = true

        val spl = binary.split("").drop(1).dropLast(1).reversed()

        for (n in spl) {
            if (n != "0" && n != "1") {
                println("Not binary!")
                isBinary = false
                break

            }
            val num = n.toInt()
            value += num * j
            j *= 2
        }
        if (isBinary) {
            println("$value in decimal")
        }

        binary = readlnOrNull()
        value = 0
        j = 1
    }
}