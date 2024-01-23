package implementation;

import java.util.Arrays;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

/**
 * Implementation of a doubly linked list.
 * 
 * @param <E> the type of elements held in this collection
 */
public class MyDLL<E> implements ListADT<E>{

	/**
	 * Auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -3107834576999410317L;

	//Attributes
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;
	private int size;
	
	/**
     * Constructs an empty list.
     */
	public MyDLL() {
		size = 0;
	}
	
	/**
     * Returns the number of elements in this list.
     * 
     * @return the number of elements in this list
     */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
     * Empties/ clears the list 
     * by setting head and tail to null and the other nodes are garbage collected.
     */
	@Override
	public void clear() {
		head = tail = null;
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
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		
		boolean status = false;
		if (toAdd == null) {
			throw new NullPointerException("Cannot store a null");
		}
		if(index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("Index is outside current list boundary '"+index+"'");
		}
		if (!this.isEmpty()) {
			if(this.size() == 1 && index == 0){
				head = new MyDLLNode<E>(toAdd, tail, null);
				size++;
				status = true;
			}
			else if(index == 0) {
				MyDLLNode<E> after = head;
				head = new MyDLLNode<E>(toAdd, after, null);
				size++;
				status = true;
			}
			else if(index == size) {
				MyDLLNode<E> before = tail;
				tail = new MyDLLNode<E>(toAdd, null, before);
				before.next = tail;
				size++;
				status = true;
			}
			else {
				MyDLLNode<E> before = head;
				MyDLLNode<E> after = head.next;
				for (int i = 0; i < index - 1; i++) {
					before = before.next;
					after = after.next;
				}
				MyDLLNode<E> insert = new MyDLLNode<E>(toAdd, after, before);
				before.next = insert;
				after.prev = insert;
				size++;
				status = true;
			}
		}
		else {
			head = new MyDLLNode<E>(toAdd, null, null);
			tail = head;
			size++;
			status = true;
		}
		return status;
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
		return add(this.size(), toAdd);
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
		if(index < 0 || index > this.size())
		{
			throw new IndexOutOfBoundsException(
				"The index is outside the bounds of the current list : index = " + index);
		}

		if(!isEmpty())
		{
			MyDLLNode<E> curr = head;
			for(int i = 0; i < index; i++)
			{
				curr = curr.next;
			}
			return curr.getData();
		}
		else
		{
			throw new IndexOutOfBoundsException("list is empty.");
		}
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
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException(
					"The index is outside the bounds of the current list : index = " + index);
		}
		if (!this.isEmpty()) {
			if (index == 0) {
				MyDLLNode<E> del = head;
				head = head.next;
				head.prev = null;
				size--;
				return del.getData();
			}
			else if(index + 1 == this.size()) {
				
				MyDLLNode<E> del = tail;
				tail = tail.prev;
				tail.next = null;
				size--;
				return del.getData();
				
			}
			else {
				MyDLLNode<E> del = head.next;
				MyDLLNode<E> before = head;
				for(int i = 1 ; i < index; i++) {
					del = del.next;
					before = before.next;
				}
				E deleted = del.getData();
				before.next = del.next;
				del.next.prev = before;
				size--;
				return deleted;
			}
		}
		
		return null;
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
		MyDLLNode<E> curr = head;
		for (int i = 0; i < this.size(); i++) {
			if (curr.getData().equals(toRemove)) {
				E deleted = curr.getData();
				this.remove(i);
				return deleted;
			}
			curr = curr.next;
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
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		E deleted = curr.getData();
		this.remove(index);
		this.add(index, toChange);
		return deleted;
	}

	/**
	 * Returns <code>true</code> if this list contains no elements.
	 * 
	 * @return <code>true</code> if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return head == null;
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
		MyDLLNode<E> curr = head;
		for (int i = 0; i < this.size(); i++) {
			if (curr.getData().equals(toFind)) {
				return true;
			}
			curr = curr.next;
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
		if (toHold.length < this.size()) {
			toHold = (E[]) new Object[this.size()];
		}
		for (int i = 0; i < this.size(); i++) {
			toHold[i] = this.get(i);
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
	@Override
	public Object[] toArray() {
		Object[] array = new Object[this.size()];
		for (int i = 0; i < this.size(); i++) {
			array[i] = this.get(i);
		}
		return array;
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

		return new MyDLLIterator();
	}

	/*******************************INNER CLASSES*********************************/
	private class MyDLLIterator implements Iterator<E>{
		
		//Attributes
		private int pos;
		private E[] copyOfElements;

		//Constructor
		@SuppressWarnings("unchecked")
		public MyDLLIterator()
		{
			pos = 0;
			copyOfElements = (E[]) (new Object[size()]);
			MyDLLNode<E> curr = head;
			for(int i = 0; i < size; i++){
				copyOfElements[i] = curr.getData();
				curr = curr.next;
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
			return pos < copyOfElements.length;
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
			E toReturn = copyOfElements[pos];
			pos++;
			return toReturn;
		}
	}
	
	 /**
     * Node class for doubly linked list.
     * 
     * @param <E> the type of element held in the node
     */
	private class MyDLLNode<E>{
		private E data;
		private MyDLLNode<E> next;
		private MyDLLNode<E> prev;
		
		 /**
         * Constructs a node with the specified data.
         * 
         * @param data the data stored in the node
         */
		public MyDLLNode(E data) {
			this.data = data;
		}
		
		/**
         * Constructs a node with specified data, next node, and previous node.
         * 
         * @param data the data stored in the node
         * @param next the next node in the list
         * @param prev the previous node in the list
         */
		public MyDLLNode(E data, MyDLLNode<E> next, MyDLLNode<E> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		 /**
         * Returns the data in this node.
         * 
         * @return the data stored in the node
         */
		public E getData()
		{
			return this.data;
		}
		
		/**
         * Returns the String representation of the node.
         * 
         * @return the data, next and prev references in a String format.
         */
		@Override
		public String toString() {
			return "MyDLLNode [data=" + data + ", next=" + next + ", prev=" + prev + "]";
		}
		
	}
	
}
