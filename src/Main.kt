fun main() {
    val linkedList = DoublyLinkedList<Int>()
    println(linkedList)

    for (i in 1..10) {
        linkedList.append(i)
        println(linkedList)
    }

    linkedList.push(2)

    println(linkedList)

//    linkedList.pop()
//    linkedList.pop()
    linkedList.removeByValue(10)
    linkedList.removeByValue(2)

    println(linkedList)
}