fun main() {
    countOccurrence("My name is Nikola", 'a')
}

fun countOccurrence(givenString: String, findChar: Char) {
    var count = 0
    for (letter in givenString) {
        if (findChar == letter) {
            count++
        }
    }
    println("Occurrence: $count")

}