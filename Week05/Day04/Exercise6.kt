interface Sorting {
    fun sort(numbers: Array<Int>)
}

class SortingNumbers() : Sorting {
    override fun sort(numbers: Array<Int>){
        var sorted = true
        while (sorted) {
            sorted = false
            for (i in 0..<(numbers.size - 1)) {
                if (numbers[i] > numbers[i + 1]) {
                    val tempPos = numbers[i]
                    numbers[i] = numbers[i + 1]
                    numbers[i + 1] = tempPos
                    sorted = true
                }
            }
        }
        for(n in numbers){
            print("${n}, ")
        }
    }
}

fun main() {
    val numbers = arrayOf(1, 10, 34, 23, 34, 56, 45, 78, 76, 90, 88, 2, 14, 16, 19, 4, 5, 8)

    val firstBatch = SortingNumbers()
    firstBatch.sort(numbers)

}


