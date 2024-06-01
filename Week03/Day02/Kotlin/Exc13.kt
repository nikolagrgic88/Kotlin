import java.io.File

fun main() {
    println("Please write some names")
    var reader = readlnOrNull()
    val names = HashMap<Int, String>()

    var index = 0
    while (reader != null) {
        if (reader == "exit") break
        names[index] = reader.toString()
        reader = readlnOrNull()
        index++
    }
//    checking if map contains same values, if it repeats more than once, it groups it and returns that value
    val sameNames = names.values.groupBy { it }.filter { it.value.size > 1 }.keys
//    ORIGINAL SOLUTION  - changed
//    val sameNames = names.values.groupBy { it }.
//    val dupNames = sameNames.filter {  it.value.size > 1  }.keys

    for (name in sameNames) {
        println(name)
    }
}