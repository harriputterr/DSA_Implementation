package implementation;

import java.util.Arrays;
import java.util.NoSuchElementException;

import utilities.*;


/**
 * Implementation of an ArrayList.
 * 
 * @param <E> the type of elements held in this collection
 */
public class MyArrayList<E> implements ListADT<E> {
	
	/**
	 *  Auto-generated serialVersionUID.
	 */
	private static final long serialVersionUID = -4171887380149471811L;
	
	//Attributes
	private E[] array;
	private int size;
	
	/**
	 * <p>
	 * Constructor method that creates an empty ArrayList and 
	 * initializes it with an intitial capacity of 10. Also, adds 
	 * null padding for the unused indexes of the array.
	 * </p>
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (E[]) new Object[10];
		size = 0;
	}

	/**
	 * The size method will return the current element count contained 
	 * in the list.
	 * 
	 * @return The current element count.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 */
	@Override
	public void clear() {
		for (int i = 0; i < this.size(); i++) {
			array[i] = null;
		}
		size = 0;
	}
	
	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * 
	 * @param index
	 * 			The index at which the specified element is to be inserted.
	 * 			The element is inserted before the existing element at [index],
	 * 			or at the end if index is equal to the 
	 * 			size (<code>size()</code>).
	 * @param toAdd
	 * 			The element to be inserted.
	 * @return <code>true</code> if the element is added successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the 
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index > size()</code>).
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		// This is where we resize the array if more elements are added to MyArrayList then its initial capacity of 10.
		if (this.size() + 1 > this.array.length ) {
			E[] tempArray = this.array;
			this.array = (E[]) new Object[this.size() + 10];
			for (int i =0; i < this.size(); i++) {
				if (tempArray[i] != null) {
					array[i] = tempArray[i];
				}
			}
		}
		System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
		array[index] = toAdd;
		size++;
		return true;
	}

	/**
	 * Appends the specified element to the end of this list.
	 * Implementations that support this operation may place limitations 
	 * on what elements may be added to this list. In particular, some
	 * implementations will refuse to add <code>null</code> elements.
	 * List classes should clearly specify in their
	 * documentation any restrictions on what elements may be added.
	 * 
	 * @param toAdd
	 * 			Element to be appended to this list.
	 * @return true if element is appended successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the list
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index > size()</code>).
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		return add(size, toAdd);
	}

	/**
	 * Appends all of the elements in the specified 
	 * <code>java.utilCollection</code> to the end of
	 * this list, in the order that they are returned by the specified
	 * collection's <code>Iterator</code>. The behaviour of this operation
	 * is unspecified if the specified collection is modified while the
	 * operation is in progress.  (Note that this will occur if the
	 * specified collection is this list, and it's nonempty.)
	 * 
	 * @param toAdd
	 * 			The new sub list to be added.
	 * @return true
	 * 			If the operation is successful.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < toAdd.size(); i++) {
			this.add(toAdd.get(i));
		}
		return true;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * 			Index of element to return.
	 * @return The element at the specified position in this list.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		return this.array[index];
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * Returns the element that was removed from the list.
	 * 
	 * @param index
	 * 			The index of the element to remove.
	 * @return The removed element.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		E itemRemove = this.array[index];
		for (int i = index; i < this.size() - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
		size--;
		this.array[this.size() + 1] = null;
		return itemRemove;
	}

	/**
	 * Removes the first occurrence in this list of the specified element. If
	 * this list does not contain the element, it is unchanged. More formally,
	 * removes the element with the lowest index <code>i</code> such that
	 * <code>o.equals(get(i))</code> (if such an element exists).
	 * 
	 * @param toRemove
	 * 			The element to be removed from this list.
	 * @return The element which is being removed, or null if the list does
	 * 			not contain the element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the 
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}
		for (int i =0; i < this.size(); i++) {
			if (this.array[i].equals(toRemove)) {
				return this.remove(i);
			}
		}
		return null;
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 * 			The index of the element to replace.
	 * @param toChange
	 * 			Element to be stored at the specified position.
	 * @return The element previously at the specified position.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the 
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		E elemRemoved = this.array[index];
		this.array[index] = toChange;
		return elemRemoved;
	}

	/**
	 * Returns <code>true</code> if this list contains no elements.
	 * 
	 * @return <code>true</code> if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return this.get(0) == null ;
	}

	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one 
	 * element <code>e</code> such that <code>toFind.equals(e)</code>.
	 * 
	 * @param toFind
	 * 			The element whose presence in this list is to be tested.
	 * @return <code>true</code> if this list contains the specified element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		for (int i =0; i < this.size(); i++) {
			if (this.get(i).equals(toFind)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the
	 * <code>java.util.Collection.toArray(Object [])</code> method.
	 * 
	 * @param toHold
	 *			The array into which the elements of this list are to be
	 * 			stored, if it is big enough; otherwise, a new array of the
	 * 			same runtime type is allocated for this purpose.
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException
	 * 			If the specified array is <code>null</code>.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		}
		if (toHold.length > this.size()) {
			toHold = (E[]) new Object[this.size()];
		}
		for (int i =0; i < this.size(); i++) {
			if (this.array[i] != null) {
				toHold[i] = array[i];
			}
		}
		return toHold;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the 
	 * <code>java.util.Collection.toArray()</code> method.
	 * 
	 * @return An array containing all of the elements in this list in proper
	 * 			sequence.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
		E[] returnArray = (E[]) new Object[this.size()];
		for (int i = 0; i < this.size(); i++) {
			if (this.array[i] != null) {
				returnArray[i] = array[i];
			}
		}
		return returnArray;
	}

	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence.
	 * 			NB: The return is of type 
	 * 			<code>linearUtilities.Iterator<E></code>,
	 * 			not <code>java.util.Iterator</code>.
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator();
	}
	
	/*******************************INNER CLASSES*********************************/
	private class MyArrayListIterator implements Iterator<E>{
		
		//Attributes
		private int pos;
		private E[] copyOfElements;

		//Constructors
		@SuppressWarnings("unchecked")
		public MyArrayListIterator()
		{
			copyOfElements = (E[]) (new Object[size()]);
			pos = 0;
			for(int i = 0; i < size; i++)
			{
				copyOfElements[i] = get(i);
			}
		}

		/**
		 * Returns <code>true</code> if the iteration has more elements. 
		 * (In other words, returns <code>true</code> if <code>next()</code> 
		 * would return an element rather than throwing an exception.)
		 * 
		 * @return <code>true</code> if the iterator has more elements.
		 */
		@Override
		public boolean hasNext()
		{
			return array[pos] != null;
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @return The next element in the iteration.
		 * @throws NoSuchElementException
		 * 			If the iteration has no more elements.
		 */
		@Override
		public E next() throws NoSuchElementException
		{
			
			if (array[pos] == null) {
				throw new NoSuchElementException();
			}
			return array[pos++];
		}
	}

}
