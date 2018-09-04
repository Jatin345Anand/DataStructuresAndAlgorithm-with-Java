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
	
	public static LinkedListNode<Integer> FindLinkedListNodefromKthLinkedListNodeReverseLL(LinkedListNode<Integer> head,int k,int i) {
		LinkedListNode NewHead = null;
		int index =0,c=0;
		int[] ALL = new int[k];
		while(index!=k && head!=null) {
			System.out.println(head.data);
//			NewHead =head;
//			NewHead = NewHead.next;
	//		NewHead = new LinkedListNode<>(head.data);
			ALL[c++] = head.data;
			index++;
			head = head.next;
		}
		PrintArray(ALL);
		System.out.println("LL using Array is...");
		PrintLL(CreateLinkedList(ALL));
		PrintLL(ReverseRecursive(CreateLinkedList(ALL)));
		System.out.println("LinkedListNode element is "+PrintithPositionLinkedListNode(ReverseRecursive(CreateLinkedList(ALL)), i));

		NewHead = new LinkedListNode<>(PrintithPositionLinkedListNode(ReverseRecursive(CreateLinkedList(ALL)), i));
		return NewHead;
	}
	public static LinkedListNode<Integer> FindLinkedListNode(LinkedListNode<Integer> head) {
		   while(head.data!=-1) {
			   System.out.println(head.data);
			   head = head.next;
		   }
			return null;
		}
	public static LinkedListNode ReverseRecursive(LinkedListNode head) {
		 
 		if(head.next==null) {
 			return head;
		}
		LinkedListNode finalHead = ReverseRecursive(head.next);
 		head.next.next=head;
 		head.next=null;
 		return finalHead;  
	}

	public static LinkedListNode CreateLinkedList() {
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();
		LinkedListNode head=null;
		LinkedListNode tail=null;
		while(data !=-1) {
			LinkedListNode LinkedListNode = new LinkedListNode<>(data);
			if(head ==null) {
				head=LinkedListNode;
				tail=LinkedListNode;
			}
			else {
				tail.next=LinkedListNode;
				tail=tail.next;
			}
		 		data = scanner.nextInt();
		}
 		return head;
	}
	public static LinkedListNode CreateLinkedList(int A[]) {
		Scanner scanner = new Scanner(System.in);
		//int data = scanner.nextInt();
		int i=0;
		LinkedListNode head=null;
		LinkedListNode tail=null;
		while(i< A.length) {
			LinkedListNode LinkedListNode = new LinkedListNode<>(A[i]);
			if(head ==null) {
				head=LinkedListNode;
				tail=LinkedListNode;
			}
			else {
				tail.next=LinkedListNode;
				tail=tail.next;
			}
		 	//	data = scanner.nextInt();
		 		i++;
		}
 		return head;
	}
	public static void PrintLL(LinkedListNode head) {
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
	public static int PrintithPositionLinkedListNode(LinkedListNode head,int i) {
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
	public static int FindLinkedListNodeinLLItreratively(LinkedListNode head,int n) {
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
	public static int LenghtLLItretatively(LinkedListNode head) {
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
//	  LinkedListNode head = CreateLinkedList();
//	  PrintLL(head);
//	  System.out.println("Enter the value of k...");
//	  int k =scanner.nextInt();
//	  System.out.println("Enter the value of i...");
//	  int i =scanner.nextInt();
//	  System.out.println(FindLinkedListNodefromKthLinkedListNodeReverseLL(head,k,i));
//	  PrintLL(FindLinkedListNodefromKthLinkedListNodeReverseLL(head,k,i));
	  scanner.close();
}
}
