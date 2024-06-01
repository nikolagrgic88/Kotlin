fun main(args: Array<String>) {
    //converting element at position 0 to Int
    var size = args[0].toInt()
    drawTree(size)
}

fun drawTree(size: Int) {

    //checking if input is valid
    if (size == null || size <= 0 || size < 3) {
        println("The argument should be a positive number greater than 3.")
        return
    }

    for (i in 1..<size) {
        println(" ".repeat(size - i) + "*".repeat(2 * i - 1))
    }
    println(" ".repeat(size - 2) + "*".repeat(3))

}

