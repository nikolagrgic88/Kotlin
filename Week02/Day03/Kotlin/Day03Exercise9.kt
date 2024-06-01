fun main() {
    println("What is your string")
    val input = readln()

    var numbers = arrayOf("0123456789")
    var nums = 0
    var letters = 0
    for (i in input) {
        for (j in numbers) {
            if(i in j) {
                nums++
            } else if(i != ' ') {
                letters++
            }
        }
    }
    println("You have $letters letters and $nums")

}