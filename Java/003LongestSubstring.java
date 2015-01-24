// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19431417

// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
// For "bbbbb" the longest substring is "b", with the length of 1.

public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		if (length == 1) {
			return 1;
		}

		int longest = 0;
		int len = 0;
		String tmp;

		for (int i = 0; i < length; ++i) {
			if (longest >= length - i) {  // (1)
				break; 					  // no need to go on
			}
			
			len = 0;
			for (int j = i + 1; j < length; ++j) {
				++len;

				tmp = s.substring(i, j);
				int index = tmp.indexOf(s.charAt(j));
				if (index != -1) {
					i += index;
					// compare following items
					int k = j;  // in order to make it clear(works well without k)
					while ((++k < length) && (s.charAt(i + 1) == s.charAt(k))) {
						++i;
					}

					if (longest < len) {
						longest = len;
					}

					break;
				}

				if (j == length - 1) {
					longest = len + 1;  // this is true because of (1)
					break;              // to make it clear, do like this: 
							            // if (longest < len + 1) longest = len + 1;
				}
			}
		}

		return longest;
	}

	public static void main(String[] args) {
		LongestSubstring slt = new LongestSubstring();
		int len = slt.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybl"
				+ "dbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
		System.out.println(len);
	}
}
