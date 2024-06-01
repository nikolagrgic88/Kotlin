import java.io.File

fun main() {
    var file = File("exc01.txt")

    for(line in file.bufferedReader().lines()){
        println(line)
    }
}