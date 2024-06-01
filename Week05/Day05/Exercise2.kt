open class Node<T>(var data: T) {
    var next: Node<T>? = null
}

class Stack<T> : Node<T?>(data=null) {

    private var start: Node<T>? = null

    fun enqueue(data: T) {
        val newNode = Node(data)


        if (start == null) {
            start = newNode
        } else {
            var currentNode: Node<T>? = start
            while (currentNode?.next != null) {
                currentNode = currentNode.next
            }
            currentNode?.next = newNode
        }
    }

    fun dequeue(): T? {
        if (start != null) {
            val dequeuedNod = start
           start= start?.next
            return dequeuedNod?.data
        }
       return null
    }


}

fun main() {
    val stack = Stack<String>()
    stack.enqueue("One")
    stack.enqueue("Two")
    stack.enqueue("Three")
    stack.enqueue("Four")
    println(stack.dequeue())
    println(stack.dequeue())
    stack.enqueue("Six")

}
