package com.greatlearning.bsttoskewedtree;

public class SkewedTree {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	// BST into a skewed tree
	static void BSTToSkewed(Node root, int order) {
		if (root == null) {
			return;
		}
		// To check the order in which the skewed tree to be maintained
		if (order > 0) {
			BSTToSkewed(root.right, order);
		} else {
			BSTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		// To check if the root Node of the skewed tree is not defined
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		// Recurse for the left / right subtree on the basis of the order required
		if (order > 0) {
			BSTToSkewed(leftNode, order);
		} else {
			BSTToSkewed(rightNode, order);
		}
	}

	// Traverse the right skewed tree using recursion
	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		SkewedTree tree = new SkewedTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);
		
		int order = 0; // Order of the Skewed tree
		BSTToSkewed(node, order);
		traverseRightSkewed(headNode);
	}
}
