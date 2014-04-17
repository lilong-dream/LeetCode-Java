// Problem:  http://oj.leetcode.com/problems/implement-strstr/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/23655843
// 1988lilong@163.com

public class ImplementStrStr {
	public String strStr(String haystack, String needle) {
		if (needle != null && needle.isEmpty()) {
			return haystack;
		}

		int len1 = haystack.length();
		int len2 = needle.length();
		if (len1 < len2) {
			return null;
		}

		for (int i = 0; i <= len1 - len2; ++i) {
			int j = 0;
			int k = i;
			while (j < len2 && needle.charAt(j) == haystack.charAt(k)) {
				j++;
				k++;
			}

			if (j == len2) {
				return haystack.substring(i);
			}
		}

		return null;
	}

	public static void main(String[] args) {
		ImplementStrStr slt = new ImplementStrStr();
		System.out.println(slt.strStr("abcdabc", "d"));
	}
}