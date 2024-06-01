import java.security.Principal

var numbers = ArrayList<Int>()

fun main() {
    var number = readlnOrNull()
    while (number != null && number.length <= 10) {
        numbers.add(number.toInt())
        number = readlnOrNull()
    }
    sort(numbers)

}

fun sort(numbers: ArrayList<Int>) {
    var sorting = true
    while (sorting) {
        sorting = false
        for (i in 0..<numbers.size - 1) {
            if (numbers[i] < numbers[i + 1]) {
                val tempNum = numbers[i + 1]
                numbers[i + 1] = numbers[i]
                numbers[i] = tempNum
                sorting = true
            }
        }
    }
    for (n in numbers) {
        println("Sorted Lines: ")
        println(n)
    }

}