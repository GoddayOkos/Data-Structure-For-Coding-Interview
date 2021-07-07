class DoublyLinkedList<T> {

    //Node inner class for SLL
    data class Node<T>(var value: T, var prev: Node<T>? = null, var next: Node<T>? = null) {
        override fun toString(): String {
            return if (next != null) {
                "$value <-> ${next.toString()}"
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
        val head = this.head
        if (head == null) {
            this.head = Node(value = value, next = head)
            if (tail == null) {
                tail = this.head
            }
            size++
            return
        }

        this.head = Node(value = value, next = head)
        head.prev = this.head
        size++
    }

    // Insert at the last position
    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        val tail = this.tail
        this.tail?.next = Node(value)
        this.tail = this.tail?.next
        this.tail?.prev = tail
        size++
    }

    // Delete the first item from the list
    fun pop() {
        if (!isEmpty()) {
            size--
            head = head?.next
            head?.prev = null
        }
        if (isEmpty()) tail = null
    }

    // Delete node by value
    fun removeByValue(value: T) {
        if (head?.value == value) return pop()

       // var prev: Node<T>? = null
        var current = head

        while (current != null) {
            if (current.value == value) {
               // prev?.next = current.next
                   current.prev?.next = current.next
                size--
                return
            }

           // prev = current
           // current = current.next
            current.prev = current
            current = current.next
        }
    }
}