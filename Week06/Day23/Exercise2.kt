fun generate(n: Int): Array<Int> {
    val numbers = Array(n * 4) { 0 }
    var v = 0
    for (x in 0..<n) {
        for (i in 0..3) {
            numbers[v] = i + x
            v++
        }
    }
    return numbers
}

fun generate2(n: Int): Array<Int> {
    val numbers = Array(n * 4) { 0 }
    for (x in 0..<n * 4) {
        numbers[x] = (x % 4) + (x / 4)
    }
    return numbers
}

fun main(args: Array<String>) {
    val sequence = generate(4)
    val sequence2 = generate2(4)
    sequence.forEach { print("${it}, ") }
    sequence2.forEach { print("${it}, ") }

}