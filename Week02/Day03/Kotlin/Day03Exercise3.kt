fun main() {
    calcSum(intArrayOf(2, 5, 8, 1, 5, 9))


}

fun calcSum(numbers: IntArray) {
//    Exercise 3
    var result = 0
    for (number in numbers) {
        result = number + result
    }
    println("The sum is $result ")
}