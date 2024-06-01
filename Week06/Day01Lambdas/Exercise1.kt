fun <T> performOperation(fn: (Int, Int) -> T, x: Int, y: Int): T {
    return fn(x, y)
}

fun main() {
    val add: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val sub: (Int, Int) -> Int = { x: Int, y: Int -> x - y }
    val mul: (Int, Int) -> Int = { x: Int, y: Int -> x * y }
    val div: (Int, Int) -> Double= { x: Int, y: Int -> x / y.toDouble() }
    println(performOperation(add, 1, 2))
    println(performOperation(sub, 1, 2))
    println(performOperation(mul, 2, 2))
    println(performOperation(div, 1, 2))

}
