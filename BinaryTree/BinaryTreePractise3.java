package BinaryTree;

public class BinaryTreePractise3 extends BinaryTreePractice{
	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> Ans = null;

		return Ans;
	}

	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {

		// Write your code here

	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = CreateBT();
		PrintwithLeftRightChild(root);
		removeAllLeaves(root);
		printNodesWithoutSibling(root);
		PrintLevelTraversalUsingQueue(root);
	}
}
