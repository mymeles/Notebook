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

	public SortedList() {
		this.size = 0;
		this.front = null;
	}

	/**
	 * Adds the element to the list in sorted order.
	 * 
	 * @param element element to add
	 * @throws NullPointerException     if element is null
	 * @throws IllegalArgumentException if element cannot be added
	 */
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element");
		} else if (contains(element)) {
			throw new IllegalArgumentException("Cannot add duplicate element");
		}

		ListNode insert = new ListNode(element, null);

		if (front == null || front.data.compareTo(element) > 0) {
			insert.next = front;

		}
		ListNode current = front;
		ListNode previous = null;

		while (current != null) {
			if (current.data.compareTo(element) > 0) {
				previous.next = insert;
				insert.next = current;

			}
			previous = current;
			current = current.next;

		}

		previous.next = insert;
		size++;
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
		checkIndex(idx);
		E returnElement = null;
//			if (idx == 0 ) {
//				if(size == 1) {
//					returnElement = front.data; // the returned element is the only element in the list 
//					front = null; // indicating there are no other elements 
//				}
//				else {
//					returnElement = front.data; // the return element is the element at front 
//					front = front.next; // then the front element is the next element
//				}
//			}
//			
		if (idx == 0) {
			returnElement = front.data; // the returned element is the only element in the list
			if (front.next == null) {
				front = null;
			} else {
				front = front.next; // then the front element is the next element
			}

		} else {
			ListNode current = front;
			for (int i = 0; i < idx - 1; i++) {
				current = current.next; // stops at the refrence before the element we want to remove
			}
			returnElement = current.next.data; // the data at idx
			current.next = current.next.next;
		}
		size--;
		return returnElement;

	}

	/**
	 * A method that checks the index of an element
	 * 
	 * @param idx is an integer
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= this.size())
			throw new IndexOutOfBoundsException("Invalid index");

	}

	/**
	 * Returns true if the element is in the list.
	 * 
	 * @param element element to search for
	 * @return true if element is found
	 */
	public boolean contains(E element) {
		if (element == null) {
			ListNode current = front;
			while (current != null) {
				if (current.data.equals(element)) {
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}

	/**
	 * Returns the element at the given index.
	 * 
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	public E get(int idx) {
		checkIndex(idx);
		ListNode current = front;
		for (int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	public int size() {
		return size;
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