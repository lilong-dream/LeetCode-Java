// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/unique-paths-ii/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19931301

// Follow up for "Unique Paths":
// Now consider if some obstacles are added to the grids. 
// How many unique paths would there be?
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
//  [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.
// Note: m and n will be at most 100.

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		// if (m == 0) {
		// 	   return 0;
		// }

		int n = obstacleGrid[0].length;

		if (obstacleGrid[0][0] == 1) {
			return 0;
		} else if (m == 1 && n == 1) {
			return 1;
		}

		int[][] paths = new int[m][n];

		for (int i = 0; i < m; ++i) {
			if (obstacleGrid[i][0] == 1) {
				while (i < m) {
					paths[i][0] = 0;
					++i;
				}
				break;
			} else {
				paths[i][0] = 1;
			}
		}

		for (int j = 1; j < n; ++j) {
			if (obstacleGrid[0][j] == 1) {
				while (j < n) {
					paths[0][j] = 0;
					++j;
				}
				break;
			} else {
				paths[0][j] = 1;
			}
		}

		for (int i = 1; i < m; ++i)
			for (int j = 1; j < n; ++j) {
				if (obstacleGrid[i][j] == 1) {
					paths[i][j] = 0;
				} else {
					paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
				}
			}

		return paths[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] obstacle = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		UniquePathsII slt = new UniquePathsII();
		int result = slt.uniquePathsWithObstacles(obstacle);
		System.out.println(result);
	}
}
