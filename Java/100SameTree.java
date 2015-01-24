// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/same-tree/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22753227

// Given two binary trees, write a function to check if they are equal or not. 
// Two binary trees are considered equal if they are structurally identical 
// and the nodes have the same value.
 
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}

		return p.val == q.val && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;

		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(1);
		n3.right = n4;

		SameTree slt = new SameTree();
		System.out.println(slt.isSameTree(n1, n3));
	}
}
