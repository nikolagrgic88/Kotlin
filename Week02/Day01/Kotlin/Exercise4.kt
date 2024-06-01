fun main() {
    val numbers = intArrayOf(50, 200, 80, 750, 958, 657, 2, 47, 68, 1250)

    var maxNum = Int.MIN_VALUE
    var minNum = Int.MAX_VALUE

    for (number in numbers) {
        if (number > maxNum) {
            maxNum = number
        }
        if (number < minNum) {
            minNum = number
        }
    }
    println("Max number is $maxNum and min number is $minNum")

}