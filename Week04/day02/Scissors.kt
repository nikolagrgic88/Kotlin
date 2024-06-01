import java.io.File

fun main() {

    val file = File("file.txt")
    val reader = file.bufferedReader().lines()
    val words = ArrayList<ArrayList<String>>()

    for (l in reader) {
        val spl = l.split(" ")
        val wordList = ArrayList(spl)
        words.add(wordList)

    }
    words.map { it -> println(it) }
    //extracting column from the array
    extractColumn(2, words)
}


fun extractColumn(column: Int, list: ArrayList<ArrayList<String>>) {
    for (r in list) {
        println(r[column])
    }
}