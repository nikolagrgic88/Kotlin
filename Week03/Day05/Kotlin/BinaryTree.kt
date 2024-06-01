class Node(var data: Int) {
    var nextLeftNode: Node? = null
    var nextRightNode: Node? = null
}

class BinaryTree {
    var start: Node? = null

    fun add(n: Int) {
        val newNode = Node(n)

//        checking if first node exists
        if (start == null) {
            start = newNode
        } else {
            var currentNod = start
            var turnLeft:Boolean

            while (true) {
                turnLeft = currentNod!!.data > newNode.data
//                if new node is smaller than current, turning left
                if (turnLeft) {
                    if (currentNod.nextLeftNode != null) {
                        currentNod = currentNod.nextLeftNode
                    } else {
                        currentNod.nextLeftNode = newNode
                        break
                    }
                } else {
//                    if new node is bigger than current, turn right
                    if (currentNod.nextRightNode != null) {
                        currentNod = currentNod.nextRightNode
                    } else {
                        currentNod.nextRightNode = newNode
                        break
                    }
                }
            }
        }
    }


    fun get(number: Int): Int? {
        var currentNod: Node? = start ?: return null

        var turnLeft:Boolean

        while (true) {
            if (currentNod?.data == number) {
                return currentNod.data
            }
            turnLeft = currentNod!!.data > number
//
            currentNod = if (turnLeft) {
                currentNod.nextLeftNode
            } else {
                currentNod.nextRightNode
            }
        }
    }

    fun delete(number: Int): Int? {

        var currentNod: Node? = start ?: return null
        var prevNode: Node? = null
        var turnLeft = false
        val deletedNode = currentNod?.data

        while (true) {

            if (currentNod?.data == number) {
                var nextNode: Node?

                if (currentNod.nextLeftNode == null && currentNod.nextRightNode == null) {
                    if (prevNode == null) {
                        start = null     // if we select start to be deleted
                    } else if (turnLeft) {
                        prevNode.nextLeftNode = null
                    } else {
                        prevNode.nextRightNode = null
                    }
                }
//                 Node to be deleted that has only one child
                else if (currentNod.nextLeftNode == null || currentNod.nextRightNode == null) {

                    val childNode =
                        if (currentNod.nextLeftNode != null) currentNod.nextLeftNode else currentNod.nextRightNode

                    if (prevNode == null) {
                        start = childNode
                    } else if (turnLeft) {
                        prevNode.nextLeftNode = childNode
                    } else {
                        prevNode.nextRightNode = childNode
                    }
                }
//                 Node to be deleted that has two children
                else {
                    //Going to the left
                    nextNode = currentNod.nextLeftNode
                    //Looking for the last node on the right side (of the left side of the tree)
                    while (nextNode?.nextRightNode != null) {
                        nextNode = nextNode.nextRightNode
                    }
                    currentNod.data = nextNode!!.data//passing value to the previously "deleted" node

                    nextNode.nextLeftNode = null // "Deleting" node after transferring data
                }
                return deletedNode
            }

            turnLeft = currentNod!!.data > number
            prevNode = currentNod
            currentNod = if (turnLeft) {
                currentNod.nextLeftNode
            } else {
                currentNod.nextRightNode
            }
        }
    }
}


fun main() {

    val newTree = BinaryTree()
    newTree.add(10)
    newTree.add(5)
    newTree.add(15)
    newTree.add(8)
    newTree.add(16)
    newTree.add(18)
    newTree.add(1)
    newTree.add(9)

    println(newTree.get(8))
    newTree.delete(5)
    newTree.add(7)
    newTree.add(8)
    newTree.delete(18)
    newTree.add(45)
}
