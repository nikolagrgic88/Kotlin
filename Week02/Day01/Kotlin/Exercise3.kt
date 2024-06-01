fun main() {
    print("What is your string? ")
    val responseString = readln()
    print("what character do you want to count? ")
    val responseChar = readln()

    //checking if character exists in the string
    if (responseChar in responseString) {
        var count = 0
        //counting occurrence of the character
        for (letter in responseString) {
            if (letter in responseChar) {
                count++
            }
        }
        if (count > 1) {
            println("\"$responseChar\" shows up $count times")
        } else {
            println("\"$responseChar\" shows up $count time")
        }
    } else {
        println("Sorry, we couldn't find your character")
    }
}