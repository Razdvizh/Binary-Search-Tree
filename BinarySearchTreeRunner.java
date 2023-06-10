package src;

import java.util.Arrays;

public class BinarySearchTreeRunner 
{

	public static void main(String[] args) 
	{
		Integer[] x = {90, 80, 70, 85, 100, 98, 120};
		//						90
		//				80				100
		//			70		85		98		120
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>(Arrays.asList(x));
		testTree(myTree);
		
		for (int i = 0; i < x.length; i++)
		{
			final int num = (int)(Math.random() * 199) + 1;
			x[i] = num;
		}
		
		myTree = new BinarySearchTree<Integer>(Arrays.asList(x));
		testTree(myTree);
	}
	
	private static void testTree(final BinarySearchTree<Integer> tree)
	{
		System.out.println(tree.getClass().getName());
		System.out.println(tree);
		
		System.out.println("In order traversal: " + tree.inOrder());
		System.out.println("Pre order traversal: " + tree.preOrder());
		System.out.println("Post order traversal: " + tree.postOrder());
		System.out.println("Reverse order traversal: " + tree.revOrder());
		System.out.println("Level order traversal: " + tree.levelOrder());
		
		System.out.println(tree.isFull() ? "Tree is full" : "Tree is not full");
		System.out.println("Tree height is: " + tree.getHeight());
		System.out.println("Tree width is: " + tree.getWidth());
		System.out.println("Number of nodes is: " + tree.getNumNodes());
		System.out.println("Number of leaves is: " + tree.getNumLeaves());
		
		System.out.println("Smallest value is: " + tree.getSmallest());
		TreeNode<Integer> test = new TreeNode<Integer>();
		tree.getSmallestNode(test);
		System.out.println(test);
		
		System.out.println("Largest value is: " + tree.getLargest());
		test = new TreeNode<Integer>();
		tree.getLargestNode(test);
		System.out.println(test);
		
		//assert tree.search(80);
		int val = (int)(Math.random() * 119) + 1;
		System.out.println(tree.search(val) ? "Tree contains " + val : "Tree does not contain " + val);
		
		tree.remove(70);
		System.out.println("\nRemove 70:\n" + tree);
		
		tree.remove(100);
		System.out.println("Remove 100:\n" + tree);
		
		tree.remove(90);
		System.out.println("Remove 90:\n" + tree);
	}
}