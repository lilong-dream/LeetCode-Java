// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/longest-common-prefix/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22886331

// Write a function to find the longest common prefix string amongst an array of strings.

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs != null && strs.length == 0) {
			return "";
		}

		for (int i = 0; i < strs[0].length(); ++i) {
			for (int j = 1; j < strs.length; ++j) {
				if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}

		return strs[0];
	}
	
	public static void main(String[] args) {
		String[] strs = { "abc", "acd", "ade" };

		LongestCommonPrefix slt = new LongestCommonPrefix();
		System.out.println(slt.longestCommonPrefix(strs));
	}
}
