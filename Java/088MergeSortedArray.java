// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/merge-sorted-array/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22677537

// Given two sorted integer arrays A and B, merge B into A as one sorted array.
// Note:
// You may assume that A has enough space (size that is greater or equal to m + n) 
// to hold additional elements from B. 
// The number of elements initialized in A and B are m and n respectively.

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int idx = m + n - 1;
		int i = m - 1;
		int j = n - 1;

		while (i >= 0 && j >= 0) {
			if (A[i] >= B[j]) {
				A[idx--] = A[i--];
			} else {
				A[idx--] = B[j--];
			}
		}

		if (i == -1) {
			while (j >= 0) {
				A[j] = B[j];
				j--;
			}
		}
	}

	public static void main(String[] args) {
		MergeSortedArray slt = new MergeSortedArray();
		int A[] = new int[5];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		int B[] = { 2, 4 };
		slt.merge(A, 3, B, 2);

		for (int i = 0; i < 5; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
