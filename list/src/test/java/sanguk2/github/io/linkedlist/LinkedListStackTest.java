package sanguk2.github.io.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sanguk2.github.io.linkedlist.exception.EmptyException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinkedListStackTest {
    LinkedListStack<String> linkedListStack;

    @BeforeEach
    void beforeEach() {
        linkedListStack = new LinkedListStack<>();

        linkedListStack.push("하나");
        linkedListStack.push("둘");
        linkedListStack.push("셋");
    }

    @Test
    void pushTest() {
        linkedListStack.push("넷");

        assertEquals("넷 -> 셋 -> 둘 -> 하나", linkedListStack.toString());
    }

    @Test
    void popTest() {
        assertEquals("셋", linkedListStack.pop());
        assertEquals("둘", linkedListStack.pop());
        assertEquals("하나", linkedListStack.pop());
        assertThrows(EmptyException.class, () -> linkedListStack.pop());
    }

    @Test
    void peekTest() {
        assertEquals("셋", linkedListStack.peek());
        assertEquals("셋", linkedListStack.peek());
    }
}