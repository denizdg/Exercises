/*
 * © Programming Interviews Exposed 
 * By John Mongan, Eric Giguere, Noah Kindler
 * Third Edition 
 * 
 * Page 53, List Flattening problem
 * 
 */

public class ListFlattening {
	
	
	/*Algorithm:
	 *  Start at the beginning of the first level
	 *  While you are not at the end of the first level
	 *  	If the current node has a child
	 *  		Append the child to the end of the first level
	 *  		Update the tail pointer
	 *  	Advance to next node
	 * */

	
	class Node{
		Node next;
		Node prev;
		Node child;
		int data;
	}
	
	 public void flattenList(Node head){
		
		Node curr = head;
		Node tail = head;
		
		while(tail.next != null){ // Find the tail node
			tail = tail.next;
		}
		
		while(curr != null){
			if(curr.child != null)
				append(curr.child, tail);
			curr = curr.next;
		}
		
	}
	
	private void append(Node child, Node tail){
		
		Node curr = new Node();
		
		// append the child to the end of the list
		tail.next = child;
		child.prev = tail;
		
		// Find the new tail - end of the new child list
		curr = child;
		while(curr.next != null){
			curr = curr.next; //get the last node of the child list
		}
		
		tail = curr; // update the tail
		
	}
}
