// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/climbing-stairs/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/21650907

// You are climbing a stair case. It takes n steps to reach to the top.
// Each time you can either climb 1 or 2 steps. 
// In how many distinct ways can you climb to the top?
		
public class ClimbingStairs {
    public int climbStairs(int n) {
		if (n == 0) {
			return 1;
		}

		int[] a = new int[n + 1];

		a[0] = 1;
		a[1] = 1;

		for (int i = 2; i <= n; ++i) {
			a[i] = a[i - 1] + a[i - 2];
		}

		return a[n];
	}

	public static void main(String[] args) {
		ClimbingStairs slt = new ClimbingStairs();
		int result = slt.climbStairs(3);
		System.out.println(result);
	}
}
