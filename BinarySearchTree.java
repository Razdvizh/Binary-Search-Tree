package src;

import java.util.Collection;

import java.util.LinkedList;

import java.util.Queue;

/**

* Source of definitions for traversals, properties and other operations

* {@link https://xlinux.nist.gov/dads/HTML/tree.html}

*/

public class BinarySearchTree<T extends Comparable<T>>

{

private TreeNode<T> root;

public BinarySearchTree()

{

root = null;

}

public BinarySearchTree(final Collection<? extends T> inCollection)

{

root = null;

for (final T e : inCollection)

{

add(e);

}

}

public void add(final T value)

{

root = add(value, root);

}

public TreeNode<T> remove(final T value)

{

return remove(value, root);

}

private TreeNode<T> add(final T value, TreeNode<T> tree)

{

if (tree == null)

{

tree = new TreeNode<T>(value);

return tree;

}

final T treeValue = tree.getValue();

final int dirTest = value.compareTo(treeValue);

if (dirTest <= 0)

{

tree.setLeft(add(value, tree.getLeft()));

}

else if (dirTest > 0)

{

tree.setRight(add(value, tree.getRight()));

}

return tree;

}

/*https://www.techiedelight.com/deletion-from-bst/ */

private TreeNode<T> remove(final T value, TreeNode<T> tree)

{

if (tree == null)

{

return null;

}

final T treeValue = tree.getValue();

final int dirTest = value.compareTo(treeValue);

if (dirTest < 0)

{

tree.setLeft(remove(value, tree.getLeft()));

}

else if (dirTest > 0)

{

tree.setRight(remove(value, tree.getRight()));

}

else

{

if (!tree.isFull())

{

return null;

}

else if (tree.isFull())

{

TreeNode<T> predecessor = tree.getLeft();

while (predecessor.hasRight())

{

predecessor = predecessor.getRight();

}

tree.setValue(predecessor.getValue());

tree.setLeft(remove(predecessor.getValue(), tree.getLeft()));

}

else

{

final TreeNode<T> child = tree.getLeft() != null ? tree.getLeft() : tree.getRight();

tree = child;

}

}

return tree;

}

public String inOrder()

{

return inOrder(root);

}

public String preOrder()

{

return preOrder(root);

}

public String postOrder()

{

return postOrder(root);

}

public String revOrder()

{

return revOrder(root);

}

public String levelOrder()

{

return levelOrder(root);

}

public boolean isFull()

{

return isFull(root);

}

public int getHeight()

{

return getHeight(root);

}

public T getSmallest()

{

return getSmallest(root);

}

/**

* Writes a copy of the smallest node to {@code outTree}

*/

public void getSmallestNode(TreeNode<T> outTree)

{

getSmallest(root, outTree);

}

public T getLargest()

{

return getLargest(root);

}

/**

* Writes a copy of the largest node to {@code outTree}

*/

public void getLargestNode(TreeNode<T> outTree)

{

getLargest(root, outTree);

}

public int getNumNodes()

{

return getNumNodes(root);

}

public int getNumLeaves()

{

return getNumLeaves(root);

}

public int getWidth()

{

return getWidth(root);

}

public boolean search(final T value)

{

return search(value, root);

}

private String inOrder(final TreeNode<T> tree)

{

if (tree != null)

{

return inOrder(tree.getLeft()) + tree.getValue() + " " + inOrder(tree.getRight());

}

return "";

}

private String preOrder(final TreeNode<T> tree)

{

if (tree != null)

{

return tree.getValue() + " " + preOrder(tree.getLeft()) + preOrder(tree.getRight());

}

return "";

}

private String postOrder(final TreeNode<T> tree)

{

if (tree != null)

{

return postOrder(tree.getLeft()) + postOrder(tree.getRight()) + tree.getValue() + " ";

}

return "";

}

private String revOrder(final TreeNode<T> tree)

{

if (tree != null)

{

return revOrder(tree.getRight()) + tree.getValue() + " " + revOrder(tree.getLeft());

}

return "";

}

private String levelOrder(TreeNode<T> tree)

{

if (tree != null)

{

Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();

String out = "";

queue.add(tree);

while (!queue.isEmpty())

{

tree = queue.poll();

out += tree.getValue() + " ";

if (tree.hasLeft())

{

queue.add(tree.getLeft());

}

if (tree.hasRight())

{

queue.add(tree.getRight());

}

}

return out;

}

return "";

}

private boolean isFull(final TreeNode<T> tree)

{

if (tree != null)

{

if (tree.hasLeft() && !tree.hasRight() || !tree.hasLeft() && tree.hasRight())

{

return false;

}

else

{

return isFull(tree.getLeft()) && isFull(tree.getRight());

}

}

return true;

}

private int getHeight(final TreeNode<T> tree)

{

if (tree == null)

{

return -1;

}

return getHeight(tree.getLeft()) > getHeight(tree.getRight()) ? getHeight(tree.getLeft()) + 1

: getHeight(tree.getRight()) + 1;

}

/**

* @return smallest value in the tree

*/

private T getSmallest(TreeNode<T> tree)

{

while (tree != null)

{

if (!tree.hasLeft())

{

return tree.getValue();

}

tree = tree.getLeft();

}

return null;

}

private void getSmallest(TreeNode<T> tree, TreeNode<T> outTree)

{

while (tree != null)

{

if (!tree.hasLeft())

{

outTree.setValue(tree.getValue());

outTree.setRight(tree.getRight());

outTree.setLeft(null);

return;

}

tree = tree.getLeft();

}

}

private T getLargest(TreeNode<T> tree)

{

while (tree != null)

{

if (!tree.hasRight())

{

return tree.getValue();

}

tree = tree.getRight();

}

return null;

}

private void getLargest(TreeNode<T> tree, TreeNode<T> outTree)

{

while (tree != null)

{

if (!tree.hasRight())

{

outTree.setValue(tree.getValue());

outTree.setLeft(tree.getLeft());

outTree.setRight(null);

return;

}

tree = tree.getRight();

}

}

private int getNumNodes(final TreeNode<T> tree)

{

if (tree != null)

{

return getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight()) + 1;

}

return 0;

}

private int getNumLeaves(final TreeNode<T> tree)

{

if (tree != null)

{

if (tree.isFull() || tree.hasLeft() || tree.hasRight())

{

return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());

}

else

{

return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight()) + 1;

}

}

return 0;

}

private int getWidth(TreeNode<T> tree)

{

int width = 0;

if (tree != null)

{

while (tree.hasLeft())

{

tree = tree.getLeft();

width++;

}

tree = root;

while (tree.hasRight())

{

tree = tree.getRight();

width++;

}

}

return width;

}

private boolean search(final T value, final TreeNode<T> tree)

{

if (tree != null)

{

final T treeValue = tree.getValue();

final int dirTest = value.compareTo(treeValue);

if (dirTest == 0)

{

return true;

}

if (dirTest < 0)

{

return search(value, tree.getLeft());

}

if (dirTest > 0)

{

return search(value, tree.getRight());

}

}

return false;

}

@Override

public String toString()

{

String[] tree = inOrder().split(" ");

String out = "[";

for (int i = 0; i < tree.length; i++)

{

if (i == tree.length - 1)

{

out += tree[i] + "]";

break;

}

out += tree[i] + ", ";

}

return "=============================================\n"

+ out

+ "\nHeight: " + getHeight()

+ "\nWidth: " + getWidth()

+ "\nNodes: " + getNumNodes()

+ "\nLeaves: " + getNumLeaves()

+ "\n=============================================\n";

}

}

final class TreeNode<T extends Comparable<T>>

{

private T value;

private TreeNode<T> left;

private TreeNode<T> right;

public TreeNode() {}

public TreeNode(final T inValue)

{

left = null;

right = null;

value = inValue;

}

public TreeNode(final T inValue, final TreeNode<T> inLeft, final TreeNode<T> inRight)

{

value = inValue;

left = inLeft;

right = inRight;

}

public TreeNode<T> getLeft()

{

return left;

}

public TreeNode<T> getRight()

{

return right;

}

public T getValue()

{

return value;

}

public void setValue(final T inValue)

{

value = inValue;

}

public TreeNode<T> setLeft(final TreeNode<T> inLeft)

{

final TreeNode<T> temp = left;

left = inLeft;

return temp;

}

public TreeNode<T> setRight(final TreeNode<T> inRight)

{

final TreeNode<T> temp = right;

right = inRight;

return temp;

}

public boolean hasLeft()

{

return left != null;

}

public boolean hasRight()

{

return right != null;

}

public boolean isFull()

{

return hasLeft() && hasRight();

}

@Override

public String toString()

{

return "[value: " + value + " leftNode: " + left + " rightNode: " + right + "]";

}

}