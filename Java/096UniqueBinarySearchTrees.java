// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/unique-binary-search-trees/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22754969

// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
// For example,
// Given n = 3, there are a total of 5 unique BST's. 
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[] num = new int[n + 1];
		num[0] = 1;
		num[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				num[i] += num[j - 1] * num[i - j];
			}
		}

		return num[n];
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees slt = new UniqueBinarySearchTrees();
		int res = slt.numTrees(3);
		System.out.println(res);
	}
}
