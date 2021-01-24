package sanguk2.github.io.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sanguk2.github.io.linkedlist.exception.EmptyException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinkedListQueueTest {
    LinkedListQueue<String> linkedListQueue;

    @BeforeEach
    void beforeEach() {
        linkedListQueue = new LinkedListQueue<>();

        linkedListQueue.enqueue("입력 1");
        linkedListQueue.enqueue("입력 2");
        linkedListQueue.enqueue("입력 3");
    }

    @Test
    void enqueueTest() {
        linkedListQueue.enqueue("입력 4");

        assertEquals("입력 1 -> 입력 2 -> 입력 3 -> 입력 4", linkedListQueue.toString());
        assertEquals(4, linkedListQueue.size());
    }

    @Test
    void dequeueTest() {
        assertEquals("입력 1", linkedListQueue.dequeue());
        assertEquals("입력 2", linkedListQueue.dequeue());
        assertEquals("입력 3", linkedListQueue.dequeue());
        assertEquals(0, linkedListQueue.size());
        assertThrows(EmptyException.class, () -> linkedListQueue.dequeue());
    }

    @Test
    void peekTest() {
        assertEquals("입력 1", linkedListQueue.peek());
        assertEquals("입력 1", linkedListQueue.peek());
        assertEquals("입력 1", linkedListQueue.peek());
        assertEquals(3, linkedListQueue.size());
    }
}