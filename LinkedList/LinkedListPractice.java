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
//        System.out.println(tail.next);
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
        // while loop is help to print all Linked List itratively 		
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
		// here c is counter to count the total number of node in linked list...
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
        // help of c counter incremently... 
		// index used to find index of n integer in Linked List..
		if(index>0) {
			ans=index;
		}
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
		// here ith position start with while loop and c is help to reach the position i and get element of Linked List...
		return ans;
	}
	public static Node AppendLastNtoFirst(Node head,int N) {
		Node head1 =null;
		return head1;
	}
	public static void ReverseRecursive(Node head) {

		 //System.out.println(head.data);
		
			if(head==null) {
 				return ;
 			}
 			ReverseRecursive(head.next);
 		//	here  without change any pointer of linked list we did reverse the linked list ...
 			// until we get  null last element of LL then we call recursive after then we print node data using line 126...
 			System.out.print(head.data+" ");
	}
	
	public static Node RemoveDuplicate(Node head) {
		int duplicateIndex =-1;
		int index=0;
		int c=0;
		while(head !=null) {
			if(head.data==head.next.data) {
				System.out.println(index);
				c++;
			}
			head = head.next;
			index++;
		}
		System.out.println("Total Duplicate = "+c);
		return head;
	}
    public static Node DeleteIthNodeItratively(Node head,int i) {
    	Node Previous =head;
    	if(i==0) {
    		head = head.next;
    	}
    	if(i==1) {
    		head.next = head.next.next;
   //		head.next=head.next.next;
    	}
    	i--; 
    	int index =1;
    	System.out.println(i);
    	while(Previous!=null) {
    		
//    		Node Current =Previous.next;
//        	Node Forword =Previous.next.next;
        	
    		if(index==i) {
    			System.out.println("P = "+Previous.data);
    			System.out.println("C = "+Previous.next.data);
    			System.out.println("F = "+Previous.next.next.data);
    			Previous = Previous.next;
    			Previous.next = Previous.next.next;
    			
//    			break;
    		}
    		Previous =Previous.next;
    		index++;
    	}
    	return head;
    }
    public static int FindMiddleElementIndex(Node head) {
    	int index=0;
    	if(LenghtLLItretatively(head)%2!=0) {
    		Node slow = head;
        	Node fast =head.next;
        	
        	while(slow!=null && fast!=null) {
 
            		fast = fast.next.next;
            		slow = slow.next;
            		index++;
        	}		
    	}
    	else {
    		Node slow = head;
        	Node fast =head;
        	
        	while(slow!=null && fast!=null) {
 
            		fast = fast.next.next;
            		slow = slow.next;
            		index++;
        	}	
        	index--;
    	}
    	return index;
    }
    public static Node DeleteMiddleNode(Node head) {
    	PrintLL(head);
    	int middleIndex = FindMiddleElementIndex(head);
    	
    	Node head1 = DeleteIthNodeItratively(head, middleIndex);
//    	System.out.println("Middle Index = "+middleIndex);
//    	Node MiddleNode =null;
//    	int index =0;
//    	while(head!=null) {
//    		
//    		if(index==middleIndex) {
//    			System.out.println("Middle Index = "+middleIndex);
//    			System.out.println("Middle element  = "+head.data);
//    			MiddleNode = head;
//    			System.out.println(MiddleNode.data);
//    			MiddleNode = MiddleNode.next;
//    			System.out.println(MiddleNode.data);
//    			MiddleNode.next = MiddleNode.next.next;
//    		//	System.out.println(MiddleNode.next.data);
////    			head = head.next;
////    			head.next=head.next.next;
//    		}
//    		head = head.next;
//    		index++;
//    	}
//    	System.out.println("Middle Node Deleted...");
    	return head1;
    }
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the elements of Linked list....");
	 Node head= CreateLinkedList();
	 PrintLL(head);
	  System.out.println("Length of Linked List...");
	  System.out.println(LenghtLLItretatively(head));
	  
	  PrintLL(DeleteMiddleNode(head));
	//  PrintLL(RemoveDuplicate(head));
	  
//	  System.out.println("Enter the number to be search in linked list...");
//	  int n1 = scanner.nextInt() ;
//	  System.out.println("Your Searched Number's index is "+FindNodeinLLItreratively(head, n1));
//      System.out.println("Enter the ith position...");
//      int i1 = scanner.nextInt();
//      System.out.println("Your ith Position Data is "+PrintithPositionNode(head, i1));
// 	  ReverseRecursive(head);
//	  System.out.println();
//	  System.out.println("Enter the value of n to Append last n element to Front of Linked list...");
//	  int n2 = scanner.nextInt();
//	  AppendLastNtoFirst(head,n2);
//	  System.out.println("Enter the ith position to delete node of Linked List...");
//	  int i2 =scanner.nextInt();
//	  Node head2= DeleteIthNodeItratively(head,i2);
//	  PrintLL(head2);
//	  int milldeIndex = FindMiddleElementIndex(head);
//	  System.out.println("M = "+FindMiddleElementIndex(head));
//	  PrintLL(DeleteMiddleNode(head));
//	  System.out.println("Enter the elements duplicate and incresing order...");
//	  Node head3 = CreateLinkedList();
//	  RemoveDuplicate(head3);
	  
  	}
}
