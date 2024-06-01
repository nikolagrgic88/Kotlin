fun main() {
    val numbers = arrayOf(1, 5, 10, 25, 29, 38, 39, 58, 67, 77, 81, 95)
    //                    0  1   2   3   4   5   6   7   8   9  10   11
    testing(numbers)
}

fun binarySearch(numbers: Array<Int>, number: Int?): Int {

    var lowIndex = 0
    var highIndex = numbers.size - 1

    while (lowIndex <= highIndex) {
        val midIndex = (lowIndex + highIndex) / 2
        if (numbers[midIndex] == number) {
            return numbers[midIndex]
        } else if (numbers[midIndex] < number!!) {
            lowIndex = midIndex + 1
        } else {
            highIndex = midIndex - 1
        }
    }
    return -1
}
fun testing(numbers:Array<Int>){
    var number = readlnOrNull()?.toInt()
    while(number!=null){
        val results = binarySearch(numbers, number)

        if (results == number) {
            println("Your number was found at position: ${numbers.indexOf(number)}")
        } else {
            println("Your number is not in the list")
        }
        number = readlnOrNull()?.toInt()
    }
}