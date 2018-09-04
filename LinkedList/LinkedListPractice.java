package LinkedList;

import java.util.Scanner;

public class LinkedListPractice {

	public static LinkedListNode CreateLinkedList() {
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();
		// here we take data integer till -1 and Take memory using new LinkedListNode(data)...
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
			// here if and else start Linked list with head LinkedListNode and tail LinkedListNode increment till -1.
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
	public static void PrintLL(LinkedListNode head) {
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
	public static int LenghtLLItretatively(LinkedListNode head) {
		int c=0;
		if(head==null) {
			return 0;
		}
		while(head!=null) {
			head=head.next;
			c++;
		}
		// here c is counter to count the total number of LinkedListNode in linked list...
		return c;
	}
	public static int FindLinkedListNodeinLLItreratively(LinkedListNode head,int n) {
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
		// here ith position start with while loop and c is help to reach the position i and get element of Linked List...
		return ans;
	}
	public static LinkedListNode AppendLastNtoFirst(LinkedListNode head,int N) {
		LinkedListNode head1 =null;
		return head1;
	}
	public static void ReverseRecursive(LinkedListNode head) {

		 //System.out.println(head.data);
		
			if(head==null) {
 				return ;
 			}
 			ReverseRecursive(head.next);
 		//	here  without change any pointer of linked list we did reverse the linked list ...
 			// until we get  null last element of LL then we call recursive after then we print LinkedListNode data using line 126...
 			System.out.print(head.data+" ");
	}
	
	public static LinkedListNode RemoveDuplicate(LinkedListNode head) {
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
    public static LinkedListNode DeleteIthLinkedListNodeItratively(LinkedListNode head,int i) {
    	LinkedListNode Previous =head;
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
    		
//    		LinkedListNode Current =Previous.next;
//        	LinkedListNode Forword =Previous.next.next;
        	
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
    public static int FindMiddleElementIndex(LinkedListNode head) {
    	int index=0;
    	if(LenghtLLItretatively(head)%2!=0) {
    		LinkedListNode slow = head;
        	LinkedListNode fast =head.next;
        	
        	while(slow!=null && fast!=null) {
 
            		fast = fast.next.next;
            		slow = slow.next;
            		index++;
        	}		
    	}
    	else {
    		LinkedListNode slow = head;
        	LinkedListNode fast =head;
        	
        	while(slow!=null && fast!=null) {
 
            		fast = fast.next.next;
            		slow = slow.next;
            		index++;
        	}	
        	index--;
    	}
    	return index;
    }
    public static LinkedListNode DeleteMiddleLinkedListNode(LinkedListNode head) {
    	PrintLL(head);
    	int middleIndex = FindMiddleElementIndex(head);
    	
    	LinkedListNode head1 = DeleteIthLinkedListNodeItratively(head, middleIndex);
//    	System.out.println("Middle Index = "+middleIndex);
//    	LinkedListNode MiddleLinkedListNode =null;
//    	int index =0;
//    	while(head!=null) {
//    		
//    		if(index==middleIndex) {
//    			System.out.println("Middle Index = "+middleIndex);
//    			System.out.println("Middle element  = "+head.data);
//    			MiddleLinkedListNode = head;
//    			System.out.println(MiddleLinkedListNode.data);
//    			MiddleLinkedListNode = MiddleLinkedListNode.next;
//    			System.out.println(MiddleLinkedListNode.data);
//    			MiddleLinkedListNode.next = MiddleLinkedListNode.next.next;
//    		//	System.out.println(MiddleLinkedListNode.next.data);
////    			head = head.next;
////    			head.next=head.next.next;
//    		}
//    		head = head.next;
//    		index++;
//    	}
//    	System.out.println("Middle LinkedListNode Deleted...");
    	return head1;
    }
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the elements of Linked list....");
	 LinkedListNode head= CreateLinkedList();
	 PrintLL(head);
	  System.out.println("Length of Linked List...");
	  System.out.println(LenghtLLItretatively(head));
	  
	  PrintLL(DeleteMiddleLinkedListNode(head));
	//  PrintLL(RemoveDuplicate(head));
	  
//	  System.out.println("Enter the number to be search in linked list...");
//	  int n1 = scanner.nextInt() ;
//	  System.out.println("Your Searched Number's index is "+FindLinkedListNodeinLLItreratively(head, n1));
//      System.out.println("Enter the ith position...");
//      int i1 = scanner.nextInt();
//      System.out.println("Your ith Position Data is "+PrintithPositionLinkedListNode(head, i1));
// 	  ReverseRecursive(head);
//	  System.out.println();
//	  System.out.println("Enter the value of n to Append last n element to Front of Linked list...");
//	  int n2 = scanner.nextInt();
//	  AppendLastNtoFirst(head,n2);
//	  System.out.println("Enter the ith position to delete LinkedListNode of Linked List...");
//	  int i2 =scanner.nextInt();
//	  LinkedListNode head2= DeleteIthLinkedListNodeItratively(head,i2);
//	  PrintLL(head2);
//	  int milldeIndex = FindMiddleElementIndex(head);
//	  System.out.println("M = "+FindMiddleElementIndex(head));
//	  PrintLL(DeleteMiddleLinkedListNode(head));
//	  System.out.println("Enter the elements duplicate and incresing order...");
//	  LinkedListNode head3 = CreateLinkedList();
//	  RemoveDuplicate(head3);
	  
  	}
}
