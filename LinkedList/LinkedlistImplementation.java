package LinkedList;
import java.util.ArrayList;
import java.util.LinkedList;
public class LinkedlistImplementation {
	Node head;
	public void insert(int data) {
		Node node = new Node(data);
		if(head==null) {
			head=node;
		}
		else
		{
			Node n = head;
			while(n.next!=null) {
				n= n.next;
			}
			n.next=node;
			
		}
	}
	
	public void print() {
		Node node = head;
		while(node.next!=null) {
			System.out.println(node.data);
			node= node.next;
		}
		System.out.println(node.data);
	}
	public int Lengthiteratively(){
		int c=0;
		Node node = head;
		while(node.next!=null) {
	 		node= node.next;
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
