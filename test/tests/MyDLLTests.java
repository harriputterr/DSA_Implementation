/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import implementation.MyDLL;
import utilities.Iterator;

/**
 * 
 */
public class MyDLLTests {
	MyDLL<Integer> test;
	MyDLL<String> testStringHumans;
	MyDLL<String> testStringAnimals;

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
		test = new MyDLL<>();
		testStringHumans = new MyDLL<>();
		testStringAnimals = new MyDLL<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		test = null;
		testStringHumans = null;
		testStringAnimals = null;
	}

	/**
	 * Test method for {@link implementation.MyDLL#size()}.
	 */
	@Test
	public void testSize() {
		int expected = 0;
		int actual = test.size();
		assertEquals("The size method doesn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#clear()}.
	 */
	@Test
	public void testClear() {
		boolean expected = true;
		testStringHumans.add("Harsingh");
		testStringHumans.add("Zoe");
		testStringHumans.add("Mosmee");
		testStringHumans.add("Sourabh");
		testStringHumans.clear();
		boolean actual = testStringHumans.isEmpty();

		assertEquals("The add method doesn't add properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#add(int, java.lang.Object)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testAddIntE() {
		Object[] expected = {"Harsingh", "Zoe", "Nishant", "Mosmee", "Sourabh"};
		testStringHumans.add("Harsingh");
		testStringHumans.add("Zoe");
		testStringHumans.add("Mosmee");
		testStringHumans.add("Sourabh");
		testStringHumans.add(2, "Nishant");
		Object[] actual = testStringHumans.toArray();

		assertEquals("The add method doesn't add properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#add(java.lang.Object)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testAddE() {
		Object[] expected = {"Harsingh", "Zoe", "Mosmee", "Sourabh"};
		testStringHumans.add("Harsingh");
		testStringHumans.add("Zoe");
		testStringHumans.add("Mosmee");
		testStringHumans.add("Sourabh");
		Object[] actual = testStringHumans.toArray();

		assertEquals("The add method doesn't add properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#addAll(utilities.ListADT)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testAddAll() {
		
		Object[] expected = {"Harsingh", "Zoe", "Mosmee", "Sourabh", "Tiger", "Falcon", "Monkey"};
		testStringHumans.add("Harsingh");
		testStringHumans.add("Zoe");
		testStringHumans.add("Mosmee");
		testStringHumans.add("Sourabh");
		
		testStringAnimals.add("Tiger");
		testStringAnimals.add("Falcon");
		testStringAnimals.add("Monkey");
		
		testStringHumans.addAll(testStringAnimals);
		Object[] actual = testStringHumans.toArray();
	
		assertEquals("The addAll method doens't add properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#get(int)}.
	 */
	@Test
	public void testGet() {
		String expected = "Mosmee";
		testStringHumans.add("Harsingh");
		testStringHumans.add("Zoe");
		testStringHumans.add("Mosmee");
		testStringHumans.add("Sourabh");
		String actual = testStringHumans.get(2);
		assertEquals("The get method doens't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#remove(int)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testRemoveInt() {
		Object[] expected = {"Harsingh", "Mosmee", "Sourabh"};
		testStringHumans.add("Harsingh");
		testStringHumans.add("Zoe");
		testStringHumans.add("Mosmee");
		testStringHumans.add("Sourabh");
		
		testStringHumans.remove(1);
		Object[] actual = testStringHumans.toArray();
		assertEquals("The remove method didn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#remove(java.lang.Object)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testRemoveE() {
		Object[] expected = {"Harsingh", "Mosmee", "Sourabh"};
		testStringHumans.add("Harsingh");
		testStringHumans.add("Zoe");
		testStringHumans.add("Mosmee");
		testStringHumans.add("Sourabh");
		
		testStringHumans.remove("Zoe");
		Object[] actual = testStringHumans.toArray();
		assertEquals("The remove method didn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#set(int, java.lang.Object)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testSet() {
		Object[] expected = {"Harsingh", "Kitty", "Mosmee", "Sourabh"};
		testStringHumans.add("Harsingh");
		testStringHumans.add("Zoe");
		testStringHumans.add("Mosmee");
		testStringHumans.add("Sourabh");
		testStringHumans.set(1, "Kitty");
		Object[] actual = testStringHumans.toArray();
		assertEquals("The set method didn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		boolean expected = true;
		boolean actual = testStringAnimals.isEmpty();
		assertEquals("The isEmpty method didn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		boolean expected = true;
		testStringHumans.add("Harsingh");
		testStringHumans.add("Zoe");
		testStringHumans.add("Mosmee");
		testStringHumans.add("Sourabh");
		boolean actual = testStringHumans.contains("Zoe");
		assertEquals("The contains method doesn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#toArray(E[])}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testToArrayEArray() {
		Integer[] expected = {1,2,3,4,5};
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		Integer[] actual = new Integer[5];
		test.toArray(actual);
		assertEquals("The toArray method doesn't function properly", expected, actual);
		
	}

	/**
	 * Test method for {@link implementation.MyDLL#toArray()}.
	 */
	@Test
	public void testToArray() {
		Object[] expected = {1,2,3,4,5};
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		Object[] actual = test.toArray();
		
		assertEquals("The toArray method doesn't function properly", expected, actual);
	}

	/**
	 * Test method for {@link implementation.MyDLL#iterator()}.
	 */
	@Test
	public void testIterator_hasNext() {
		boolean expected = false;
		test.add(1);
		test.add(2);
		test.add(3);
		Iterator<Integer> it = test.iterator();
		it.next();
		it.next();
		it.next();
		boolean actual = it.hasNext();
		assertEquals("The Iterator_HasNext method doesn't function properly", expected, actual);
	}
	/**
	 * Test method for {@link implementation.MyDLL#iterator()}.
	 */
	@Test
	public void testIterator_next() {
		int expected = 2;
		test.add(1);
		test.add(2);
		test.add(3);
		Iterator<Integer> it = test.iterator();
		it.next();
		int actual = it.next();
		assertEquals("The Iterator_next method doesn't function properly", expected, actual);

	}

}
