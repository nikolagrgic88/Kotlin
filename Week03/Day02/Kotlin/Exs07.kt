import java.io.File

fun main() {
    var file = File("Nikola.txt")
    var writer = file.printWriter()
    writer.println("Hello World!")
    writer.flush()
}