package sanguk2.github.io.linkedlist;

import sanguk2.github.io.linkedlist.enums.Method;
import sanguk2.github.io.linkedlist.exception.EmptyException;

public class LinkedListQueue <T> extends LinkedList {
    Node rear;

    public void enqueue (T data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
        length++;
    }

    public T dequeue () {
        if (isEmpty()) {
            throw new EmptyException(Method.Dequeue);
        }
        T data = (T) head.getData();
        head = head.getNext();
        if (isEmpty()) {
            rear = null;
        }
        length--;
        return data;
    }

    public T peek () {
        if (isEmpty()) {
            throw new EmptyException(Method.Dequeue);
        }
        return (T) head.getData();
    }
}
