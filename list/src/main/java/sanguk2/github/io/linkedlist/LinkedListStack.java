package sanguk2.github.io.linkedlist;

import sanguk2.github.io.linkedlist.enums.Method;
import sanguk2.github.io.linkedlist.exception.EmptyException;

public class LinkedListStack <T> extends LinkedList {

    public void push(T data) {
        Node node = new Node(data);
        if (!isEmpty()) {
            node.setNext(this.head);
        }
        this.head = node;
        length++;
    }

    public T pop() {
        if (this.head == null) {
            throw new EmptyException(Method.Pop);
        }
        T data = (T) this.head.getData();
        this.head = this.head.getNext();
        length--;
        return data;
    }

    public T peek() {
        if (this.head == null) {
            throw new EmptyException(Method.Pop);
        }
        return (T) this.head.getData();
    }
}
