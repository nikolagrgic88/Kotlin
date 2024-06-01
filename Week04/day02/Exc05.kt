fun main() {
    val a = intArrayOf(1, 2, 3, 4, 5, 6)
    val b = intArrayOf(5, 6, 7, 8, 9, 10)

    println("Before A: ${a.joinToString(", ")} \nB:${b.joinToString(", ")} ")
    swapArray(a, b)
    println("After A: ${a.joinToString(", ")} \nB:${b.joinToString(", ")} ")
}


fun swapArray(array1: IntArray, array2: IntArray) {

    for (n in array1.indices) {
        val temp = array1[n]
        array1[n] = array2[n]
        array2[n] = temp

    }
}