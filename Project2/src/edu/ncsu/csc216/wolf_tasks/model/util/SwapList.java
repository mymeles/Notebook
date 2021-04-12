package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * A cusstom Array List that implements an interface called ISwapList
 * @author Meles Meles
 * @author Helen Solomon
 *
 * @param <E> The type of object being stored in the given list
 */
public class SwapList<E> implements ISwapList<E>{

	/** Default capacity for the array list */
	private int INITIAL_CAPACITY = 10;

	/** Array used to store values within the Array List */
	private E [] list;

	/** The current size of the array */
	private int size;

	/**
	 * Constructs a new empty generic list with a size of zero when called
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}

	/**
	 * Adds the element to the end of the list.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 */
	public void add(E element) {
    	if (size == list.length) {
    		checkCapacity(size);
    	}

		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		
    	if (size == 0) {
    		list[0] = element;
    	} else {
    		list[size] = element;
    	}

		size++;
	}

	/**
	 * Checks to make sure the list length doesn't exceed the capacity, and if it does, it doubles the length of the list
	 * 
	 * @param idx is an integer
	 */
	@SuppressWarnings("unchecked")
	private void checkCapacity(int size) {
		E[] bigList = (E[]) new Object[list.length * 2];
		for (int i = 0; i < list.length; i++) {
			bigList[i] = list[i];
		}
		list = bigList;
	}


	/**
	 * Returns the element from the given index.  The element is
	 * removed from the list.
	 * @param idx index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public E remove(int idx) {
		//check that index is valid, throws exception if not
		checkIndex(idx);
		//remove item from list
		E deleted = list[idx];
		for (int i = idx; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		//return the deleted one
		return deleted;
	}

	/**
	 * A method that checks the index of an element
	 * 
	 * @param idx is an integer
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

	/**
	 * 
	 * Moves the element at the given index to index-1.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move up
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveUp(int idx) {
		checkIndex(idx);
		//if idx is at front, don't change list
		if (idx == 0) {
			return;
		}
		//store value of element at front of current element
		E temp = list[idx - 1];
		//set the element at idx-1 to the current element
		list[idx - 1] = list[idx];
		//set the current element value to the one that was in front
		list[idx] = temp;
	}


	/**
	 * Moves the element at the given index to index+1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveDown(int idx) {
		checkIndex(idx);
		//if idx is at end, don't change list
		if (idx == size - 1) {
			return;
		}
		//store value of element at back of current element
		E temp = list[idx + 1]; // list [idx +1]
		//set the element at idx+1 to the current element
		list[idx + 1] = list[idx]; // set(idx+1, list[idx])
		//set the current element value to the one that was in front
		list[idx] = temp; // set(idx, temp)
	}

	/**
	 * Moves the element at the given index to index 0.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move to the front
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveToFront(int idx) {
		checkIndex(idx);
		//if idx is at front, don't change list
		if (idx == 0) {
			return;
		}
		//store value of element at front of list
		E temp = list[idx];
		for (int i = idx; i > 0; i--) {
			list[i] = list[i-1];			
		}
		//set current element to the first position
		list[0] = temp;
	}
	
	/**
	 * Moves the element at the given index to size-1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move to the back
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveToBack(int idx) {
		checkIndex(idx);
		//if idx is at end, don't change list
		if (idx == size - 1) {
			return;
		}
		//store value of element at back of list
		E temp = list[idx];
		for (int i = 0; i < size; i++) {
			list[i] = list[i+1];
		}
		//set current element to the last position
		list[size - 1] = temp;
	}
	
	/**
	 * Returns the element at the given index.
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public E get(int idx) {
		checkIndex(idx);
		return list[idx];
	}
	
	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	public int size() {
		return size;
	}


}