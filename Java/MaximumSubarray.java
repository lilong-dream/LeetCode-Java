// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/maximum-subarray/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19846683

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		int thisSum = A[0] > 0 ? A[0] : 0;
		int maxSum = A[0];

		for (int i = 1; i < A.length; ++i) {
			thisSum += A[i];
			if (thisSum > maxSum) {
				maxSum = thisSum;
			}
			if (thisSum < 0) {
				thisSum = 0;
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] A = new int[] { -2, 1 }; 
		MaximumSubarray slt = new MaximumSubarray();
		int result = slt.maxSubArray(A);
		System.out.println(result);
	}
}