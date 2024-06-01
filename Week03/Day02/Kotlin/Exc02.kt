import java.io.File

fun main() {
    var file = File("exc02.txt")

    var index = 1
    for (line in file.bufferedReader().lines()) {
        println("Line $index: $line")
        index++
    }
}