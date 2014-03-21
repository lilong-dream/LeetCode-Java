// ÌâÄ¿£ºhttp://oj.leetcode.com/problems/climbing-stairs/
// ½âÎö£ºhttp://blog.csdn.net/lilong_dream/article/details/21650907
// 1988lilong@163.com

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
		int result = slt.climbStairs(0);
		System.out.println(result);
	}
}