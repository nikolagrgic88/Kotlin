fun main() {
    println("Please write some names")
    var reader = readlnOrNull()
    var names = ArrayList<String>()

    while (reader != null) {
        if (reader == "exit") break
        names.add(reader.toString())
        reader = readlnOrNull()
    }
    for (name in names) {
        println(name)
    }
}