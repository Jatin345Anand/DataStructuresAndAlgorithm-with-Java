package BinaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UsingLinkedListQueue {
	public static void PrintQueue(LinkedList<Integer> queue) {
		 System.out.println();
		Iterator<Integer> itr = queue.iterator();
		System.out.println("Queue is ..\n");
		while(itr.hasNext()) {
			System.out.print(itr.next()+ " ");
		}
		System.out.println();
	}
	private static  boolean UseBreak(int[] A) {
	 boolean ans=true;
     for (int a :A) {
    	 if(a==3) {
    		 return true;
    	 }
     }
     return ans;
	}
	public static int Previous(int i,ArrayList<Integer> A) {
	     int ans =0;
	     if(i==A.indexOf(-1)) {
	    	 return 0;
	     }
	     for(int j=i-1;j>1;j--) {
	    	 if(A.get(j)==-1) {
	    		 ans = j+1;
	    		 break;
	    	 }
	     }
	   
	     return ans;
	}
    public static int Next(int i,ArrayList<Integer> A) {
		int ans=0;
 		return i-1;
	}
    public static void PrintLL(Node<Integer> head) {
    	 
		while(head!=null) {
			System.out.print(head.data +" ");
			head = head.next;
		}
      
	}
    public static Node<BinaryTreeNode<Integer>> CreateSingleLinkedListNodeUsingArrayList(List<Integer> A) {
    	Node<BinaryTreeNode<Integer>> head = null;
    	Node<BinaryTreeNode<Integer>> tail = null;
    	
    	for(int i=0;i<A.size();i++) {
    		Node<BinaryTreeNode<Integer>> current = new Node(A.get(i));
            if(head==null) {
            	head=current;
            	tail=current;
            }
            else {
            	tail.next = current;
        		tail = tail.next;	
            }
    		
    	}
    	return head;
    }
	public static ArrayList<Integer> FindListofListIndexesStartEnd(ArrayList<Integer> A){
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> TakeBreakingNumber = new ArrayList<Integer>();
	   ArrayList<List<Integer>> Ans = new ArrayList<>();
		for(int i=0;i<A.size();i++) {
			if(A.get(i)==-1)
			TakeBreakingNumber.add(i);
		}
		System.out.println(TakeBreakingNumber);
		for(int i=0;i<TakeBreakingNumber.size();i++) {
		  ans.add(Previous(TakeBreakingNumber.get(i),A));
		  ans.add(Next(TakeBreakingNumber.get(i),A));
		}
		System.out.println(ans);
		for(int i=0;i<ans.size()-1;i=i+2) {
			Ans.add( A.subList(ans.get(i), ans.get(i+1)+1));
		}
		//Ans.add(A.subList(0, 3));
		System.out.println(Ans);
		for(int i=0;i<Ans.size();i++) {
		//	PrintLL(CreateSingleLinkedListNodeUsingArrayList(Ans.get(i)));
		}
		return ans;
	}
	public static void CheckPreMethodarrayList(ArrayList<Integer> A) {
		System.out.println(A);
		A.clear();
		System.out.println(A);
	}
	public static ArrayList<Integer> TempArrayList = new ArrayList<>(); 
	public static ArrayList<ArrayList<Integer>> PrintLevelwiseArrayList(ArrayList<Integer> A) {
		System.out.println();
		 ArrayList<ArrayList<Integer>> A11 = new ArrayList<>();
			
		for(int i=0;i<A.size();i++) {
			if(A.get(i)==-1) {
				
				A11.add(TempArrayList);
				TempArrayList.clear();
				//System.out.println();
			}
			else {
				System.out.print(A.get(i)+" ");
//				TempArrayList.add(A.get(i));
				TempArrayList.add(3);
			}
				
		}
		
		System.out.println();
	 return A11;
	}
 //	10 1 2 -1 2 3 -1 3 4 5 -1
 //	12 1 3 4 -1 5 4 -1 23 56 -1 5 -1
    public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
	System.out.println("Enter size...");
	int n = scanner.nextInt();
	ArrayList<Integer> A1 = new ArrayList<>(); 
	for(int i=0;i<n;i++) {
	  A1.add(scanner.nextInt());
	}
	//System.out.println( PrintLevelwiseArrayList(A1));
	//CheckPreMethodarrayList(A1);
	
	//System.out.println(A11);
	  System.out.println("$$$$$$$$$$$");
	System.out.println( FindListofListIndexesStartEnd(A1));
	Previous(2, A1);
	Next(2, A1);
//	ArrayList<Integer> AL = new ArrayList<>();
//	AL.add(11);
//	AL.add(12);
//	LinkedList<Integer> queue = new LinkedList<>();
//	System.out.println("Enter add...");
//	queue.add(scanner.nextInt());
//	System.out.println("Enter data to index 1 in queue...");
//	queue.add(1, scanner.nextInt());
//	System.out.println("Add arraylist at index 2 ...");
//	queue.addAll(2, AL);
//	System.out.println("Enter add last ...");
//	queue.addLast(scanner.nextInt());
//	System.out.println("Enter add first...");
//	queue.addFirst(scanner.nextInt());
//	PrintQueue(queue);
//	queue.remove();
//    PrintQueue(queue);
//    queue.removeFirst();
//    PrintQueue(queue);
//    queue.removeLast();
//    PrintQueue(queue);
	scanner.close();
}
}
