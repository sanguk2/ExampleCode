package sanguk2.github.io.linkedlist;

import sanguk2.github.io.linkedlist.enums.Method;
import sanguk2.github.io.linkedlist.exception.BoundsException;

public class LinkedList<T> {
    protected Node head;
    protected int length = 0;

    public LinkedList() {
        head = null;
    }

    public void add (T data) {
        Node node = new Node(data);
        if (isEmpty()) {
            this.head = node;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        length++;
    }

    public void add (T data, int index) throws BoundsException {
        if (index < 0) {
            throw new BoundsException(Method.Add, index);
        } else if (index == 0) {
            Node node = new Node(data, this.head);
            this.head = node;
        } else {
            try {
                Node node = new Node(data);
                Node temp = this.head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.getNext();
                }
                node.setNext(temp.getNext());
                temp.setNext(node);

            } catch (NullPointerException e) {
                throw new BoundsException(Method.Add, index);
            }
        }
        length++;
    }

    public void remove (int index) throws BoundsException {
        try {
            if (index < 0) {
                throw new BoundsException(Method.Remove, index);
            } else if (index == 0) {
                this.head = this.head.getNext();
            } else {
                Node preNode = null;
                Node thisNode = this.head;

                for (int i = 0; i < index; i++) {
                    preNode = thisNode;
                    thisNode = thisNode.getNext();
                }

                preNode.setNext(thisNode.getNext());
            }
        } catch (NullPointerException e) {
            throw new BoundsException(Method.Remove, index);
        }
        length--;
    }

    // 포함하는 값이 없을 경우 -1, 있을 경우 index를 반환
    public int contains (T data) {
        if (isEmpty()) {
            return -1;
        } else {
            boolean flag = false;
            int index = 0;
            Node node = this.head;
            while (node != null) {
                if (node.getData().equals(data)) {
                    flag = true;
                    break;
                }
                node = node.getNext();
                index++;
            }
            return flag ? index : -1;
        }
    }

    public int size() {
        return length;
    }

    public void clear() {
        this.head = null;
        length = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node temp = head;

        while (temp.getNext() != null) {
            sb.append(temp.getData() + " -> ");
            temp = temp.getNext();
        }

        if (head != null) {
            sb.append(temp.getData());
        }

        return sb.toString();
    }

    public class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() { return data; }
        public void setData(T data) { this.data = data; }
        public Node getNext() { return next; }
        public void setNext(Node next) { this.next = next; }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
