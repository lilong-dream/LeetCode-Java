// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/sqrtx/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20002071

// Implement int sqrt(int x).
// Compute and return the square root of x.

public class Sqrt {
	public int sqrt(int x) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (x < 2) {
			return x;
		}

		int low = 1;
		int high = x / 2;
		int mid = 0;
		int lastMid = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (x / mid > mid) { 
				low = mid + 1;
				lastMid = mid; 
			} else if (x / mid < mid) {
				high = mid - 1;
			} else {
				return mid;
			}
		}

		return lastMid;
	}

	public static void main(String[] args) {
		Sqrt slt = new Sqrt();
		int result = slt.sqrt(4);
		System.out.println(result);
	}
}
