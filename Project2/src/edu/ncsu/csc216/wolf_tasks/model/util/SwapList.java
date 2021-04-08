package edu.ncsu.csc216.wolf_tasks.model.util;

import java.util.ArrayList;

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
	//private E [] list;
	private ArrayList<E> itemList;

	/** The current size of the array */
	private int size;

	/**
	 * Constructs a new empty generic list with a size of zero when called
	 */
	public SwapList() {
		itemList = new ArrayList<E>(INITIAL_CAPACITY);
	}

	/**
	 * Adds the element to the end of the list.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 */
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		this.checkCapacity(size);
		itemList.add(element);
		size++;
	}

	/**
	 * Checks to make sure the list length doesn't exceed the capacity, and if it does, it doubles the length of the list
	 * 
	 * @param idx is an integer
	 */
	private void checkCapacity(int size) {
		itemList.ensureCapacity(size);
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
		E deleted = itemList.get(idx);
		itemList.remove(idx);
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
		E temp = itemList.get(idx - 1);
		//set the element at idx-1 to the current element
		itemList.set(idx - 1, itemList.get(idx));
		//set the current element value to the one that was in front
		itemList.set(idx, temp);
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
		if (idx == itemList.size() - 1) {
			return;
		}
		//store value of element at back of current element
		E temp = itemList.get(idx + 1);
		//set the element at idx+1 to the current element
		itemList.set(idx + 1, itemList.get(idx));
		//set the current element value to the one that was in front
		itemList.set(idx, temp);
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
		E temp = itemList.get(idx);
		itemList.remove(idx);
		//set the element at idx-1 to the current element
		itemList.add(0, temp);
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
		//if idx is at front, don't change list
		if (idx == itemList.size() - 1) {
			return;
		}
		E temp = itemList.get(idx);
		itemList.remove(idx);
		itemList.add(itemList.size(), temp);
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
		return itemList.get(idx);
	}
	
	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	public int size() {
		return size;
	}


}