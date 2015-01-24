// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/set-matrix-zeroes/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22744137

// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution? 

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean row = false;
		boolean column = false;

		for (int i = 0; i < m; ++i) {
			if (matrix[i][0] == 0) {
				row = true;
				break;
			}
		}

		for (int j = 0; j < n; ++j) {
			if (matrix[0][j] == 0) {
				column = true;
				break;
			}
		}

		for (int i = 1; i < m; ++i)
			for (int j = 1; j < n; ++j) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}

		for (int i = 1; i < m; ++i) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; ++j) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < n; ++j) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < m; ++i) {
					matrix[i][j] = 0;
				}
			}
		}

		if (row) {
			for (int i = 0; i < m; ++i) {
				matrix[i][0] = 0;
			}
		}

		if (column) {
			for (int j = 0; j < n; ++j) {
				matrix[0][j] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		SetMatrixZeroes slt = new SetMatrixZeroes();
		int[][] matrix = new int[][]{ {1, 1, 1, 1},
								      {1, 0, 1, 1},
								      {1, 1, 1, 1},
								      {1, 1, 1, 0} };
		slt.setZeroes(matrix);
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
