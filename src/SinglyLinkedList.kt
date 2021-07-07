class SinglyLinkedList<T> {

    //Node inner class for SLL
    data class Node<T>(var value: T, var next: Node<T>? = null) {
        override fun toString(): String {
            return if (next != null) {
                "$value -> ${next.toString()}"
            } else {
                "$value -> null"
            }
        }
    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0


    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }

    // Insert at the first position
    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    // Insert at the last position
    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
    }

    // Get the node at the given index
    fun nodeAt(index: Int): Node<T>? {
        if (index < 0) return null

        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    // Insert after a given node
    fun insert(value: T, afterNode: Node<T>) {
        if (tail == afterNode) {
            append(value)
            return
        }

        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
    }

    // Check if the list contains a node with the given value
    fun searchNode(value: T): Boolean {
        var currentNode = head
        while (currentNode != null) {
            if (currentNode.value == value) return true
            currentNode = currentNode.next
        }
        return false
    }

    // Delete the first item from the list
    fun pop() {
        if (!isEmpty()) {
            size--
            head = head?.next
        }
        if (isEmpty()) tail = null
    }

    // Delete the last item from the list
    fun removeLast() {
        val head = this.head
        if (head?.next == null) {
            pop()
            return
        }
        size--

        var prev = head
        var current = head
        var next = current.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev?.next = null
        tail = prev
    }

    // Delete the node after the given node
    fun removeAfter(node: Node<T>) {
        if (node.next == tail) tail = node
        if (node.next != null) size--

        node.next = node.next?.next
    }

    // Delete node by value
    fun removeByValue(value: T) {
        if (head?.value == value) return pop()

        var prev: Node<T>? = null
        var current = head

        while (current != null) {
            if (current.value == value) {
                prev?.next = current.next
                size--
                return
            }

            prev = current
            current = current.next
        }
    }

}