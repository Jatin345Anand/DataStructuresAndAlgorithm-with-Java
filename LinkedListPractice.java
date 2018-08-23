package LinkedList;

import java.util.Scanner;

public class LinkedListPractice {

	public static Node CreateLinkedList() {
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();
		// here we take data integer till -1 and Take memory using new Node(data)...
		Node head=null;
		Node tail=null;
		while(data !=-1) {
			Node node = new Node<>(data);
			if(head ==null) {
				head=node;
				tail=node;
			}
			else {
				tail.next=node;
				tail=tail.next;
			}
			// here if and else start Linked list with head node and tail node increment till -1.
			// if LL = 1 2 3 -1
			// then head point to 1 , head.next point to 2 , head.next.next point to 3 Or tail is also point to last element of LL means 3 ...
			// tali.next point to null....
			data = scanner.nextInt();
		}
//		System.out.println("O W "+head.data);
//		System.out.println("O W "+head.next.data);
//		System.out.println("O W "+head.next.next.data);
//		System.out.println("O W "+tail.data);
System.out.println(tail.next);
		return head;
	}
	public static void PrintLL(Node head) {
		System.out.println();
		if(head==null) {
			return;
		}
		while(head!=null) {
			System.out.print(head.data +" ");
			head = head.next;
		}
		
		System.out.println();
	}
	public static int LenghtLLItretatively(Node head) {
		int c=0;
		if(head==null) {
			return 0;
		}
		while(head!=null) {
			head=head.next;
			c++;
		}
		return c;
	}
	public static int FindNodeinLLItreratively(Node head,int n) {
		int index = 0;
		int ans=-1;
		while(head!=null) {
			head = head.next;
			System.out.println(n);
			index++; 
			if(head.data==n) {
				System.out.println("Y");
				break;
			}
			System.out.println("End");
		}	
//		try {
//			
//		} catch (Exception e) {
//	           e.printStackTrace(); 
//		}
		if(index>0) {
			ans=index;
		}
//		else if(index==0) {
//			ans =-1;
//		}
		
		return ans;
	}
	public static int PrintithPositionNode(Node head,int i) {
		int lengthLL = LenghtLLItretatively(head);
		if(i>lengthLL) {
			return -1;
		}
		int c=0;
		int ans=-1;
		while(head!=null) {
			head=head.next;
			c++;
			if(c==i) {
				ans=head.data;
			}
		}
		return ans;
	}
	public static Node AppendLastNtoFirst(Node head) {
		Node head1 =null;
		return head1;
	}
	public static Node ReverseRecursive(Node head) {
//		 System.out.println(head);
//		 System.out.println(head.data);
//		 System.out.println(head.next);
//		 System.out.println(head.next.data);
//		 System.out.println(head.next.next);
//		 System.out.println(head.next.next.data);
         System.out.println("Run..");
		if(head.next==null) {
			System.out.println("Y");
			return head;
		}
		Node finalHead = ReverseRecursive(head.next);
		System.out.println(finalHead.data);
		head.next.next=head;
		System.out.println("Change =  "+head.next.next.data);
		head.next=null;
		System.out.println(head.next);
		return finalHead;  
	}
	public static void ReverseRecursive2(Node head) {
//		 System.out.println(head);
//		 System.out.println(head.data);
//		 System.out.println(head.next);
//		 System.out.println(head.next.data);
//		 System.out.println(head.next.next);
//		 System.out.println(head.next.next.data);
		 //System.out.println(head.data);
		
			if(head==null) {
//				System.out.println("N");
				return ;
//				System.out.println("N1");
			}
//			System.out.println(head.data);
			ReverseRecursive2(head.next);

//			System.out.println("A"+head.data);
			System.out.print(head.data+" ");
	}
	public static void ReverseItaretively(Node head) {
		
		
		
	}
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the elements of Linked list....");
	 Node head= CreateLinkedList();
	 PrintLL(head);
	  System.out.println("Length of Linked List...");
	  System.out.println(LenghtLLItretatively(head));
//	  System.out.println("Enter the number to be search in linked list...");
//	  int n1 = scanner.nextInt() ;
//	  System.out.println("Your Searched Number's index is "+FindNodeinLLItreratively(head, n1));
//      System.out.println("Enter the ith position...");
//      int i1 = scanner.nextInt();
//      System.out.println("Your ith Position Data is "+PrintithPositionNode(head, i1));
	  //ReverseItaretively(head);
//	  ReverseRecursive(head);
//	  System.out.println();
//	  ReverseRecursive2(head);
//	  System.out.println();
	 // PrintLL(ReverseRecursive(head));
	}
}
