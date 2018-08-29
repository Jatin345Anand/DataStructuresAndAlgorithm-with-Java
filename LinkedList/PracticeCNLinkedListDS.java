package LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class PracticeCNLinkedListDS {
	public static void PrintArray(int[] A) {
		System.out.println("Array is ...");
		for(int i:A) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static Node<Integer> FindNodefromKthNodeReverseLL(Node<Integer> head,int k,int i) {
		Node NewHead = null;
		int index =0,c=0;
		int[] ALL = new int[k];
		while(index!=k && head!=null) {
			System.out.println(head.data);
//			NewHead =head;
//			NewHead = NewHead.next;
	//		NewHead = new Node<>(head.data);
			ALL[c++] = head.data;
			index++;
			head = head.next;
		}
		PrintArray(ALL);
		System.out.println("LL using Array is...");
		PrintLL(CreateLinkedList(ALL));
		PrintLL(ReverseRecursive(CreateLinkedList(ALL)));
		System.out.println("Node element is "+PrintithPositionNode(ReverseRecursive(CreateLinkedList(ALL)), i));

		NewHead = new Node<>(PrintithPositionNode(ReverseRecursive(CreateLinkedList(ALL)), i));
		return NewHead;
	}
	public static Node<Integer> FindNode(Node<Integer> head) {
		   while(head.data!=-1) {
			   System.out.println(head.data);
			   head = head.next;
		   }
			return null;
		}
	public static Node ReverseRecursive(Node head) {
		 
 		if(head.next==null) {
 			return head;
		}
		Node finalHead = ReverseRecursive(head.next);
 		head.next.next=head;
 		head.next=null;
 		return finalHead;  
	}

	public static Node CreateLinkedList() {
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();
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
		 		data = scanner.nextInt();
		}
 		return head;
	}
	public static Node CreateLinkedList(int A[]) {
		Scanner scanner = new Scanner(System.in);
		//int data = scanner.nextInt();
		int i=0;
		Node head=null;
		Node tail=null;
		while(i< A.length) {
			Node node = new Node<>(A[i]);
			if(head ==null) {
				head=node;
				tail=node;
			}
			else {
				tail.next=node;
				tail=tail.next;
			}
		 	//	data = scanner.nextInt();
		 		i++;
		}
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
	public static int FindNodeinLLItreratively(Node head,int n) {
		int index = 0;
		int ans=-1;
		while(head!=null) {
			head = head.next;
	 		index++; 
			if(head.data==n) {
	 			break;
			}
	 	}	
       	if(index>0) {
			ans=index;
		}
 		return ans;
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
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the elements of linked list.....");
		ArrayList<Integer> AL = new ArrayList<>();
        AL.add(scanner.nextInt());
        System.out.println("AL is ..");
        System.out.println(AL);
//	  Node head = CreateLinkedList();
//	  PrintLL(head);
//	  System.out.println("Enter the value of k...");
//	  int k =scanner.nextInt();
//	  System.out.println("Enter the value of i...");
//	  int i =scanner.nextInt();
//	  System.out.println(FindNodefromKthNodeReverseLL(head,k,i));
//	  PrintLL(FindNodefromKthNodeReverseLL(head,k,i));
	  scanner.close();
}
}
