package LinkedList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LLpractice3 extends LinkedListPractice {
	public static void Print(LinkedListNode<Integer> head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}

	public static ArrayList<Integer> ReverseList(List<Integer> A) {
		ArrayList<Integer> Ans = new ArrayList<>();

		for (int i = A.size() - 1; i >= 0; i--) {
			Ans.add(A.get(i));
		}
		return Ans;
	}
	public static  LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head,int i,int j){
		return CreateSingleLinkedListNodeUsingArrayList2(SwapTwoElement(FetchListFromRootNode(head), i, j));
	}
	public static void InsertAtCorrectPosition(ArrayList<Integer> A, int x) {
		//System.out.println("Arralist is InsertAtCoorent Position "+A);
		if (A.size() >= 2) {
			for (int i = 0; i < A.size()-1; i++) {
				if (A.get(i) < x && A.get(i + 1) > x) {
                    
					A.add(i + 1, x);
					 
				}
				else if(A.get(i)==x) {
					A.add(i+1,x);
				}
			}
			
		}
	}
	 public static ArrayList<Integer> InsertionSortArrayList(ArrayList<Integer> A){
	    	if (A.size() == 2) {
				if (A.get(0) > A.get(1)) {
					int x = A.get(0);
					A.set(0, A.get(1));
					A.set(1, x);
				}

				return A;
			}
			if (A.size() == 1) {
				return A;
			}
			ArrayList<Integer> CurrentList = new ArrayList<>();
			if (A.get(0) > A.get(1)) {
				int x = A.get(0);
				A.set(0, A.get(1));
				A.set(1, x);
			}
			CurrentList.add(A.get(0));
			CurrentList.add(A.get(1));

			for(int i=2;i<A.size();i++) {
				
			  CurrentList=InsertAtCoorectPostionGivenX(CurrentList, A.get(i));
			 // System.out.println("Current List = "+CurrentList+" : Itreation = "+i);
			}
		//	System.out.println("Current List = "+CurrentList);
			return CurrentList;
	    }
	 public static LinkedListNode<Integer> ins_sort(LinkedListNode<Integer> head) {
		      return CreateSingleLinkedListNodeUsingArrayList2(InsertionSortArrayList(FetchListFromRootNode(head)));
		}
	 public static LinkedListNode<Integer> insertionSort(LinkedListNode<Integer> head) {
	     return CreateSingleLinkedListNodeUsingArrayList2(InsertionSortArrayListRecursive(FetchListFromRootNode(head)));
		}
		public static ArrayList<Integer> InsertAtCoorectPostionGivenX(ArrayList<Integer> A, int x) {
	        boolean isFound =false;
		     for(int i=0;i<A.size();i++) {
	    	   if(A.get(i)>x) {
	    		 isFound = true;
	    		 break;
	    	   }
	    	    
	       }
		  // System.out.println((isFound)?"YES":"NO");
		   if(!isFound) {
			    A.add(x);
		    }
		   else {
			   for(int i=0;i<A.size();i++) {
				   if(A.get(i)>=x) {
					   A.add(i, x);
					   break;
				   }
			   }
		    }
		   return A;
		}
		 public static ArrayList<Integer> SwapTwoElement(ArrayList<Integer> A,int i,int j){
		    	int x = A.get(i);
		    	int y = A.get(j);
		    	A.set(i, y);
		    	A.set(j, x);
		    	return A;
		    }
		public static ArrayList<Integer> InsertionSortArrayListRecursive(ArrayList<Integer> A){
		    
			
			return null;
		}
	public static ArrayList<Integer> InsertionSortForArrayList(ArrayList<Integer> A) {
		System.out.println("Before " + A);
		if (A.size() == 2) {
			if (A.get(0) > A.get(1)) {
				int x = A.get(0);
				A.set(0, A.get(1));
				A.set(1, x);
			}

			return A;
		}
		if (A.size() == 1) {
			return A;
		}
//		System.out.println("Before "+A);
		InsertAtCorrectPosition(A, 4);
		System.out.println("After "+A);
       return null;
	}

	public static LinkedListNode<Integer> CreateSingleLinkedListNodeUsingArrayList2(ArrayList<Integer> A) {
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;

		for (int i = 0; i < A.size(); i++) {
			LinkedListNode<Integer> current = new LinkedListNode(A.get(i));
			if (head == null) {
				head = current;
				tail = current;
			} else {
				tail.next = current;
				tail = tail.next;
			}

		}
		return head;
	}
 
    
	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		int l = LenghtLLItretatively(head);
		// 1 2 3 4 5 6 7 8 9 10 -1
		// 4
		// 1 2 3 4 5 6 7 8 9 10 -1
		// 5

		ArrayList<Integer> Index2 = new ArrayList<>();
		int i = 0;
		for (; i < l; i = i + k) {
			System.out.println(i);
			Index2.add(i);
		}
		System.out.println(Index2);
		ArrayList<Integer> LinkedListArrayLiat = FetchListFromRootNode(head);
		ArrayList<Integer> Ans = new ArrayList<>();
		for (int i1 = 0; i1 < Index2.size() - 1; i1++) {
			System.out.println("Start = " + Index2.get(i1) + " : End = " + Index2.get(i1 + 1));
			System.out.println(LinkedListArrayLiat.subList(Index2.get(i1), Index2.get(i1 + 1)));
			Ans.addAll(ReverseList(LinkedListArrayLiat.subList(Index2.get(i1), Index2.get(i1 + 1))));

		}
		Ans.addAll(ReverseList(LinkedListArrayLiat.subList(Index2.get(Index2.size() - 1), LinkedListArrayLiat.size())));
		System.out.println("Final Ans = " + Ans);

		return CreateSingleLinkedListNodeUsingArrayList2(Ans);
	}

	public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
		// 1852 1566 735 141 259 1563 1532 619 1670 572 -1
		// 735 141 259 1563 619 1852 1566 1532 1670 572

		// 1458 291 1377 959 1275 1118 157 156 1407 873 835 1377 1592 129 386 877 1139
		// 461 1880 1263 -1
		// 291 1377 959 1275 157 1407 873 835 1377 129 877 1139 461 1263 1458 1118 156
		// 1592 386 1880

		// 1 11 3 6 8 0 9 -1

		ArrayList<Integer> O = new ArrayList<>();
		ArrayList<Integer> E = new ArrayList<>();
		ArrayList<Integer> LL = FetchListFromRootNode(head);
		for (int i = 0; i < LL.size(); i++) {
			if (LL.get(i) % 2 == 0) {
				E.add(LL.get(i));
			} else {
				O.add(LL.get(i));
			}
		}
		O.addAll(E);
		System.out.println(O);
		return CreateSingleLinkedListNodeUsingArrayList2(O);
	}

	public static ArrayList<Integer> FetchListFromRootNodeToAppend(LinkedListNode<Integer> head, int n) {
		ArrayList<Integer> ANS = new ArrayList<>();
		ArrayList<Integer> ANS2 = new ArrayList<>();
		int l = LenghtLLItretatively(head);
		int C = l - n;
		int i = 0;
		while ((head != null) && i < C) {
			ANS.add(head.data);
			head = head.next;
			i++;
		}
		while (head != null) {
			ANS2.add(head.data);
			head = head.next;
		}
		System.out.println("A1 = " + ANS + " && A2 = " + ANS2);
		ANS2.addAll(ANS);
		System.out.println("Final A = " + ANS2);
		return ANS2;
	}

	public static void mergeSort(int[] A, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			mergeSort(A, l, m);

			mergeSort(A, m + 1, r);

			merge(A, l, m, r);
		}

	}

	public static void merge(int[] arr, int l, int m, int r) {

		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	public static int[] ArrayListToArray(ArrayList<Integer> A) {
		int[] ans = new int[A.size()];
		for (int i = 0; i < A.size(); i++) {
			ans[i] = A.get(i);
		}
		return ans;
	}

	public static ArrayList<Integer> ArrayToArrayList(int A[]) {
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			ans.add(A[i]);
		}
		return ans;
	}

	public static ArrayList<Integer> FetchListFromCustomSandE(LinkedListNode<Integer> head, int Start, int End) {
		ArrayList<Integer> ANS = new ArrayList<>();

		while (head != null && Start <= End) {
			ANS.add(head.data);
			head = head.next;
			Start++;
		}

		return ANS;
	}

	public static ArrayList<Integer> FetchListFromRootNode(LinkedListNode<Integer> head) {
		ArrayList<Integer> ANS = new ArrayList<>();

		while (head != null) {
			ANS.add(head.data);
			head = head.next;
		}

		return ANS;
	}

	public static LinkedListNode<Integer> MiddleNode(LinkedListNode<Integer> head) {
		if (head == null) {
			return null;
		}
		LinkedListNode<Integer> Faster = head.next;
		LinkedListNode<Integer> Slower = head;
		while (Faster != null) {
			Faster = Faster.next;
			if (Faster != null) {
				Slower = Slower.next;
				Faster = Faster.next;
			}
		}
		return Slower;
	}

	public static LinkedListNode<Integer> mergeSort2(LinkedListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		// here this is base case...
		LinkedListNode<Integer> middle = MiddleNode(head);
		// find Left list head...
		LinkedListNode<Integer> middleNext = middle.next;
		// find right list head...
		middle.next = null;
		// set null end of left linked list...
		LinkedListNode<Integer> LEFT = mergeSort2(head);
		// do break left list...
		LinkedListNode<Integer> RIGHT = mergeSort2(middleNext);
		// do break right list...
		LinkedListNode<Integer> ans = mergeLinkedlist(LEFT, RIGHT);
		return ans;
	}

	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		int A[] = ArrayListToArray(FetchListFromRootNode(head));
		mergeSort(A, 0, A.length - 1);

		return CreateSingleLinkedListNodeUsingArrayList2(ArrayToArrayList(A));
	}

	public static LinkedListNode<Integer> mergeLinkedlist(LinkedListNode<Integer> L, LinkedListNode<Integer> R) {
		LinkedListNode<Integer> ANS = null;
		if (L == null) {
			return L;
		}
		if (R == null) {
			return R;
		}
		// this is base case if Left or Right null then return Left and Right...
		if (L.data <= R.data) {
			ANS = L;
			// check Minimum and Assign node to ANS linked list
			ANS.next = mergeLinkedlist(L.next, R);
			// after that call next node of left list...
		} else {
			ANS = R;
			// same as left
			ANS.next = mergeLinkedlist(L, R.next);
		}
		return ANS;
	}

	public static LinkedListNode<Integer> H = null;
	public static LinkedListNode<Integer> T = null;

	public static void pushforReverse(int new_data) {
		/* allocate node */
		LinkedListNode<Integer> new_node = new LinkedListNode<>(new_data);

		/* link the old list off the new node */
		new_node.next = H;

		/* move the head to point to the new node */
		H = new_node;
	}

	public static void pushforForward(int new_data) {
		/* allocate node */
		LinkedListNode<Integer> new_node = new LinkedListNode<>(new_data);

		/* link the old list off the new node */
		if (H == null) {
			H = new_node;
			T = new_node;
		} else {
			T.next = new_node;
			T = T.next;
			// new_node = new_node.next;

		}
		/* move the head to point to the new node */
		// H = new_node;
	}

	public static LinkedListNode<Integer> append(LinkedListNode<Integer> root, int n) {
		// 287 34 -1
		// 1
		// 287 34
		// 34 287

		// 41 992 467 385 751 56 702 397 798 467 -1
		// 2
		// 385 751 56 702 397 798 467 41 992 467
		// 798 467 41 992 467 385 751 56 702 397

		// 524 541 9 915 273 443 564 231 861 643 746 12 781 813 956 522 36 35 706 881 -1
		// 5
		// 564 231 861 643 746 12 781 813 956 522 36 35 706 881 524 541 9 915 273 443
		// 522 36 35 706 881 524 541 9 915 273 443 564 231 861 643 746 12 781 813 956

		return CreateSingleLinkedListNodeUsingArrayList2(FetchListFromRootNodeToAppend(root, n));

	}

	public static void PrintArrayList(ArrayList<Integer> A) {
		System.out.println();
		for (int i = 0; i < A.size(); i++) {
			System.out.print(A.get(i) + " ");
		}
	}

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> ALforLL = new ArrayList<>();
		System.out.println("Enter data till -1...");
		int data = scanner.nextInt();
		while (data != -1) {
			ALforLL.add(data);
			// pushforReverse(data);
			data = scanner.nextInt();
		}
		int i=scanner.nextInt();
		int j=scanner.nextInt();
		// //int k=scanner.nextInt();
		// System.out.println("Done");
		// System.out.println("AL = "+ALforLL);
		//InsertionSortForArrayList(ALforLL);

		LinkedListNode<Integer> head = CreateSingleLinkedListNodeUsingArrayList2(ALforLL);
		// PrintLL(head);
		// System.out.println("Last append child is ... ");
		// PrintLL (append(head, n));
		// PrintLL(kReverse(head, k));
		// PrintLL(sortEvenOdd(head));
//		PrintArrayList(FetchListFromRootNode(head));
//		PrintLL(head);
//		PrintLL(mergeSort(head));
//		PrintArrayList(FetchListFromRootNode(head));
//		PrintLL(ins_sort(head));
		PrintLL(swap_nodes(head, i, j));
		scanner.close();
	}

}
