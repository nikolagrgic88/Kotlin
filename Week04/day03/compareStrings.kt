fun main() {
    val stringOne = "Nikola"
    val stringTwo = "Nikola"
    val stringThree = "Peter"
    val string4 = "what a beautiful day"
    val string5 = "what a beautiful day"

    println(compareStrings(stringOne, stringTwo))
    println(compareStrings(stringOne, stringThree))
    println(compareStrings(string4, string5))
}

fun compareStrings(one: String, two: String): Boolean {
    //or one.length == two.length
    if (one.length > two.length || two.length > one.length) {
        return false
    } else {
        while (true) {
            for (i in one.indices) {
                if (one[i] != two[i]) {
                    return false
                }
            }
            return true
        }
    }
}