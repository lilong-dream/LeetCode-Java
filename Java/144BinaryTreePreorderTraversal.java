// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20306491

// Given a binary tree, return the preorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
// return [1,2,3].
//
// Note: Recursive solution is trivial, could you do it iteratively?

import java.util.ArrayList;
import java.util.Stack;

// Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreePreorderTraversal {
	// Recursive
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root != null) {
			result.add(root.val);

			result.addAll(preorderTraversal(root.left));

			result.addAll(preorderTraversal(root.right));
		}

		return result;
	}

	// iterative
	public ArrayList<Integer> preorderTraversalIter(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);

		while (!nodeStack.empty()) { 
			TreeNode node = nodeStack.pop();
			result.add(node.val);

			if (node.right != null) {
				nodeStack.push(node.right);
			}

			if (node.left != null) {
				nodeStack.push(node.left);
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		BinaryTreePreorderTraversal slt = new BinaryTreePreorderTraversal();
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		root.right = n2;
		n2.left = n3;
		
		ArrayList<Integer> res = slt.preorderTraversal(root);
		System.out.println(res.toString());
	}
}
