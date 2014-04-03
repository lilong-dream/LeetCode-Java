// Problem:  http://oj.leetcode.com/problems/path-sum/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22875143
// 1988lilong@163.com

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return root.val == sum;
		}

		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
//		 	 5
//          / \
//         4   8
//        /   / \
//       11  13  4

		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;

		PathSum slt = new PathSum();
		System.out.println(slt.hasPathSum(n1, 20));
		System.out.println(slt.hasPathSum(n1, 21));
	}
}