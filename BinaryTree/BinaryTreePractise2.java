package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BinaryTreePractise2 {
	public static Scanner scanner = new Scanner(System.in);

	public static BinaryTreeNode<Integer> CreateBT() {
		System.out.println("Enter the data...");
		int data = scanner.nextInt();
		if (data == -1) {
			return null;
		}
		System.out.println("Not Null Create Root...");
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
		System.out.println("In left tree");
		root.left = CreateBT();
		System.out.println("In right tree");
		root.right = CreateBT();
		return root;
	}

	public static BinaryTreeNode<Integer> CreateBTusingQueue() {
		System.out.println("Enter the data...");
		int data = scanner.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> CurrentRoot = queue.removeFirst();
			System.out.println("Enter data for left tree..");
			int leftdata = scanner.nextInt();
			if (leftdata != -1) {
				CurrentRoot.left = new BinaryTreeNode<Integer>(leftdata);
				queue.addLast(CurrentRoot.left);
			}
			System.out.println("Enter data for right tree..");
			int rightdata = scanner.nextInt();
			if (rightdata != -1) {
				CurrentRoot.right = new BinaryTreeNode<Integer>(rightdata);
				queue.addLast(CurrentRoot.right);
			}

		}
		return root;
	}

	public static void PrintwithLeftRightChild(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data + " : " + "L :" + (root.left == null ? "-1" : root.left.data + " , ") + " R : "
				+ (root.right == null ? "-1" : root.right.data));
		PrintwithLeftRightChild(root.left);
		PrintwithLeftRightChild(root.right);

	}

	public static LinkedList<Integer> CREATEQUEUE(BinaryTreeNode<Integer> root) {
		// System.out.println("in create queue....");
		LinkedList<Integer> q2 = new LinkedList<>();
		LinkedList<BinaryTreeNode<Integer>> q1 = new LinkedList<>();
		q1.addLast(root);
		q2.addLast(root.data);
		q1.addLast(null);
		q2.addLast(-1);

		while (!q1.isEmpty()) {
			BinaryTreeNode<Integer> currentRoot = q1.removeFirst();
			if (currentRoot == null) {
				if (q1.isEmpty()) {
					break;
				} else {
					q1.addLast(null);
					q2.addLast(-1);

					continue;
				}
			}
			if (currentRoot.left != null) {
				q1.addLast(currentRoot.left);
				q2.addLast(currentRoot.left.data);
			}
			if (currentRoot.right != null) {
				q1.addLast(currentRoot.right);
				q2.addLast(currentRoot.right.data);
			}
		}
		return q2;
	}

	public static LinkedList<BinaryTreeNode<Integer>> TakeQueueWithRemoveAllLeavesforBTDS(
			BinaryTreeNode<Integer> root) {
		LinkedList<BinaryTreeNode<Integer>> ans = new LinkedList<>();
		LinkedList<BinaryTreeNode<Integer>> q1 = new LinkedList<>();
		q1.addLast(root);
		ans.addLast(root);
		q1.addLast(null);
		ans.addLast(null);
		int level = 0;
		while (!q1.isEmpty()) {
			BinaryTreeNode<Integer> currentRoot = q1.removeFirst();
			if (currentRoot == null) {
				if (q1.isEmpty()) {
					break;
				} else {
					q1.addLast(null);
					ans.addLast(null);
					level++;
					continue;
				}
			}
			if (currentRoot.left != null || currentRoot.right != null) {
				if (currentRoot.left != null && currentRoot.right != null) {
					q1.addLast(currentRoot.left);
					ans.addLast(currentRoot.left);
					q1.addLast(currentRoot.right);
					ans.addLast(currentRoot.right);
				}
			}

		}
		return ans;
	}

	public static ArrayList<BinaryTreeNode<Integer>> TakeArrayListforPrintLevelTraversal(
			LinkedList<BinaryTreeNode<Integer>> q) {
		ArrayList<BinaryTreeNode<Integer>> NodesList = new ArrayList<>();

		Iterator<BinaryTreeNode<Integer>> itr = q.iterator();
		while (itr.hasNext()) {

			// System.out.println(itr.next().data);
			NodesList.add(itr.next());

		}

		return NodesList;
	}

	public static ArrayList<Integer> CREATEARRAYLIST(LinkedList<Integer> q2) {
		ArrayList<Integer> A = new ArrayList<>();
		// System.out.println("In create arraylist....");
		Iterator<Integer> itr = q2.iterator();
		while (itr.hasNext()) {
			A.add(itr.next());
		}
		return A;
	}

	public static void PRINTARRAYLISTBTNODELEVELWISE(ArrayList<BinaryTreeNode<Integer>> A) {
		System.out.println();
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == null) {
				System.out.println();
			} else {
				System.out.print(A.get(i).data + " ");
			}
		}
		System.out.println();
	}

	public static void PRINTARRAYLISTLEVELWISE(ArrayList<Integer> A) {
		System.out.println();
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == -1) {
				System.out.println();
			} else {
				System.out.print(A.get(i) + " ");
			}
		}
		System.out.println();
	}

	public static void PrintBackwordList(List<Integer> L) {
		for (int i = L.size() - 1; i >= 0; i--) {
			System.out.print(L.get(i) + " ");
		}
	}

	public static void PrintForwardList(List<Integer> L) {
		for (int i = 0; i < L.size(); i++) {
			System.out.print(L.get(i) + " ");
		}
	}

	public static void PRINTARRAYLISTWithZigZagLEVELWISE(ArrayList<Integer> A) {
		System.out.println("Array is " + A);
		// boolean Direction = true;
		ArrayList<List<Integer>> LL = TakeListofListfromAL(A);
		System.out.println("LL is " + LL);
		System.out.println("L1 is ");
		ArrayList<List<Integer>> ZigZagList1 = TakeZigZag1List(LL);
		for (int i = 0; i < ZigZagList1.size(); i++) {
			System.out.println(ZigZagList1.get(i));
		}
		System.out.println("L2 is ");
		ArrayList<List<Integer>> ZigZagList2 = TakeZigZag2List(LL);
		for (int i = 0; i < ZigZagList2.size(); i++) {
			System.out.println(ZigZagList2.get(i));
		}

		for (int i = 0, j = 0; i < ZigZagList1.size() && i < ZigZagList2.size(); i++, j++) {
			PrintForwardList(ZigZagList1.get(i));
			System.out.println();
			PrintBackwordList(ZigZagList2.get(j));
			System.out.println();
		}
		// System.out.println();
		// for(int i=0;i<ZigZagList1.size();i++) {
		// PrintForwardList(ZigZagList1.get(i));
		//
		// }
		// 5 3 9 2 6 5 10 -1 -1 -1 -1 -1 -1 -1 -1

		if (ZigZagList1.size() > ZigZagList2.size())
			PrintForwardList(ZigZagList1.get(ZigZagList1.size() - 1));

		// System.out.println();

		if (ZigZagList2.size() > ZigZagList1.size())
			PrintBackwordList(ZigZagList2.get(ZigZagList2.size() - 1));

		// for(int j=0;j<ZigZagList2.size();j++) {
		// PrintBackwordList(ZigZagList2.get(j));
		//
		// }
	}

	public static ArrayList<List<Integer>> TakeZigZag1List(ArrayList<List<Integer>> LL) {
		ArrayList<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < LL.size(); i = i + 2) {
			ans.add(LL.get(i));
		}
		return ans;
	}

	public static ArrayList<List<Integer>> TakeZigZag2List(ArrayList<List<Integer>> LL) {
		ArrayList<List<Integer>> ans = new ArrayList<>();
		for (int i = 1; i < LL.size(); i = i + 2) {
			ans.add(LL.get(i));
		}
		return ans;
	}

	public static int Previous(int i, ArrayList<Integer> A) {
		int ans = 0;
		if (i == A.indexOf(null)) {
			return 0;
		}
		// System.out.println(A.indexOf(null));
		for (int j = i - 1; j > 0; j--) {
			if (A.get(j) == -1) {
				ans = j + 1;
				break;
			}
		}

		return ans;
	}

	public static int Next(int i, ArrayList<Integer> A) {
		return i - 1;
	}

	public static ArrayList<List<Integer>> TakeListofListfromAL(ArrayList<Integer> ALWN) {
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> TakeBreakingNumber = new ArrayList<Integer>();
		ArrayList<List<Integer>> Ans = new ArrayList<>();
		for (int i = 0; i < ALWN.size(); i++) {
			if (ALWN.get(i) == -1)
				TakeBreakingNumber.add(i);
		}
		// System.out.println(TakeBreakingNumber);
		for (int i = 0; i < TakeBreakingNumber.size(); i++) {
			ans.add(Previous(TakeBreakingNumber.get(i), ALWN));
			ans.add(Next(TakeBreakingNumber.get(i), ALWN));
		}
		// System.out.println(ans);
		for (int i = 0; i < ans.size() - 1; i = i + 2) {
			Ans.add(ALWN.subList(ans.get(i), ans.get(i + 1) + 1));
		}
		// Ans.add(A.subList(0, 3));
		// System.out.println(Ans);

		// for(int i=0;i<Ans.size();i++) {
		// //System.out.println(Ans.get(i));
		// CreateSingleLinkedListNodeUsingArrayList(Ans.get(i));
		// }
		return Ans;
	}

	public static void printZigZag(BinaryTreeNode<Integer> root) {
		PRINTARRAYLISTWithZigZagLEVELWISE(CREATEARRAYLIST(CREATEQUEUE(root)));
		// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
		// -1 -1
		// 1
		// 3 2
		// 4 5 6 7
		// 15 14 13 12 11 10 9 8

		// 1 2 3 -1 -1 4 5 -1 -1 6 7 -1 -1 8 9 -1 -1 10 11 -1 -1 -1 -1
		// 1
		// 3 2
		// 4 5
		// 7 6
		// 8 9
		// 11 10

		// 1 2 3 4 6 -1 5 -1 -1 -1 7 -1 8 -1 -1 -1 -1
		// 1
		// 3 2
		// 4 6 5
		// 8 7

		// 12 30 -1 -1 7 9 -1 -1 8 -1 -1
		// 3 1 2 -1 -1 30 40 -1 -1 -1 -1
		// 2 5 -1 -1 7 9 -1 -1 8 -1 -1

	}

	public static void PrintPreOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		if (root != null) {
			System.out.print(root.data + " ");
		}
		// 8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
		// 8 3 1 6 4 7 10 14 13
		PrintPreOrder(root.left);
		PrintPreOrder(root.right);
	}

	public static void PrintPostOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		PrintPostOrder(root.left);
		PrintPostOrder(root.right);
		if (root != null) {
			System.out.print(root.data + " ");
		}

		// 8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
		// 1 4 7 6 3 13 14 10 8
	}

	public static void PrintInOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		PrintInOrder(root.left);
		if (root != null) {
			System.out.print(root.data + " ");
		}
		PrintInOrder(root.right);

		// 8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
		// 1 3 4 6 7 8 10 13 14
	}

	
	public static BinaryTreeNode<Integer> HelperCreateBTfromINandPOST(int[] Post, int[] In, int InStart, int InEnd,
			int PostStart, int PostEnd) {
		if (InStart > InEnd) {
			return null;
		}
		// System.out.println("Pre order...");
		// for(int i=0;i<pre.length;i++) {
		// System.out.print(pre[i]+" ");
		// }
		// System.out.println("In order...");
		// for(int i=0;i<in.length;i++) {
		// System.out.print(in[i]+" ");
		// }
		int rootData = Post[PostEnd];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		int count = InStart;
		for (; count < InEnd; count++) {
			if (In[count] == rootData) {
				break;
			}
		}
		int InLeftStart = InStart;
		int InLeftEnd = count - 1;
		int PostLeftStart = PostStart;
		int PostLeftEnd = PostStart + count - InStart -1;

		int InRightStart = count + 1;
		int InRightEnd = InEnd;
		int PostRightStart = PostStart + count - InStart;
		int PostRightEnd = PostEnd -1;

		root.left = HelperCreateBTfromINandPOST(Post, In, InLeftStart, InLeftEnd, PostLeftStart, PostLeftEnd);
		root.right = HelperCreateBTfromINandPOST(Post, In, InRightStart, InRightEnd, PostRightStart, PostRightEnd);
		return root;
	}

	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in) {

		return HelperCreateBTfromINandPOST(post, in, 0, in.length - 1, 0, post.length - 1);
	}

	public static BinaryTreeNode<Integer> HelperCreateBTfromINandPRE(int[] pre, int[] in, int InStart, int InEnd,
			int PreStart, int PreEnd) {
		if (InStart > InEnd) {
			return null;
		}
		// System.out.println("Pre order...");
		// for(int i=0;i<pre.length;i++) {
		// System.out.print(pre[i]+" ");
		// }
		// System.out.println("In order...");
		// for(int i=0;i<in.length;i++) {
		// System.out.print(in[i]+" ");
		// }
		int rootData = pre[PreStart];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		int count = InStart;
		for (; count < InEnd; count++) {
			if (in[count] == rootData) {
				break;
			}
		}
		int InLeftStart = InStart;
		int InLeftEnd = count - 1;
		int PreLeftStart = PreStart + 1;
		int PreLeftEnd = PreStart + count - InStart;

		int InRightStart = count + 1;
		int InRightEnd = InEnd;
		int PreRightStart = PreStart + count - InStart + 1;
		int PreRightEnd = PreEnd;

		root.left = HelperCreateBTfromINandPRE(pre, in, InLeftStart, InLeftEnd, PreLeftStart, PreLeftEnd);
		root.right = HelperCreateBTfromINandPRE(pre, in, InRightStart, InRightEnd, PreRightStart, PreRightEnd);
		return root;

	}

	public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in) {
		return HelperCreateBTfromINandPRE(pre, in, 0, in.length - 1, 0, pre.length - 1);
	}

	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> Ans = null;
		LinkedList<BinaryTreeNode<Integer>> QUEUE = TakeQueueWithRemoveAllLeavesforBTDS(root);
		ArrayList<BinaryTreeNode<Integer>> ARRAYLIST = TakeArrayListforPrintLevelTraversal(QUEUE);
		PRINTARRAYLISTBTNODELEVELWISE(ARRAYLIST);
		return Ans;
	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {

		PRINTARRAYLISTLEVELWISE(CREATEARRAYLIST(CREATEQUEUE(root)));
	}

	public static void main(String[] args) {
		// BinaryTreeNode<Integer> root = CreateBTusingQueue();
		 BinaryTreeNode<Integer> root = CreateBT();
//		int S = scanner.nextInt();
//		int Post[]= new int[S];
//		int Pre[] = new int[S];
//		int In[] = new int[S];
////		for (int i = 0; i < S; i++) {
//			Pre[i] = scanner.nextInt();
////		}
//		for (int i = 0; i < S; i++) {
//			Post[i] = scanner.nextInt();
//		}
//		for (int i = 0; i < S; i++) {
//			In[i] = scanner.nextInt();
//		}
		//BinaryTreeNode<Integer> root = getTreeFromPreorderAndInorder(Pre, In);
	//	BinaryTreeNode<Integer> root = getTreeFromPostorderAndInorder(Post, In);
		PrintwithLeftRightChild(root);
		printLevelWise(root);
		// removeAllLeaves(root);
		// printZigZag(root);
		PrintPreOrder(root);

		System.out.println("\n");
		PrintPostOrder(root);
		System.out.println("\n");
		PrintInOrder(root);
		scanner.close();
	}
}
