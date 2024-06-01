//interface MapComparable<T> {
//    fun compare(a: T, b: T): Int;
//}
//
//class CompareKeys : MapComparable<Int> {
//    override fun compare(a: Int, b: Int): Int {
//        return a.compareTo(b)
//    }
//}
//
//class Node<K, V>(val key: K, val value: V) {
//    var next: Node<K, V>? = null
//}
//
//class LinkedListMap<K, V>(val comparator: MapComparable<K>) {
//    var start: Node<K, V>? = null
//
//    fun put(key: K, value: V) {
//        val newNode = Node(key, value)//adding a new node
////        checking if first node exists
//        if (start == null) {
//            start = newNode
//            // using compareTo method, if a==b returns 0, if a>b returns negative num,if a<b returns positive num
//        } else if (comparator.compare(start!!.key, key) > 0) {
//            // Insert newNode at the beginning of the list
//            newNode.next = start
//            start = newNode
//        } else {
//            //if the key is equal or greater it will be set as a next node
//            var currentNod = start
//
//            while (currentNod?.next != null && comparator.compare(currentNod.next!!.key, key) <= 0) {
//                currentNod = currentNod.next
//            }
//            newNode.next = currentNod!!.next
//            currentNod.next = newNode
//        }
//    }
//
//    fun display() {
//        var currentNod = start
//        while (currentNod != null) {
//            println("${currentNod.key}:${currentNod.value} => ${currentNod.next?.key}:${currentNod.next?.value}")
//            currentNod = currentNod.next
//        }
//    }
//
//}
//
//fun main() {
//    val compare: MapComparable<Int> = CompareKeys()
//    val linkedListMap = LinkedListMap<Int, String>(compare)
//
//    linkedListMap.put(1, "One")
//    linkedListMap.put(7, "Seven")
//    linkedListMap.put(2, "Two")
//    linkedListMap.put(4, "Four")
//    linkedListMap.put(3, "Three")
//    linkedListMap.put(8, "Eight")
//    linkedListMap.put(5, "Five")
//    linkedListMap.put(6, "Six")
//    linkedListMap.display()
//
//}