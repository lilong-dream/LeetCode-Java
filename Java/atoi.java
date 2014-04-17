// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/string-to-integer-atoi/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19677643

public class atoi {
	public int atoi(String str) {
		String s = str.trim();

		if (s.length() == 0) {
			return 0;
		}

		long result = 0;

		int minusFlag = 0;

		int i = 0;
		if (s.charAt(0) == '-') {
			minusFlag = 1;
			++i;
		} else if (s.charAt(0) == '+') {
			++i;
		}

		for (; i < s.length(); ++i) {
			char tmp = s.charAt(i);
			if (tmp >= '0' && tmp <= '9') {
				result = result * 10 + (tmp - '0');

				if (result > INT_MAX) {
					if (minusFlag == 1) {
						return INT_MIN;
					}
					return INT_MAX;
				}
			} else {
				break;
			}
		}

		if (minusFlag == 1) {
			result = -result;
		}

		return (int)result;
	}

	static final int INT_MAX = 2147483647;
	static final int INT_MIN = -2147483648;

	public static void main(String[] args) { 
		atoi slt = new atoi();
		String str = " 04 ";
		int result = slt.atoi(str);
		System.out.print(result);
	}
}