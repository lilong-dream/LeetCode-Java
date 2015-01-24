// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/maximum-subarray/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19846683

// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
// More practice:
// If you have figured out the O(n) solution, 
// try coding another solution using the divide and conquer approach, which is more subtle.

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
