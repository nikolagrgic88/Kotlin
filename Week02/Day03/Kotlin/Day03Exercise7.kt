fun main() {
    palindrome("racecar")
    palindrome("dog")
}

fun palindrome(paliString: String) {
    //char array to input reverse chars
    val reversedText = CharArray(paliString.length)


    var textSize = paliString.length - 1
    var x = 0
//reversing order of letters in the string
    for (i in paliString) {
        reversedText[textSize] = paliString[x]
        x++
        textSize--
    }
//converting char array to string
    val palindromeRev = String(reversedText)
    if (paliString in palindromeRev) {
        println("true")
    } else {
        println("false")
    }

}

