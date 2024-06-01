fun main() {
    // Exercise 6
    println("What is your string?")
    val savedString = readln()

    var counter = 0

    for (i in savedString) {
        if (i != ' ')
            counter++
    }
    println("Your string has $counter characters ")
}





