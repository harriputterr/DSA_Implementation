/**
 * 
 */
package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import implementation.MyStack;
import utilities.Iterator;

import java.util.EmptyStackException;


/**
 * 
 */
public class MyStackTests {

	private MyStack<Integer> testIntStack;
    private MyStack<String> testStringStack;
    
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testIntStack = new MyStack<>();
        testStringStack = new MyStack<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		testIntStack = null;
        testStringStack = null;
    }

	/**
	 * Test method for {@link implementation.MyStack#MyStack()}.
	 */
	@Test
	public final void testMyStack() {
	    testIntStack.push(1);
	    assertFalse("Stack should not be empty after push", testIntStack.isEmpty());// TODO
	}

	/**
	 * Test method for {@link implementation.MyStack#push(java.lang.Object)}.
	 */
	@Test
	public final void testPush() {
		 testIntStack.push(1);
		    assertEquals("Stack should have the pushed element as the top element", (Integer) 1, testIntStack.peek());

		    testStringStack.push("Harsingh");
		    assertEquals("Stack should have the pushed string as the top element", "Harsingh", testStringStack.peek());
		} // TODO

	/**
	 * Test method for {@link implementation.MyStack#pop()}.
	 */
	@Test
	public final void testPop() {
		testIntStack.push(1);
        testIntStack.push(2);
        assertEquals("Pop should return the last pushed item", (Integer) 2, testIntStack.pop());
        assertEquals("Pop should remove the last item, reducing the stack size", 1, testIntStack.size()); // TODO
	}
	
	@Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        testIntStack.pop();
    }


	/**
	 * Test method for {@link implementation.MyStack#peek()}.
	 */
	@Test
	public final void testPeek() {
		 testIntStack.push(3);
	        assertEquals("Peek should return the last pushed item without removing it", (Integer) 3, testIntStack.peek());
	        assertEquals("Peek should not remove the item from the stack", 1, testIntStack.size());// TODO
	}
	@Test(expected = EmptyStackException.class)
	 public void testPeekEmptyStack() {
	        testIntStack.peek();
	    }

	/**
	 * Test method for {@link implementation.MyStack#clear()}.
	 */
	@Test
	public final void testClear() {
		testIntStack.push(1);
        testIntStack.push(2);
        testIntStack.push(3);
        testIntStack.clear();
        assertTrue("The clear method does not work as expected", testIntStack.isEmpty()); // TODO
	}

	/**
	 * Test method for {@link implementation.MyStack#isEmpty()}.
	 */
	@Test
	public final void testIsEmpty() {
		 	assertTrue("Newly created stack should be empty", testIntStack.isEmpty());
		    testIntStack.push(1);
		    assertFalse("Stack should not be empty after pushing an element", testIntStack.isEmpty()); // TODO
	}

	/**
	 * Test method for {@link implementation.MyStack#toArray()}.
	 */
	@Test
	public final void testToArray() {
		 testStringStack.push("Harsingh");
	        testStringStack.push("Zoe");
	        testStringStack.push("Mosmee");
	        String[] expectedArray = {"Harsingh", "Zoe", "Mosmee"};
	        assertArrayEquals("toArray should return an array of all elements in the stack", expectedArray, testStringStack.toArray()); // TODO
	}

	/**
	 * Test method for {@link implementation.MyStack#toArray(E[])}.
	 */
	@Test
	public final void testToArrayEArray() {
		 testIntStack.push(8);
	        testIntStack.push(9);
	        Integer[] expectedArray = {8, 9};
	        Integer[] actualArray = new Integer[2];
	        testIntStack.toArray(actualArray);
	        assertArrayEquals("toArray(E[] holder) should return an array with all elements in the stack", expectedArray, actualArray); // TODO
	}

	/**
	 * Test method for {@link implementation.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public final void testContains() {
		 testStringStack.push("Harsingh");
		 	assertTrue("Stack should contain the pushed element 'Harsingh'", testStringStack.contains("Harsingh"));
		    assertFalse("Stack should not contain an element 'Zoe' that has not been pushed", testStringStack.contains("Zoe")); // TODO
	}

	/**
	 * Test method for {@link implementation.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public final void testSearch() {
		 testIntStack.push(4);
	        testIntStack.push(5);
	        testIntStack.push(6);
	        assertEquals("Search should return the index of the element", 1, testIntStack.search(5));
	        assertEquals("Search should return -1 if the element is not found", -1, testIntStack.search(7)); // TODO
	}

	/**
	 * Test method for {@link implementation.MyStack#iterator()}.
	 */
	@Test
	public final void testIterator() {
		testStringStack.push("Harsingh");
        testStringStack.push("Zoe");
        Iterator<String> iterator = testStringStack.iterator();
        assertTrue("Iterator should have next", iterator.hasNext());
        assertEquals("Iterator next should return 'Harsingh'", "Harsingh", iterator.next());
        assertEquals("Iterator next should return 'Zoe'", "Zoe", iterator.next());
        assertFalse("Iterator should not have next after the last element", iterator.hasNext());; // TODO
	}

	/**
	 * Test method for {@link implementation.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	public final void testEqualsStackADTOfE() {
		MyStack<Integer> anotherIntStack = new MyStack<>();
        testIntStack.push(10);
        anotherIntStack.push(10);
        assertTrue("Equals should return true for stacks with the same elements", testIntStack.equals(anotherIntStack));

        anotherIntStack.push(11);
        assertFalse("Equals should return false for stacks with different elements", testIntStack.equals(anotherIntStack)); // TODO
	}

	/**
	 * Test method for {@link implementation.MyStack#size()}.
	 */
	@Test
	public final void testSize() {
		 testIntStack.push(1);
	     assertEquals("The size method does not work as expected", 1, testIntStack.size()); // TODO
	}

}
