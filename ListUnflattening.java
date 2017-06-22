/*
 * © Programming Interviews Exposed 
 * By John Mongan, Eric Giguere, Noah Kindler
 * Third Edition 
 * 
 * Page 56, List Unflattening problem
 * 
 */


/*	Algorithm:
 *  While not at the end
 *  	If current node has a child from its previous node
 *  		Separate the child from its previous node
 *  		Explore path beginning with the child
 *  	Go onto the next node
 * */

public class ListUnflattening {
	
	// unflattenList wraps the recursive function and updates the tail pointer
	public void unflattenList(Node head){
		
		Node curr = new Node();
		Node tail = new Node();
		
		
		exploreAndSeparate(head);
		
		// find the tail of the list
		while(curr.next != null){
			curr = curr.next;
		}
		
		tail = curr;
		
	}

	// exploreAndSeparate actually does the recursion and separation
	private void exploreAndSeparate(Node childHead) {
		
		Node curr = childHead;
		
		while(curr != null){
			if(curr.child.prev != null){
				//terminates the child list before the child
				curr.child.prev.next = null;
				//starts the child list beginning with the child
				curr.child.prev =  null;
				exploreAndSeparate(curr.child);
			}
			
			curr = curr.next;
		}
		
	}

}
