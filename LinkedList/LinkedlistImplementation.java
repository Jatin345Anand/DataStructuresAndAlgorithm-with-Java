package LinkedList;
import java.util.ArrayList;
import java.util.LinkedList;
public class LinkedlistImplementation {
	LinkedListNode head;
	public void insert(int data) {
		LinkedListNode LinkedListNode = new LinkedListNode(data);
		if(head==null) {
			head=LinkedListNode;
		}
		else
		{
			LinkedListNode n = head;
			while(n.next!=null) {
				n= n.next;
			}
			n.next=LinkedListNode;
			
		}
	}
	
	public void print() {
		LinkedListNode LinkedListNode = head;
		while(LinkedListNode.next!=null) {
			System.out.println(LinkedListNode.data);
			LinkedListNode= LinkedListNode.next;
		}
		System.out.println(LinkedListNode.data);
	}
	public int Lengthiteratively(){
		int c=0;
		LinkedListNode LinkedListNode = head;
		while(LinkedListNode.next!=null) {
	 		LinkedListNode= LinkedListNode.next;
			c++;
		}
		c++;
		return c;
	}
	public static void main(String[] args) {
//	LinkedList<Integer> list = new LinkedList<>();
//	list.add(12);
//	list.add(2, 13);
	LinkedlistImplementation list =new LinkedlistImplementation();
	//System.out.println("Enter the elements of Linked List...");
//	ArrayList<Integer> AL = new ArrayList<>();
	list.insert(12);
	list.insert(13);
	System.out.println("List is....");
	list.print();
	System.out.println("Lenght of list is "+list.Lengthiteratively());
}
}
