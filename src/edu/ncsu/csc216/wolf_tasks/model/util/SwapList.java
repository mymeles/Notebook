package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * A cusstom Array List that impements an interface called ISwapList
 * @author Meles Meles
 * @author Helen Solomon
 *
 * @param <E> The type of object being stored in the given list
 */
public class SwapList<E> implements ISwapList<E>{

	/** Default size for the array list */
	private int INITIAL_CAPACITY = 10;

	/** Array used to store values within the Array List */
	private E [] list;

	/** The current size of the array */
	private int size;

	/**
	 * Constructs a new empty generic list with a size of zero when called
	 */
	public SwapList() {

	}

	/**
	 * Adds the element to the end of the list.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element cannot be added 
	 */
	public void add(E element) {

	}

	/**
	 * A method that checks the capacity of the array size
	 * 
	 * @param idx is an integer
	 */
	private void checkCapacity(int size) {

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
		return null;

	}

	/**
	 * A method that checks the index of an element
	 * 
	 * @param idx is an integer
	 */
	private void checkIndex(int idx) {

	}

	/**
	 * Moves the element at the given index to index-1.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move up
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveUp(int idx) {

	}


	/**
	 * Moves the element at the given index to index+1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveDown(int idx) {

	}

	/**
	 * Moves the element at the given index to index 0.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move to the front
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveToFront(int idx) {

	}
	
	/**
	 * Moves the element at the given index to size-1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move to the back
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveToBack(int idx) {

	}
	
	/**
	 * Returns the element at the given index.
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public E get(int idx) {
		return null;
	}
	
	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	public int size() {
		return 0;
	}


}
