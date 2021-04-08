package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * 
 * @author Meles Meles
 * @author Helen Solomon
 * 
 * @param <E> The generic object type stored in the list
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** The number of ListNodes in the sortedList */
	private int size;

	/** the front node of the SortedList */
	private ListNode front;

	/**
	 * Adds the element to the list in sorted order.
	 * 
	 * @param element element to add
	 * @throws NullPointerException     if element is null
	 * @throws IllegalArgumentException if element cannot be added
	 */
	public void add(E element) {

	}

	/**
	 * Returns the element from the given index. The element is removed from the
	 * list.
	 * 
	 * @param idx index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
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
	 * Returns true if the element is in the list.
	 * 
	 * @param element element to search for
	 * @return true if element is found
	 */
	public boolean contains(E element) {
		return null == null;
	}

	/**
	 * Returns the element at the given index.
	 * 
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	public E get(int idx) {
		return null;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	public int size() {
		return 0;
	}

	/**
	 * Nodes to construct a list in the LinkedList
	 * 
	 * @author Meles Meles
	 * @author Helen Solomon
	 *
	 */
	private class ListNode {
		/** The data being stored in a single node */
		E data;

		/** The net node in the in the link */
		public ListNode next;

		/**
		 * Constructs a ListNode with the given data and reference
		 * 
		 * @param data The object stored at the given list node
		 * @param next The next ListNode in the in the SortedList
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}

}