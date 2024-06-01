open class Node<T>(var data: T?) {
    var next: Node<T>? = null
}

class Stack<T>: Node<T?>(data=null) {

    private var start: Node<T>? = null

    fun push(data: T) {
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

    fun pop(): T? {
        if(start == null){
            println("Stack is empty")
            return null
        }
        var lastNode: Node<T>? = start
        var previousNode: Node<T>? = null
        while (lastNode?.next != null) {
            previousNode = lastNode
            lastNode = lastNode.next
        }
        val poppedNode: Node<T>? = lastNode
        previousNode?.next = null
        return poppedNode?.data
    }


    fun peek(): T? {
        if(start == null){
            println("Stack is empty")
            return null
        }
        var lastNode: Node<T>? = start
        while (lastNode?.next != null) {
            lastNode = lastNode.next
        }
        return lastNode?.data
    }
}

fun main() {
    val stack = Stack<Int>()
    stack.peek()
    stack.pop()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println(stack.peek())
}
