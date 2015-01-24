// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/reverse-integer/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19674929

// Reverse digits of an integer.
// Example1: x = 123, return 321
// Example2: x = -123, return -321 

public class ReverseInteger {
	public int reverse(int x) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int result = 0;

		int flag = 0;
		if (x < 0) {
			flag = 1;
			x = -x;
		}

		int lastDigit = 0;
		
		while (x > 0) {
			lastDigit = x - x / 10 * 10;
			result = result * 10 + lastDigit;
			x /= 10;
		}

		if (flag == 1) {
			result = -result;
		}
		
		return result;
	}

	public static void main(String[] args) {
		ReverseInteger slt = new ReverseInteger();

		int x = 10;
		int res = slt.reverse(x);
		System.out.print(res);
	}
}
