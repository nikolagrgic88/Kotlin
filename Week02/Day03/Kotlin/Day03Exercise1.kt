fun main() {

    //Example 1
    val numbers = intArrayOf(50, 200, 80, 750, 958, 657, 2, 47, 68, 1250)
    //Storing return from maxMin function
    val result = maxMin(numbers)
    println("Max num is ${result[0]} and Min num is ${result[1]}")

    //Example 2
    print("Please write some text: ")
    var text = readln()
    print("Now insert the start index: ")
    var startIndex = readln().toInt()
    print("And how many iterations? ")
    var steps = readln().toInt()

    textFun(text, startIndex, steps)
}


fun textFun(text: String, startIndex: Int, steps: Int) {
    var startIndexMut = startIndex
    var stepsMut = steps


    if (startIndexMut == 0 || startIndexMut > text.length - 1) {
        startIndexMut = -1
    }

    do {
        while (startIndexMut <= text.length - 2 && stepsMut > 0) {
            print(text[startIndexMut + 1])
            startIndexMut++
            stepsMut--
        }
        while (startIndexMut > 0 && stepsMut > 0) {
            print(text[startIndexMut - 1])
            startIndexMut--
            stepsMut--
        }

    } while (stepsMut > 0)

}

fun maxMin(arrayOfNum: IntArray): IntArray {
    var maxNum = Int.MIN_VALUE
    var minNum = Int.MAX_VALUE

    for (number in arrayOfNum) {
        if (number > maxNum) {
            maxNum = number
        }
        if (number < minNum) {
            minNum = number
        }
    }

    return intArrayOf(maxNum, minNum)
}