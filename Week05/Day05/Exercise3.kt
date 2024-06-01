class ArrayList<T>(private var capacity: Int, private var size: Int) {
    private var arrayList = Array<Any?>(capacity) {}


    fun add(value: T) {
        if (size >= capacity) {
            extendArray()
        }
        arrayList[size] = value
        size++
    }

    fun get(index: Int): Any? {
        if (index >= size) {
            println("Out of bound")
            return null
        }
        return arrayList[index]
    }

    fun remove(index: Int): Any? {
        if (index >= size) {
            println("Out of bound")
            return null
        }
        val removedElement = arrayList[index]
        for (i in index..<arrayList.size - 1) {
            arrayList[i] = arrayList[i + 1]
        }
        size--
        return removedElement
    }

    fun size(): Int {
        return size
    }


    fun prepend(value: T) {
        if (size >= capacity) {
            extendArray()
        }
        for (i in size downTo 1)
            arrayList[i] = arrayList[i - 1]
    }

    private fun extendArray() {

        val newCapacity = capacity * 2
        val newArrayList = Array<Any?>(newCapacity) {}
        // copying elements to new array
        for (i in 0..<size) {
            newArrayList[i] = arrayList[i]
        }
        capacity = newCapacity
        arrayList = newArrayList

    }

}

fun main() {
    val newList = ArrayList<Int>(3, 0)
    newList.add(5)
    newList.add(4)
    newList.add(56)
    newList.add(7)
    newList.add(4)
    newList.add(2)
    newList.add(1)

    newList.get(3)
    newList.remove(6)
    println(newList.remove(5))
    newList.add(27)
    newList.add(34)
    newList.add(52)
    newList.add(11)
    newList.add(33)
    println(newList.size())
    println(newList.get(9))
    println(newList.remove(9))
    newList.prepend(5)

}