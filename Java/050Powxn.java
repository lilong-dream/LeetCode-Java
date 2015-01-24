// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/powx-n/ 
// Analysis: http://blog.csdn.net/lilong_dream/article/details/21701775

// Implement pow(x, n). 

public class Powxn {
	public double pow(double x, int n) {
		if (n < 0) {
			return 1.0 / power(x, -n);
		} else {
			return power(x, n);
		}
	}

	public double power(double x, long n) {
		if (n == 0) {
			return 1;
		}

		double tmp = power(x, n / 2);

		if ((n & 0x01) == 1) {
			return tmp * tmp * x;
		} else {
			return tmp * tmp;
		}
	}

	public static void main(String[] args) {
		Powxn slt = new Powxn();
		
		System.out.println(slt.pow(2, 4));
	}
}
