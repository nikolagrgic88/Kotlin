class Node<T>(var data: T) {
    var next: Node<T>? = null
}

class LinkedList<T> {
    var start: Node<T>? = null

    fun add(n: T) {
        val newNode = Node(n)//adding a new node
//        checking if first node exists
        if (start == null) {
            start = newNode
        } else {
            var currentNod = start
            while (currentNod?.next != null) {
                currentNod = currentNod.next
            }
            currentNod?.next = newNode
        }
    }

    fun get(i: Int): T? {

        var currentIndex = 0
        var currentNod: Node<T>? = start ?: return null

        if (i <= size()) {
            while (currentNod != null) {
                if (currentIndex == i) { // when we find an index we return value
                    return currentNod.data
                }
                currentIndex++
                currentNod = currentNod.next
            }
        }
        return null
    }

    fun remove(i: Int): T? {

        var currentIndex = 0
        var currentNod: Node<T>? = start
        var prevNode: Node<T>? = null

        if (i <= size()) {
            while (currentNod != null) {
                if (currentIndex == i) {
                    val deleted = currentNod
                    if (prevNode == null) start = currentNod.next//if the first element in the list is selected
                    prevNode?.next = currentNod.next//previous node pointing in next node(deleting current one)
                    return deleted.data
                }
                prevNode = currentNod
                currentNod = currentNod.next
                currentIndex++
            }
        }
        return null
    }

    fun insertBefore(i: Int, n: T) {
        var currentIndex = 0
        var currentNod: Node<T>? = start
        var prevNode: Node<T>? = null

        if (i <= size()) {
            while (currentNod != null) {
                if (currentIndex == i) {
                    val newNode = Node(n)//creating a new Node
                    if (prevNode == null) {//if we are trying to insert at index 0
                        start = newNode
                    } else {
                        prevNode.next = newNode
                    }
                    newNode.next = currentNod
                    return
                }
                prevNode = currentNod
                currentNod = currentNod.next
                currentIndex++
            }
        }
    }

    fun prepend(n: T) {
        val newNod = Node(n)
        newNod.next = start
        start = newNod
    }


    fun size(): Int {
        var counter = 0
        var currentNode = start

        while (currentNode != null) {
            counter++
            currentNode = currentNode.next
        }
        return counter
    }
}

fun main() {
    testAddingNum()
    testString()
    testDefault()
    testAddTwo()
    testAddArray()
    testAddRemove()
    testGet()
    testRemove()
    specialTest()
}

fun testAddingNum() {
    val adding = LinkedList<Int>()
    adding.add(5)

}

fun testDefault() {
    val default = LinkedList<Int>()
    println(default.start?.data)
    println(default.size())
}

fun testAddTwo() {
    val addTwo = LinkedList<Int>()
    addTwo.add(5)
    addTwo.add(10)
    println(addTwo.get(0))
    println(addTwo.get(0))

}

fun testAddArray() {
    val addTree = LinkedList<Array<Int>>()
    addTree.add(arrayOf(5, 3, 8, 5, 9))
    val arrayT = addTree.get(0)
    for (i in arrayT!!) {
        println(i)
    }
}

fun testString() {
    val testString = LinkedList<String>()
    testString.add("First")
    testString.add("Second")

    println(testString.get(0))
    println(testString.get(1))
}

fun testAddRemove() {
    val addRemove = LinkedList<Int>()
    addRemove.add(2)
    addRemove.add(4)
    addRemove.add(34)
    addRemove.add(8)
    addRemove.add(10)
    addRemove.remove(2)
    println(addRemove.size())
    println(addRemove.get(0))
    println(addRemove.get(1))
    println(addRemove.get(2))
    println(addRemove.get(3))
}

fun testGet() {
    val testGet = LinkedList<Int>()
    println(testGet.get(0))
}

fun testRemove() {
    val testRemove = LinkedList<Int>()
    println(testRemove.get(0))
}

fun specialTest() {
    val testSpecial = LinkedList<Int>()
    println(testSpecial.remove(-3))
    println(testSpecial.get(-3))
}
