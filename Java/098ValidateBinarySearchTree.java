// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/validate-binary-search-tree/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22780563

// Given a binary tree, determine if it is a valid binary search tree (BST). 
// Assume a BST is defined as follows: 
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		return root.val > min && root.val < max
				&& isValidBST(root.left, min, root.val)
				&& isValidBST(root.right, root.val, max);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;

		ValidateBinarySearchTree slt = new ValidateBinarySearchTree();
		System.out.println(slt.isValidBST(n1));
	}
}
