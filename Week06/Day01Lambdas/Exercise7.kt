class SumNums() {
    var sum = 0
    fun sumOfNums(list: List<Int>):Int {
        list.forEach { sum += it }
        return sum
    }
}


fun main() {
    val listInt: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val sumNumbers1 = listInt.sum()
    println(sumNumbers1)

    var result2 = 0
    listInt.forEach { result2 += it }
    println(result2)

    val list = SumNums()
    println(list.sumOfNums(listInt))
}