// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/minimum-path-sum/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20003925

// Given a m x n grid filled with non-negative numbers, 
// find a path from top left to bottom right which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] paths = new int[m][n];

		paths[0][0] = grid[0][0];

		for (int i = 1; i < m; ++i) {
			paths[i][0] = paths[i - 1][0] + grid[i][0];
		}

		for (int j = 1; j < n; ++j) {
			paths[0][j] = paths[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < m; ++i)
			for (int j = 1; j < n; ++j) {
				paths[i][j] = Math.min(paths[i - 1][j], paths[i][j - 1])
							+ grid[i][j];
			}

		return paths[m - 1][n - 1];
	}

	public static void main(String[] args) {
		MinimumPathSum slt = new MinimumPathSum();
		int[][] grid = new int[][] {{1, 2, 3}, {4, 5, 6}};
		int result = slt.minPathSum(grid);
		System.out.println(result);
	}
}
