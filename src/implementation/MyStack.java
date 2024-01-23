package implementation;

import java.util.EmptyStackException;

import implementation.MyArrayList;
import utilities.Iterator;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8740012719688748526L;
	private MyArrayList<E> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null element to the stack");
        }
        list.add(toAdd);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {
    	 return list.size() == 0;
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return list.toArray(holder);
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return list.contains(toFind);
    }


    @Override
    public Iterator<E> iterator() {
    	 return list.iterator();
    }
    
    @Override
    public boolean equals(StackADT<E> that) {
        if (this == that) {
            return true;
        }
        if (that == null || this.size() != that.size()) {
            return false;
        }
        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();
        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            if (!thisIterator.next().equals(thatIterator.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return list.size();
    }

	@Override
	public int search(E toFind) {
		// TODO Auto-generated method stub
		Iterator<E> it = this.iterator();
        int index = 0;
        while (it.hasNext()) {
            if (it.next().equals(toFind)) {
                return index;
            }
            index++;
        }
        return -1; // Element not found
	}

}
