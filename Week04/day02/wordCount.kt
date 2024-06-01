import java.io.File
import kotlin.coroutines.coroutineContext

fun main() {
    val file = File("file.txt")

    val reader = file.bufferedReader().lines()
    var textSize = 0
    for (line in reader) {
        val spl = line.split(" ").size
        textSize += spl
    }
    println("Number of words: $textSize")
}