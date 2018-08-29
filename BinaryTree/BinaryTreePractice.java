package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Node<T> {
	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
	}
}

public class BinaryTreePractice {
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

	public static boolean checkBalanced(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		// here we use recursion method to check height of every tree in given tree...
		int lh = HeightofBT(root.left);
		// first we get height of all left tree of root
		int rh = HeightofBT(root.right);
		// second we get height of all right tree of root

		boolean ans1 = ((lh - rh) <= 1 && (lh - rh >= -1));
		// here we mention height of every root of tree range is -1 to 1.
		boolean ans2 = checkBalanced(root.left);
		// apply recursive method same on left side
		boolean ans3 = checkBalanced(root.right);
		// apply recursive method same on right side
		return (ans1 && ans2 && ans3);
	}

	public static int sumofAllNodes(BinaryTreeNode<Integer> root) {
		int ans = 0;
		if (root != null) {
			ans += root.data;
			ans += sumofAllNodes(root.left);
			ans += sumofAllNodes(root.right);
		}
		return ans;
	}

	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int node) {
		boolean ans = false;

		if (root != null) {
			if (root.data == node && root != null) {
				System.out.println("root is now " + root.data);
				ans = true;
				return true;
			}
			System.out.println("Ans = " + ans + " current node is " + root.data);
			isNodePresent(root.left, node);
			isNodePresent(root.right, node);
		}

		return (root != null) ? root.data == node : false;

	}

	public static boolean search(BinaryTreeNode<Integer> root, int node) {
		if (root == null) {
			System.out.println("Null");
			return false;
		}
		if (root != null) {
			System.out.println("root = " + root.data);
		}
		if (root.data == node) {
			System.out.println("root is now " + root.data);

			return true;
		}
		return (search(root.left, node)) || (search(root.right, node));
	}

	// 8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1 7
	// 12 20 -1 -1 30 -1 -1 30
	public static LinkedList<BinaryTreeNode<Integer>> CreateBTusingQueueReturnLL() {
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
		return queue;
	}

	public static void PrintBTusingQueue(LinkedList<BinaryTreeNode<Integer>> LL) {
		System.out.println();
		Iterator<BinaryTreeNode<Integer>> itr = LL.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next().data + " ");
		}
		System.out.println();

	}

	// 3 1 2 -1 -1 30 40 -1 -1 -1 -1
	public static void PrintwithLeftRightChild(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		// this method is based on firstly take parent root node of tree and after it
		// traverse all first left tree and afer take right tree...
		// until it take -1 or null from left tree it will not go to right tree...
		// it is good way to traverse with left and right child parallely..
		System.out.println(root.data + " : " + "L :" + (root.left == null ? "-1" : root.left.data + " , ") + " R : "
				+ (root.right == null ? "-1" : root.right.data));
		PrintwithLeftRightChild(root.left);
		PrintwithLeftRightChild(root.right);

	}

	// using creation by Recursion 3 1 -1 -1 2 30 -1 -1 40 -1 -1 40
	// using creation by queue 3 1 2 -1 -1 30 40 -1 -1 -1 -1 3 1 4 -1 -1 -1 2 5 -1
	// -1 6 -1 -1
	// 8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
	// 2 5 -1 -1 7 9 -1 -1 8 -1 -1
	// 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
	public static void PrintBT(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		// this method is just oposite of PrintwithLeftRightChild because here it firtly
		// take left leaf node of left tree of parent root.
		// after completing left tree it take right leaf node of left tree of parent
		// root.
		// same process repeat in right tree of parent root.
		// until it traverse all first all left tree node and second all right tree node
		// .
		// it go to parent root of Binary tree.
		System.out.println("Left tree");
		PrintBT(root.left);
		// go to left tree of parent root.
		System.out.println("Right tree");
		PrintBT(root.right);
		// go to right tree of parent root.
		System.out.println("Root");
		System.out.println(root.data);
	}

	public static int HelperheightBT(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		// this the base case of this method if root is null?
		int lh = HelperheightBT(root.left);
		// here we will find height of left tree of the root
		// if(root!=null) {
		// System.out.println("Left height is "+lh+" Root is "+root.data);
		// System.out.println("Left height is "+lh+" Root is "+root.left.data);
		// }
		int rh = HelperheightBT(root.right);
		// if(root!=null) {
		// System.out.println("Right height is "+rh+" Root is "+root.data);
		// System.out.println("Right height is "+rh+" Root is "+root.right.data);
		// }
		// here we will find height of right tree of the root
		// using concept of height ,height must be become maximum in left and right tree
		// so take maximum of heights...
		return Math.max(lh, rh) + 1;
	}

	public static int HeightofBT(BinaryTreeNode<Integer> root) {
		return HelperheightBT(root) - 1;
	}

	public static LinkedList<BinaryTreeNode<Integer>> queue1 = new LinkedList<>();

	public static void TraverseLevelWise(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		if (root != null) {
			queue1.addLast(root);
		}
		TraverseLevelWise(root.left);
		TraverseLevelWise(root.right);
	}

	public static void PrintLevelTraversalUsingQueue(BinaryTreeNode<Integer> root) {
		System.out.println("Queue is ....");
		queue1.clear();
		TraverseLevelWise(root);
		Iterator<BinaryTreeNode<Integer>> itr = queue1.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next().data + " ");
		}
	}

	public static LinkedList<BinaryTreeNode<Integer>> q2 = new LinkedList<>();

	public static LinkedList<BinaryTreeNode<Integer>> TakeQueueDSforBTDS(BinaryTreeNode<Integer> root) {
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
			if (currentRoot.left != null) {
				q1.addLast(currentRoot.left);
				ans.addLast(currentRoot.left);
			}
			if (currentRoot.right != null) {
				q1.addLast(currentRoot.right);
				ans.addLast(currentRoot.right);
			}
		}
		return ans;
	}

	public static int HeightUsingQueue(BinaryTreeNode<Integer> root) {
		LinkedList<BinaryTreeNode<Integer>> q1 = new LinkedList<>();
		q1.addLast(root);
		q2.addLast(root);
		q1.addLast(null);
		q2.addLast(null);
		int level = 0;
		while (!q1.isEmpty()) {
			BinaryTreeNode<Integer> currentRoot = q1.removeFirst();
			if (currentRoot == null) {
				if (q1.isEmpty()) {
					break;
				} else {
					q1.addLast(null);
					q2.addLast(null);
					level++;
					continue;
				}
			}
			if (currentRoot.left != null) {
				q1.addLast(currentRoot.left);
				q2.addLast(currentRoot.left);
			}
			if (currentRoot.right != null) {
				q1.addLast(currentRoot.right);
				q2.addLast(currentRoot.right);
			}
		}
		return level;
	}

	public static void PrintLevelwiseArrayList(ArrayList<BinaryTreeNode<Integer>> A) {
		System.out.println();
		ArrayList<BinaryTreeNode<Integer>> A1 = new ArrayList<>();
		ArrayList<ArrayList<BinaryTreeNode<Integer>>> A11 = new ArrayList<>();
		int s = 0;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == null) {
				// A1.clear();
				System.out.println();
				s++;
			} else {
				System.out.print(A.get(i).data + " ");
				A1.add(A.get(i));
			}
			// levelwithNodes.put(s, A1);
		}
		System.out.println();
	}

	public static void PrintLL(Node<BinaryTreeNode<Integer>> head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.data.data + " ");
			head = head.next;
		}

	}

	public static Node<BinaryTreeNode<Integer>> CreateSingleLinkedListNodeUsingArrayList(
			List<BinaryTreeNode<Integer>> A) {
		Node<BinaryTreeNode<Integer>> head = null;
		Node<BinaryTreeNode<Integer>> tail = null;

		for (int i = 0; i < A.size(); i++) {
			Node<BinaryTreeNode<Integer>> current = new Node(A.get(i));
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

	public static HashMap<Integer, ArrayList<BinaryTreeNode<Integer>>> levelwithNodes = new HashMap<>();

	public static ArrayList<BinaryTreeNode<Integer>> TakeArrayListforPrintLevelTraversal(
			LinkedList<BinaryTreeNode<Integer>> q) {
		ArrayList<BinaryTreeNode<Integer>> NodesList = new ArrayList<>();

		Iterator<BinaryTreeNode<Integer>> itr = q.iterator();
		while (itr.hasNext()) {

			NodesList.add(itr.next());

		}

		return NodesList;
	}

	public static int Previous(int i, ArrayList<BinaryTreeNode<Integer>> A) {
		int ans = 0;
		if (i == A.indexOf(null)) {
			return 0;
		}
		// System.out.println(A.indexOf(null));
		for (int j = i - 1; j > 0; j--) {
			if (A.get(j) == null) {
				ans = j + 1;
				break;
			}
		}

		return ans;
	}

	public static int Next(int i, ArrayList<BinaryTreeNode<Integer>> A) {
		return i - 1;
	}

	public static ArrayList<List<BinaryTreeNode<Integer>>> TakeListofListfromAL(
			ArrayList<BinaryTreeNode<Integer>> ALWN) {
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> TakeBreakingNumber = new ArrayList<Integer>();
		ArrayList<List<BinaryTreeNode<Integer>>> Ans = new ArrayList<>();
		for (int i = 0; i < ALWN.size(); i++) {
			if (ALWN.get(i) == null)
				TakeBreakingNumber.add(i);
		}
		// System.out.println(TakeBreakingNumber);
		for (int i = 0; i < TakeBreakingNumber.size(); i++) {
			ans.add(Previous(TakeBreakingNumber.get(i), ALWN));
			ans.add(Next(TakeBreakingNumber.get(i), ALWN));
		}
		System.out.println(ans);
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

	public static ArrayList<Node<BinaryTreeNode<Integer>>> ListwithLevelList = new ArrayList<>();

	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
		ArrayList<BinaryTreeNode<Integer>> ALwithNull = TakeArrayListforPrintLevelTraversal(TakeQueueDSforBTDS(root));
		// for(int i=0;i<ALwithNull.size();i++) {
		// if(ALwithNull.get(i)!=null) {
		// System.out.println(ALwithNull.get(i).data);
		// }
		// else {
		// //System.out.println(i+" Null index");
		// }
		// }
		ArrayList<List<BinaryTreeNode<Integer>>> SaperatedListofList = TakeListofListfromAL(ALwithNull);
		// System.out.println("######");
		// System.out.println(SaperatedListofList);
		for (int i = 0; i < SaperatedListofList.size(); i++) {
			ListwithLevelList.add(CreateSingleLinkedListNodeUsingArrayList(SaperatedListofList.get(i)));
		}
		// Test cases
		// 1 2 3 4 -1 -1 7 8 -1 -1 9 -1 -1 -1 -1
		// 1
		// 2 3
		// 4 7
		// 8 9

		// 1 -1 2 3 4 -1 -1 5 6 -1 -1 7 8 -1 -1 -1 -1
		// 1
		// 2
		// 3 4
		// 5 6
		// 7 8

		// 1 2 3 4 6 -1 8 5 -1 -1 7 -1 9 -1 -1 -1 -1 -1 -1
		// 1
		// 2 3
		// 4 6 8
		// 5 7 9

		return ListwithLevelList;
	}

	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> Ans = null;

		return Ans;
	}

	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {

		// Write your code here

	}

	public static void main(String[] args) {
		// BinaryTreeNode<Integer> root = CreateBT();
		BinaryTreeNode<Integer> root = CreateBTusingQueue();
		// System.out.println("Enter the node to find in binary tree....");
		// int node = scanner.nextInt();
		PrintwithLeftRightChild(root);
		System.out.println();
		PrintBT(root);
		System.out.println("Sum = " + sumofAllNodes(root));

		ArrayList<Node<BinaryTreeNode<Integer>>> LLforLevelTrevarsal = LLForEachLevel(root);
		for (int i = 0; i < LLforLevelTrevarsal.size(); i++) {
			PrintLL(LLforLevelTrevarsal.get(i));
		}
		System.out.println(checkBalanced(root));
		// // System.out.println("Is Node present = " + isNodePresent(root, node));
		// // System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
		// // System.out.println("Search node is present = " + search(root, node));
		// // PrintBT(CreateBTusingQueue());
		// // System.out.println("%%%%%%%%%%%%%%%%%%%%");
		// // PrintBTusingQueue(CreateBTusingQueueReturnLL());
		// // System.out.println("$$$$$$$$$$$$$$$$$$$$");
		// // PrintwithLeftRightChild(CreateBTusingQueue());
		// PrintLevelTraversalUsingQueue(root);
		// // PrintLevelTraversalUsingQueue(root1);
		// System.out.println("\nHeight of Binary Tree is " + HeightofBT(root));
		// System.out.println("Height using Queue is " + HeightUsingQueue(root));
		// System.out.println(q2);
		// //PrintLevelwiseArrayList(PrintLevelTraversal(q2));
		// System.out.println(levelwithNodes);
		// ArrayList<Integer> A = new ArrayList<>();
		// A.add(1); A.add(2); A.add(3); A.add(4);
		// // PrintLL(CreateSingleLinkedListNodeUsingArrayList(A));
		scanner.close();
	}
}
