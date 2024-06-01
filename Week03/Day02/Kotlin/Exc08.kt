import java.io.File

fun main() {
    //reading from file
    var readfile = File("example.txt")
    //writing to file
    var writeFile = File("Nikola.txt")

    var writer = writeFile.printWriter()


    for (lines in readfile.bufferedReader().lines()) {
        writer.println(lines)
    }
    writer.flush()
}