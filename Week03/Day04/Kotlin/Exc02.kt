class Node(var data: Int) {
    var next: Node? = null
}

class LinkedList {
    var start: Node? = null

    fun add(n: Int) {
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

    fun get(i: Int): Int? {

        var currentIndex = 0
        var currentNod: Node? = start ?: return null

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

    fun remove(i: Int): Int? {

        var currentIndex = 0
        var currentNod: Node? = start
        var prevNode: Node? = null

        if (i <= size()) {
            while (currentNod != null) {
                if (currentIndex == i) {//
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

    fun insertBefore(i: Int, n: Int) {
        var currentIndex = 0
        var currentNod: Node? = start
        var prevNode: Node? = null

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

    fun prepend(n: Int) {
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
    val linkList = LinkedList()

    linkList.add(1)
    linkList.add(2)
    linkList.add(3)
    linkList.remove(2)
    linkList.add(4)
    linkList.add(5)
    linkList.add(6)
    linkList.insertBefore(3, 25)
    linkList.prepend(25)
    println(linkList.get(0))
    println(linkList.get(1))
    println(linkList.get(2))
    println(linkList.get(3))
    println(linkList.get(4))
    println(linkList.get(5))

}
