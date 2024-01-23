package treeImplementation;
import utilities.BSTreeADT;
import utilities.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Binary Search Tree implementation.
 */
public  class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
    private BSTreeNode<E> root;
    private int size;

    public BSTree() {
        root = null;
        size = 0;
    }
    
    /**
	 * The node at the root of the Binary Search Tree will be returned.
	 * @return node stored at the root of tree is returned or null if
	 * the tree is empty
	 */

    @Override
    public BSTreeNode<E> getRoot() {
        return root;
    }
    
    /**
	 * Determines the row height of the tree and returns that value as an
	 * integer value.
	 * @return the height of the tree.
	 */

    @Override
    public int getHeight() {
        return getHeightRecursive(root);
    }

    private int getHeightRecursive(BSTreeNode<E> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeightRecursive(node.getLeft()), getHeightRecursive(node.getRight()));
    }
    
    /**
	 * The number of elements currently stored in the tree is counted and
	 * the value is returned.
	 * @return number of elements currently stored in tree.
	 */

    @Override
    public int size() {
        return size;
    }
    
    /**
	 * Checks if the tree is currently empty.
	 * @return returns boolean true if the tree is empty otherwise false.
	 */

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
	 * Clears all elements currently stored in tree and makes the tree empty.
	 */

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    
    /**
	 * Checks the current tree to see if the element passed in is stored in
	 * the tree. If the element is found in the tree the method returns true
	 * and if the element is not in the tree the method returns false.
	 * @param entry the element to find in the tree
	 * @return returns boolean true if element is currently in the tree and
	 * false if the element is not found in the tree
 	 * @throws NullPointerException if the element being passed in is null
	 */

    @Override
    public boolean contains(E entry) throws NullPointerException {
        if (entry == null) {
            throw new NullPointerException("Search element cannot be null");
        }
        return search(entry) != null;
    }
    
    /**
	 * Retrieves a node from the tree given the object to search for.
	 * @param entry element object being searched
	 * @return the node with the element located in tree, null if not found
 	 * @throws NullPointerException if the element being passed in is null
 	 */

    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException {
        if (entry == null) {
            throw new NullPointerException("Search element cannot be null");
        }
        return searchRecursive(root, entry);
    }

    private BSTreeNode<E> searchRecursive(BSTreeNode<E> current, E entry) {
        if (current == null || current.getElement().equals(entry)) {
            return current;
        }
        if (entry.compareTo(current.getElement()) < 0) {
            return searchRecursive(current.getLeft(), entry);
        } else {
            return searchRecursive(current.getRight(), entry);
        }
    }
    
    /**
	 * Adds a new element to the tree according to the natural ordering
	 * established by the Comparable implementation.
	 * @param newEntry the element being added to the tree
	 * @return a boolean true if the element is added successfully else false
	 * @throws NullPointerException if the element being passed in is null
	 */

    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if (newEntry == null) {
            throw new NullPointerException("Cannot add null element to the tree");
        }
        if (contains(newEntry)) {
            return false;
        }
        root = addRecursive(root, newEntry);
        size++;
        return true;
    }

    private BSTreeNode<E> addRecursive(BSTreeNode<E> current, E entry) {
        if (current == null) {
            return new BSTreeNode<>(entry);
        }
        if (entry.compareTo(current.getElement()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), entry));
        } else if (entry.compareTo(current.getElement()) > 0) {
            current.setRight(addRecursive(current.getRight(), entry));
        }
        return current;
    }
    
    /**
	 * Removes the smallest element in the tree according to the natural 
	 * ordering established by the Comparable implementation.
	 * @return the removed element or null if the tree is empty
	 */

    @Override
    public BSTreeNode<E> removeMin() {
        if (root == null) {
            return null;
        }
        BSTreeNode<E> parent = null;
        BSTreeNode<E> current = root;
        while (current.getLeft() != null) {
            parent = current;
            current = current.getLeft();
        }
        if (parent != null) {
            parent.setLeft(current.getRight());
        } else {
            
            root = current.getRight();
        }
        size--;
        return current;
    }
    
    /**
	 * Removes the largest element in the tree according to the natural 
	 * ordering established by the Comparable implementation.
	 * @return the removed element or null if the tree is empty
	 */
    
    @Override
    public BSTreeNode<E> removeMax() {
        if (root == null) {
            return null;
        }
        BSTreeNode<E> parent = null;
        BSTreeNode<E> current = root;
        while (current.getRight() != null) {
            parent = current;
            current = current.getRight();
        }
        if (parent != null) {
            parent.setRight(current.getLeft());
        } else {
            
            root = current.getLeft();
        }
        size--;
        return current;
    }
    
    /**
	 * Generates an in-order iteration over the contents of the tree. Elements
	 * are in their natural order.
	 * @return an iterator with the elements in the natural order
	 */

    @Override
    public Iterator<E> inorderIterator() {
        return new Iterator<E>() {
            Stack<BSTreeNode<E>> stack = new Stack<>();
            BSTreeNode<E> current = root;

            {
                pushLeft(current);
            }

            private void pushLeft(BSTreeNode<E> node) {
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public E next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in iteration");
                }
                BSTreeNode<E> node = stack.pop();
                pushLeft(node.getRight());
                return node.getElement();
            }
        };
    }
    
    /**
	 * Generates a pre-order iteration over the contents of the tree. Elements
	 * are order in such a way as the root element is first.
	 * @return an iterator with the elements in a root element first order
	 */

    @Override
    public Iterator<E> preorderIterator() {
        return new Iterator<E>() {
            Stack<BSTreeNode<E>> stack = new Stack<>();

            {
                if (root != null) {
                    stack.push(root);
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public E next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in iteration");
                }
                BSTreeNode<E> node = stack.pop();
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                }
                if (node.getLeft() != null) {
                    stack.push(node.getLeft());
                }
                return node.getElement();
            }
        };
    }
    
    /**
	 * Generates a post-order iteration over the contents of the tree. Elements
	 * are order in such a way as the root element is last.
	 * @return an iterator with the elements in a root element last order
	 */
    
    @Override
    public Iterator<E> postorderIterator() {
        return new Iterator<E>() {
            Stack<BSTreeNode<E>> traversalStack = new Stack<>();
            Stack<BSTreeNode<E>> outputStack = new Stack<>();

            {
                if (root != null) {
                    traversalStack.push(root);
                    while (!traversalStack.isEmpty()) {
                        BSTreeNode<E> node = traversalStack.pop();
                        outputStack.push(node);
                        if (node.getLeft() != null) {
                            traversalStack.push(node.getLeft());
                        }
                        if (node.getRight() != null) {
                            traversalStack.push(node.getRight());
                        }
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return !outputStack.isEmpty();
            }

            @Override
            public E next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in iteration");
                }
                return outputStack.pop().getElement();
            }
        };
    }



}
