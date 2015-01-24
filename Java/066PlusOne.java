// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/plus-one/ 
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22777347

// Given a non-negative number represented as an array of digits, plus one to the number.
// The digits are stored such that the most significant digit is at the head of the list.

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		int i = digits.length - 1;

		for (; i >= 0; --i) {
			digits[i] += carry;

			if (digits[i] >= 10) {
				digits[i] -= 10;
				carry = 1;
			} else {
				carry = 0;
				break;
			}
		}

		if (i < 0) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;

			System.arraycopy(digits, 0, result, 1, digits.length);

			return result;
		} else {
			return digits;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 9, 9 };
		PlusOne slt = new PlusOne();
		int[] b = slt.plusOne(a);
		for (int i = 0; i < b.length; ++i) {
			System.out.print(b[i]);
		}
	}
}
