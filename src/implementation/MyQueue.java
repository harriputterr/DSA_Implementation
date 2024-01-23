package implementation;

import utilities.QueueADT;
import utilities.Iterator;
import exceptions.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E> {
	
	private static final long serialVersionUID = 1905770334261071557L;

	private MyDLL<E> list;

    public MyQueue() {
        this.list = new MyDLL<>();
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot enqueue null");
        }
        list.add(toAdd);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {

   
            throw new EmptyQueueException("Queue is Empty");
        }
        return list.remove(0);
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {

            throw new EmptyQueueException("Queue is empty");

        }
        return list.get(0);
    }

    @Override
    public void dequeueAll() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public boolean equals(QueueADT<E> that) {
        if (this.size() != that.size()) {
            return false;
        }
        Iterator<E> thisIter = this.iterator();
        Iterator<E> thatIter = that.iterator();
        while (thisIter.hasNext() && thatIter.hasNext()) {
            if (!thisIter.next().equals(thatIter.next())) {
                return false;
            }
        }
        return !thisIter.hasNext() && !thatIter.hasNext();
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
    public boolean isFull() {
        // assumes MyDLL implementation does not have a maximum capacity.
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }
}

