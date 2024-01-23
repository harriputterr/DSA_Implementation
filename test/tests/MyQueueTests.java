package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import implementation.MyQueue;
import utilities.Iterator;
import exceptions.EmptyQueueException;

public class MyQueueTests {

    private MyQueue<Integer> queue;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() {
        queue = new MyQueue<>();
    }

    @After
    public void tearDown() {
        queue.dequeueAll();
    }

    @Test
    public void testEnqueueAndPeek() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        try {
			assertEquals("Peek should return the first element", Integer.valueOf(1), queue.peek());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test(expected = NullPointerException.class)
    public void testEnqueueNull() {
        queue.enqueue(null);
    }

    @Test
    public void testDequeue() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals("Dequeue should return the first element", Integer.valueOf(1), queue.dequeue());
        assertEquals("Dequeue should remove the element", Integer.valueOf(2), queue.peek());
    }

    @Test(expected = EmptyQueueException.class)
    public void testDequeueEmptyQueue() throws EmptyQueueException {
        queue.dequeue();
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Queue should be empty", queue.isEmpty());
        queue.enqueue(1);
        assertFalse("Queue should not be empty", queue.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals("Size of empty queue should be 0", 0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals("Size should be 2 after two enqueues", 2, queue.size());
    }

    @Test
    public void testClear() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeueAll();
        assertTrue("Queue should be empty after clear", queue.isEmpty());
    }

    @Test
    public void testToArray() {
        queue.enqueue(1);
        queue.enqueue(2);
        Object[] arr = queue.toArray();
        assertArrayEquals("toArray should return an array with all elements", new Object[]{1, 2}, arr);
    }

    @Test
    public void testIterator() {
        queue.enqueue(1);
        queue.enqueue(2);
        Iterator<Integer> iterator = queue.iterator();
        assertTrue("Iterator should have next", iterator.hasNext());
        assertEquals("Iterator next should return first element", Integer.valueOf(1), iterator.next());
    }
    
    @Test
    public void testEquals() {
        MyQueue<Integer> anotherQueue = new MyQueue<>();
        queue.enqueue(1);
        anotherQueue.enqueue(1);
        assertTrue("Queues with the same elements should be equal", queue.equals(anotherQueue));
    }

}
