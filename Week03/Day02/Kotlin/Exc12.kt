import java.io.File

fun main() {
    println("Please write some names")
    var reader = readlnOrNull()
    val names = ArrayList<String>()

    while (reader != null) {
        if (reader == "exit") break
        names.add(reader.toString())
        reader = readlnOrNull()
    }

    val file = File("names.txt")
    val writer = file.printWriter()

    for (name in names) writer.println(name)
    writer.flush()

}