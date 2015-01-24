// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/unique-paths/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19771225

// A robot is located at the top-left corner of a m x n grid.
// The robot can only move either down or right at any point in time. 
// The robot is trying to reach the bottom-right corner of the grid.
// How many possible unique paths are there?

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] A = new int[m][n];

		for (int i = 0; i < m; ++i) {
			A[i][0] = 1;
		}

		for (int i = 1; i < n; ++i) {
			A[0][i] = 1;
		}

		for (int i = 1; i < m; ++i)
			for (int j = 1; j < n; ++j) {
				A[i][j] = A[i][j - 1] + A[i - 1][j];
			}

		return A[m - 1][n - 1];
	}

	public static void main(String[] args) {
		UniquePaths slt = new UniquePaths();
		int uPath = slt.uniquePaths(3, 7);
		System.out.println(uPath);
	}
}
