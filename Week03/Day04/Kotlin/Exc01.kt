fun main(args: Array<String>) {
    val numbers = arrayOf(1, 5, 10, 25, 29, 38, 39, 58, 67, 77, 81, 95)
    val number = 67
    val results = binarySearch(numbers, number)

    if (results == number) {
        println("Your number was found at position: ${numbers.indexOf(39)}")
    } else {
        println("Your number is not in the list ☹️")
    }
}

fun binarySearch(numbers: Array<Int>, number: Int): Int {

    var lowIndex = 0
    var highIndex = numbers.size - 1

    while (lowIndex <= highIndex) {
        val midIndex = (lowIndex + highIndex) / 2
        if (numbers[midIndex] == number) {
            return numbers[midIndex]
        } else if (numbers[midIndex] < number) {
            lowIndex = midIndex + 1
        } else {
            highIndex = midIndex - 1
        }
    }
    return -1
}