interface Iterable<Int> {
    fun iterator(): Iterator<Int>
}

class SequenceGeneratorIterator(start: Int, private val end: Int) : Iterator<Int> {
    private var current = start

    override fun next(): Int {
        if (!hasNext()) {
            throw RuntimeException("Next number is out of the sequence")
        }
        return current++
    }

    override fun hasNext(): Boolean {
        return current <= end
    }
}

class SequenceGenerator(private var start: Int, private var end: Int) : Iterable<Int> {
    override operator fun iterator(): Iterator<Int> {
        return SequenceGeneratorIterator(start, end)
    }

    fun getNext(): Int {
        if (start < end) {
            start++
        } else {
            throw RuntimeException("Next number is out of the sequence")
        }
        return start
    }
}


fun main() {
    val sequenceOne = SequenceGenerator(2, 10)
    val seqTwo = SequenceGeneratorIterator(2, 10)
    for (i in sequenceOne) println(i)
    for (i in seqTwo) println(i)

    val listObj = listOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")

    val sequenceGenerator = SequenceGenerator(0, Int.MAX_VALUE)
    val result = listObj.map { Pair(it.second, sequenceGenerator.getNext()) }

    for (pair in result) {
        println("${pair.first}: ${pair.second}")
    }

}