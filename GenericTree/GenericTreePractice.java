package GenericTree;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTreePractice {
	public static Scanner scanner = new Scanner(System.in);

	GTNode<Integer> CreateGenericTree() {
		// To create Generic tree we will take first root and then will take children
		// data..
		// To carry children in Tree Data structure we will use ArrayList...
		System.out.println("\nEnter data..");
		int data = scanner.nextInt();
		ArrayList<Integer> ALMAXwithChildrenData = new ArrayList<>();
		GTNode<Integer> root = new GTNode<Integer>(data);
		// here we take memory of data and create root node...
		System.out.println("Enter the number of Children..");
		int NofC = scanner.nextInt();
		// here take number of children from user and take memory of each children..
		for (int i = 0; i < NofC; i++) {
			root.Children.add(CreateGenericTree());
			// here we take data for children and store in Arraylist...
		}
		System.out.println("Data is gone in AL ...");
		System.out.println(root.Children.size());
		// here we print if root has children then print root and children list...
		// else print only root data...
		System.out.println("\nRoot = " + root.data);
		if (root.Children.size() > 0) {
			int sum = 0;
			System.out.print("Children = ");
			for (int i = 0; i < root.Children.size(); i++) {
				System.out.print(root.Children.get(i).data + " ");
				sum = sum + root.Children.get(i).data;
			}
			ALMAXwithChildrenData.add(root.data + sum);
			System.out.println(ALMAXwithChildrenData);
		} else {
			System.out.println("Children = 0");
		}
		// System.out.println(ALMAXwithChildrenData);
		return root;
	}

	GTNode<Integer> CreateGenericTree2() {
		// 5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
		System.out.println("Enter data...");
		int data = scanner.nextInt();
		GTNode<Integer> root = new GTNode<Integer>(data);
		LinkedList<GTNode<Integer>> q = new LinkedList<>();
		q.addLast(root);
		while (q.isEmpty()) {
			GTNode<Integer> current = q.removeFirst();
			System.out.println("Enter the number of Children...");
			int NofC = scanner.nextInt();
			for (int i = 0; i < NofC; i++) {
				System.out.println("Enter " + (i + 1) + "th child...");
				int childdata = scanner.nextInt();
				GTNode<Integer> child = new GTNode<Integer>(childdata);
				root.Children.add(child);
				q.addLast(child);
			}
		}
		return root;
	}

	// 10 4 20 2 70 0 80 2 90 0 100 0 30 1 120 0 40 2 130 0 140 1 150 0 50 3 160 0
	// 170 0 180 1 90 0
	// 10 3 20 30 40 2 40 50 0 0 0 0
	// 10 3 20 2 40 0 50 0 30 0 40 0
	public void PrintGenericTree(GTNode<Integer> root) {

		System.out.println(root.data);
		System.out.println(root.Children.size());
		for (int i = 0; i < root.Children.size(); i++) {
			PrintGenericTree(root.Children.get(i));
		}
	}

	void PrintLevelWise(GTNode<Integer> root) {
		System.out.println();
		System.out.println(root.data);
		if (root.Children.size() > 1) {
			for (int i = 0; i < root.Children.size(); i++) {
				System.out.print(root.Children.get(i).data);
				// PrintGenericTree(root.Children.get(i));
			}
		}
	}
	// 1 3 2 0 3 0 4 0
	// 10 3 20 2 30 0 40 0 50 0 60 0

	int NumberofNodesGreaterthanX(GTNode<Integer> root, int x) {

		int c = 0;
		// 10 3 20 2 30 0 40 0 50 0 60 0 10
		// use recursion we find greater then x elements in this method..

		for (int i = 0; i < root.Children.size(); i++) {
			// here start with loop if root has children..
			// call recursion and take value of c means counter...
			c = c + NumberofNodesGreaterthanX(root.Children.get(i), x);
		}
		if (root.data > x) {
			// check the condition if root data is greater then or not...
			c++;

		}
		// 40
		// 10 3 20 30 40 2 40 50 0 0 0 0

		return c;
	}

	int SumofAllGTNode(GTNode<Integer> root) {
		// in this method we have to find the sum of all nodes...
		// we take a variable "sum" and initialize with 0

		int sum = 0;
		sum = root.data;
		// initially we store the value of first root data...
		System.out.println(sum);
		for (int i = 0; i < root.Children.size(); i++) {
			// now we traverse recursivolly and get all children data
			// line 73 store data in every time store the data of children
			sum = sum + SumofAllGTNode(root.Children.get(i));
		}
		return sum;
	}

	public static boolean checkIfContainsX(GTNode<Integer> root, int x) {

		for (int i = 0; i < root.Children.size(); i++) {
			if (checkIfContainsX(root.Children.get(i), x)) {
				System.out.println("T");
				return true;
			}

		}
		return root.data == x;
	}

	static int MAX = 0;
	static int i1 = 0, i2 = 0;
	public static HashMap<Integer, GTNode<Integer>> HM = new HashMap<>();
	public static ArrayList<Integer> ALMaxNodewithChildren = new ArrayList<>();

	public static GTNode<Integer> maxSumNodehelper(GTNode<Integer> root) {
		for (int i = 0; i < root.Children.size(); i++) {
			maxSumNodehelper(root.Children.get(i));
		}
		if (root.Children.size() > 0) {

			int sum = 0;
			System.out.println("Root = " + root.data);
			System.out.print("Children = ");
			for (int i = 0; i < root.Children.size(); i++) {
				System.out.print(root.Children.get(i).data + " ");
				sum = sum + root.Children.get(i).data;
			}
			ALMaxNodewithChildren.add(root.data + sum);
			HM.put(ALMaxNodewithChildren.get(i1++), root);
			System.out.println("DATA = " + "Root =" + root.data + " " + ALMaxNodewithChildren.get(i1++));

			System.out.println();
		} else {
			System.out.println("Root = " + root.data);
			System.out.println("Chidrens =0");
		}

		return root;
	}

	public static GTNode<Integer> maxSumNode(GTNode<Integer> root) {
		// 5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
		// 5 3 1 1 15 0 2 2 4 0 5 0 3 1 6 0
		maxSumNodehelper(root);
		// System.out.println("Hashmap...");
		// System.out.println(HM);
		// System.out.println(HM.keySet());
		// System.out.println(HM.values());
		return MaxNode(HM);
	}

	public static int TotalNumberofNodes(GTNode<Integer> root) {
		int ans = 0;
		for (int i = 0; i < root.Children.size(); i++) {
			ans = ans + TotalNumberofNodes(root.Children.get(i));
		}
		ans++;
		return ans;
	}

	public static boolean checkIdenticalhelper(GTNode<Integer> root1, GTNode<Integer> root2) {
		// 10 3 20 2 30 0 40 0 50 0 60 0
		// 10 3 20 2 30 0 40 0 50 0 60 0
		for (int i = 0; i < root1.Children.size(); i++) {
			if (!checkIdenticalhelper(root1.Children.get(i), root2.Children.get(i))) {

				return false;
			}

		}
		return root1.data == root2.data;
	}

	public static boolean checkIdentical(GTNode<Integer> root1, GTNode<Integer> root2) {
		// return
		// (TotalNumberofNodes(root1)==TotalNumberofNodes(root2))?checkIdenticalhelper(root1,
		// root2):false;
		boolean ans = false;

		if (TotalNumberofNodes(root1) == TotalNumberofNodes(root2)) {
			ans = checkIdenticalhelper(root1, root2);
		}
		return ans;
	}

	public static GTNode<Integer> findSecondLargesthelper(GTNode<Integer> root) {
		for (int i = 0; i < root.Children.size(); i++) {
			findSecondLargesthelper(root.Children.get(i));
		}
		// if(root.Children.size()>0) {
		// System.out.println("Root = "+root.data);
		// System.out.print("Children = ");
		// for(int i=0;i<root.Children.size();i++) {
		// System.out.print(root.Children.get(i).data+" ");
		// }
		ALMaxNodewithChildren.add(root.data);
		HM.put(ALMaxNodewithChildren.get(i1++), root);
		// System.out.println("DATA = "+"Root ="+root.data+" "+
		// ALMaxNodewithChildren.get(i1++));

		// System.out.println();
		// }
		// else {
		// ALMaxNodewithChildren.add(root.data);
		// HM.put(ALMaxNodewithChildren.get(i1++), root);
		// System.out.println("Root = "+root.data);
		// System.out.println("Chidrens =0");
		// }
		return root;
	}

	public static GTNode<Integer> findSecondLargest(GTNode<Integer> root) {
		findSecondLargesthelper(root);
		// System.out.println("Array List of Root data = "+ALMaxNodewithChildren );
		System.out.println(ALMaxNodewithChildren);
		if (TotalNumberofNodes(root) == 1) {
			System.out.println("-2147483648");
			System.exit(0);

		}
		return SecondMaxNode(HM);
	}

	public static GTNode<Integer> SecondMaxNode(HashMap<Integer, GTNode<Integer>> HM) {
		ArrayList<Integer> list = new ArrayList<>(HM.keySet());
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		// if() {
		// return ;
		// }
		return HM.get(list.get(list.size() - 2));
	}

	public static GTNode<Integer> MaxNode(HashMap<Integer, GTNode<Integer>> HM) {
		ArrayList<Integer> list = new ArrayList<>(HM.keySet());
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		return HM.get(list.get(list.size() - 1));
	}

	public static void replaceWithDepthValue(GTNode<Integer> root) {
		// 1 1 2 2 30 4 1 5 1 60 1 70 1 8 1 9 1 100 0 0 2
		// 1 3 20 3 40 1 90 2 50 6 1 100 1 150 17 1000 2000 3000 4000 5000 6000 7000 85
		// 86 87 88 89 92 93 94 95 96 1 80 1 83 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
		// 1

		// 1 10 10 20 30 40 50 60 70 80 90 100 1 110 1 120 1 130 1 140 1 150 1 160 1 170
		// 1 180 1 190 1 200 1 220 0 0 0 0 0 0 0 0 0 1 230 1 270 2 300 390 0 0 2
	}

	// 3 2 2 0 4 3 5 0 6 0 7 0
	public static void main(String[] args) {
		GenericTreePractice GT = new GenericTreePractice();
		// GTNode<Integer> root11 = GT.CreateGenericTree2();
		GTNode<Integer> root22 = GT.CreateGenericTree();
		// GTNode<Integer> root1= GT.CreateGenericTree();
		// GTNode<Integer> root2= GT.CreateGenericTree();
		// 1 2 2 2 5 0 4 0 3 0
		// 1 2 2 3 2 5 4 0 0 0
		GT.PrintGenericTree(root22);
		// GT.PrintLevelWise(root);
		// System.out.println(GT.SumofAllGTNode(root));
		// System.out.println("\nEnter the value of x...");
		// int x=scanner.nextInt();
		// System.out.println(GT.NumberofNodesGreaterthanX(root, x));
		// System.out.println(checkIfContainsX(root, x));
		System.out.println("%%%%%%%%%%%%%%%%%%%%%");
		// System.out.println(maxSumNode(root22));
		// System.out.println( maxSumNode(root).data);
		// System.out.println(checkIdentical(root1, root2));
		// System.out.println("List = "+ALMaxNodewithChildren);
		// System.out.println(TotalNumberofNodes(root1));
		// System.out.println(findSecondLargest(root).data);
	}
}
