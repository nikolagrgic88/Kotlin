fun interface Sorting<T> {
    fun sort(x: T, y: T): Boolean
}

fun <T> sortArray(arr: Array<T>, comparator: Sorting<T>) {
    var sorted = true
    while (sorted) {
        sorted = false
        for (i in 0..<(arr.size - 1)) {
            if (comparator.sort(arr[i], arr[i + 1])) {
                val tempPos = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = tempPos
                sorted = true
            }
        }
    }
}

fun main() {
    val numbersArray = arrayOf(1, 10, 34, 23, 34, 56, 45, 78, 76, 90, 88, 2, 14, 16, 19, 4, 5, 8)
    val names = arrayOf("Peter", "Nick", "Michelle")
    sortArray(numbersArray) { x, y -> x > y }
    sortArray(names) { x, y -> x.length > y.length }


}
