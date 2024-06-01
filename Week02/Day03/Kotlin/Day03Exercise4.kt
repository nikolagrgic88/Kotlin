fun main() {
    var sameNums = findDups(intArrayOf(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 1))
    findDups(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
    for (num in sameNums) {
        println(num)
    }

}


fun findDups(numArray: IntArray): ArrayList<Int> {
//    Exercise 4
    var collectionOfSame = ArrayList<Int>()
    var result = false
    var j = 1
    for (num in numArray) {
        for (i in j..numArray.size - 1) {
            if (numArray[i] == num) {
                result = true
                collectionOfSame.add(num)
            }
        }
        j++
    }
    println(result)

    return collectionOfSame
}