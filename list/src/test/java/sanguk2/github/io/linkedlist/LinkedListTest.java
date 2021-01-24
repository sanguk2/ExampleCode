package sanguk2.github.io.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sanguk2.github.io.linkedlist.exception.BoundsException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinkedListTest {
    LinkedList<String> linkedList;

    @BeforeEach
    void beforeEach(){
        linkedList = new LinkedList<>();

        linkedList.add("왕");
        linkedList.add("귀", 1);
        linkedList.add("요");
    }

    @Test
    void addTest() {
        linkedList.add("김민교", 0);

        assertEquals("김민교 -> 왕 -> 귀 -> 요", linkedList.toString());
    }

    @Test
    void removeTest() {
        linkedList.remove(2);

        assertEquals("왕 -> 귀", linkedList.toString());
        assertThrows(BoundsException.class, () -> linkedList.remove(2));
    }

    @Test
    void containsTest() {
        assertEquals(0, linkedList.contains("왕"));
        assertEquals(1, linkedList.contains("귀"));
        assertEquals(2, linkedList.contains("요"));
        assertEquals(-1, linkedList.contains("없음"));
    }

    @Test
    void sizeTest() {
        assertEquals(3, linkedList.size());
    }

    @Test
    void clearTest() {
        linkedList.clear();
        assertEquals(null, linkedList.head);
        assertEquals(0, linkedList.length);
    }
}