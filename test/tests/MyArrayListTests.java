/**
 * Just editing this comment as a push test - Zoe
 */
package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import implementation.MyArrayList;
import utilities.Iterator;

/**
 * 
 */
public class MyArrayListTests {
	MyArrayList<Integer> test;
	MyArrayList<Integer> oneToFive;
	MyArrayList<Integer> sixToTen;
	MyArrayList<String> testString;
	
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
		test = new MyArrayList<>();
		
		oneToFive = new MyArrayList<>();
		oneToFive.add(1);
		oneToFive.add(2);
		oneToFive.add(3);
		oneToFive.add(4);
		oneToFive.add(5);
		
		sixToTen = new MyArrayList<>();
		sixToTen.add(6);
		sixToTen.add(7);
		sixToTen.add(8);
		sixToTen.add(9);
		sixToTen.add(10);
		
		testString = new MyArrayList<>();
		testString.add("Harsingh");
		testString.add("Zoe");
		testString.add("Mosmee");
		testString.add("Sourabh");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		test = null;
		oneToFive = null;
		sixToTen = null;
		testString = null;
	}

	/**
	 * Test method for {@link implementation.MyArrayList#hasNext()}.
	 */
	@Test
	public void testHasNext() {
		boolean expected = false;
		Iterator<Integer> iterator = test.iterator();
		boolean actual = iterator.hasNext();
		assertEquals("The hasNext method does not work as expected", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#next()}.
	 */
	@Test
	public void testNext() {
		int expected = 1;
		test.add(1);
		Iterator<Integer> iterator = test.iterator();
		int actual = iterator.next();
		assertEquals("The next method does not work as expected", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#size()}.
	 */
	@Test
	public void testSize() {
		int expected = 1;
		test.add(1);
		int actual = test.size();
		assertEquals("The size method does not work as expected", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#clear()}.
	 */
	@Test
	public void testClear() {
		boolean expected = false;
		test.add(1);
		test.add(2);
		test.add(3);
		test.clear();
		Iterator<Integer> iterator = test.iterator();
		boolean actual = iterator.hasNext();
		
		assertEquals("The clear method does not work as expected", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		
		Integer [] expected = {1, 2, 3, 4};
		test.add(1);
		test.add(3);
		test.add(4);
		test.add(1, 2);
		Integer [] actual = new Integer[4];
		actual = test.toArray(actual);
		
		if (java.util.Arrays.equals(expected, actual)) {
			assertTrue(true);
			return;
		}
		fail("add(int index, Object toAdd) method doesn't function properly");
		
	}

	/**
	 * Test method for {@link implementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddE() {
		Integer [] expected = {1, 2, 3, 4};
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		Integer [] actual = new Integer[4];
		actual = test.toArray(actual);
	
		if (java.util.Arrays.equals(expected, actual)) {
			assertTrue(true);
			return;
		}
		fail("add(int index, Object toAdd) method doesn't function properly");
	}

	/**
	 * Test method for {@link implementation.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	public void testAddAll() {
		
		 Object[] expected = {1,2,3,4,5,6,7,8,9,10};
		 oneToFive.addAll(sixToTen);
		 Object[] actual = oneToFive.toArray();
		 
		 if (java.util.Arrays.equals(expected, actual)){
			 assertTrue(true);
			 return;
		 }
		 
		 fail("add(int index, Object toAdd) method doesn't function properly");
	}

	/**
	 * Test method for {@link implementation.MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		int expected = 5;
		int actual = oneToFive.get(4);
		assertEquals("The get method doesn't function properly", expected, actual);
		
	}

	/**
	 * Test method for {@link implementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		int expected = 3;
		test.add(1);
		test.add(2);
		test.add(3);
		test.remove(1);
		int actual = test.get(1);
		assertEquals("The remove(int index) method doesn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveE() {
		String expected = "Zoe";
		testString.remove("Harsingh");
		String actual = testString.get(0);
		assertEquals("The remove(E element) doesn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		int expected = 10;
		oneToFive.set(4, 10);
		int actual = oneToFive.get(4);
		assertEquals("The set method doesn't function properly", expected, actual);
		
	}

	/**
	 * Test method for {@link implementation.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		boolean expected = false;
		boolean actual = oneToFive.isEmpty();
		assertEquals("The is Empty method doesn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		boolean expected = true;
		boolean actual = oneToFive.contains(5);
		assertEquals("The contains method doesn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#toArray(E[])}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testToArrayEArray() {
		Integer[] expected = {1,2,3,4,5};
		Integer[] actual = new Integer[5];
		oneToFive.toArray(actual);
		// Its deprecated but it still works, right? Which is awesome.
		assertEquals("The toArray(E toHold) method doesn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		Object[] expected = {1,2,3,4,5};
		Object[] actual = oneToFive.toArray();
		
		// Its deprecated but it still works, right? Which is awesome.
		assertEquals("The toArray(E toHold) method doesn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator_Next() {
		int expected = 1;
		Iterator<Integer> iterator = oneToFive.iterator();
		int actual = iterator.next();
		assertEquals("The iterator doesn't function properly", expected, actual);
	}

}
