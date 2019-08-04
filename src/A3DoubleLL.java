/*
 * Complete the swap(int index) method
 * No other methods/variables should be added/modified
 */
public class A3DoubleLL<E> {
	/*
	 * Grading:
	 * Swapped nodes without modifying values - 2pt
	 * Works for all special cases - 1pt
	 */
	public void swap(int index) {
		//swap the nodes at index and index+1
		//change the next/prev connections, do not modify the values
		//do not use delete/remove/insert/add to help with this process
		//make sure to account for all special cases

		if(index >= 0 && index < count) {//valid index
			Node current = start;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}

			if(index != 0 && index != count - 2) {
				Node next = current.next.next;
				current.next.next = current;
				current.prev.next = current.next;
				current.next = next;
				current.next.prev = current;
				current.prev.next.prev = current.prev;
				current.prev = current.prev.next;
			}else if (index == 0){
				Node next = current.next.next;
				start = current.next;
				current.next = next;

				current.next.prev = current;
				current.prev = start;
				start.prev = null;
			}else if (index == count - 2) {
				System.out.println(current.value + ", " + count);

				current.next = null;
				end.next = current;

				current.prev.next = end;

				end.prev = current.prev;
				current.prev = end;

				end = current;
			}

		}
	}

	private Node start, end;
	private int count;
	public A3DoubleLL() {
		start = end = null;
		count = 0;
	}
	public String printList() {
		String output = "";
		Node current = start;
		while(current != null) {
			output += current.value + ",";
			current = current.next;
		}
		return output;
	}
	public String printListRev() {
		String output = "";
		Node current = end;
		while(current != null) {
			output += current.value + ",";
			current = current.prev;
		}
		return output;
	}
	public void add(E val) {
		Node newItem = new Node(val);
		if(start == null) {
			start = newItem;
			end = start;
			count = 1;
		} else {
			end.next = newItem;
			newItem.prev = end;
			end = newItem;
			count++;
		}
	}
	public void insert(E val, int index) {
		if(index < 0) {//fix invalid index
			index = 0;
		}
		if(index >= count) {//goes in last position
			this.add(val);
		} else {
			Node newItem = new Node(val);
			if(index == 0) {//goes in first position
				newItem.next = start;
				start.prev = newItem;
				start = newItem;
			} else {//goes in middle
				Node current = start;
				for(int i = 1; i < index; i++) {
					current = current.next;
				}
				newItem.next = current.next;
				newItem.prev = current;
				current.next.prev = newItem;
				current.next = newItem;
			}
			count++;
		}
	}
	public void delete(int index) {
		if(index >= 0 && index < count) {//valid index
			if(index == 0) {//remove first
				start = start.next;
				if(start != null) {//as long as there was an item next in list
					start.prev = null;
				} else {//if only item was removed
					end = null;
				}
			} else if(index == count-1) {//remove last item
				end = end.prev;
				end.next = null;
			} else {//remove middle item
				Node current = start;
				for(int i = 1; i < index; i++) {
					current = current.next;
				}
				current.next = current.next.next;
				current.next.prev = current;
			}
			count--;
		}
	}
	public E get(int index) {
		if(index >= 0 && index < count) {//valid index
			Node current = start;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.value;
		}
		return null;
	}
	public String toString() {
		return this.printList();
	}
	private class Node {
		E value;
		Node next, prev;
		public Node(E v) {
			value = v;
			next = prev = null;
		}
	}
}
