// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/add-binary/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19995465

// Given two binary strings, return their sum (also a binary string).
// For example,
// a = "11"
// b = "1"
// Return "100".

public class AddBinary {
	public String addBinary(String a, String b) {
		char[] str1;
		char[] str2;

		if (a.length() >= b.length()) {
			str1 = a.toCharArray();
			str2 = b.toCharArray();
		} else {
			str1 = b.toCharArray();
			str2 = a.toCharArray();
		}

		int m = str1.length;
		int n = str2.length;

		char[] sum = new char[m];

		int i = m - 1;
		char carry = '0';

		--m;
		--n;

		while (n >= 0) {
			if (str1[m] == '0' && str2[n] == '0') {
				sum[i] = carry;
				carry = '0';
			} else if (str1[m] == '1' && str2[n] == '1') {
				sum[i] = carry;
				carry = '1';
			} else {
				if (carry == '1') {
					sum[i] = '0';
				} else {
					sum[i] = '1';
				}
			}

			--m;
			--n;
			--i;
		}

		while (m >= 0) {
			if (str1[m] == '1') {
				if (carry == '1') {
					sum[i] = '0';
				} else {
					sum[i] = '1';
				}

			} else {
				sum[i] = carry;
				carry = '0';
			}
			--m;
			--i;
		}

		String result = new String(sum);

		if (carry == '1') {
			return "1" + result;
		} 
		
		return result;
	}

	public static void main(String[] args) {
		String a = "11";
		String b = "10";

		AddBinary slt = new AddBinary();
		String result = slt.addBinary(a, b);
		System.out.println(result);
	}
}
