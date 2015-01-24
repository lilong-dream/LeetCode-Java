// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/generate-parentheses/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/23917967

// Given n pairs of parentheses, 
// write a function to generate all combinations of well-formed parentheses.
// For example, given n = 3, a solution set is:
// "((()))", "(()())", "(())()", "()(())", "()()()"

import java.util.ArrayList;

public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		generate(n, n, "", res);
		return res;
	}

	public void generate(int left, int right, String str, ArrayList<String> res) {
		if (left == 0 && right == 0) {
			res.add(str);
			return;
		}
		if (left > 0) {
			generate(left - 1, right, str + '(', res);
		}
		if (right > left) {
			generate(left, right - 1, str + ')', res);
		}
	}
	
	public static void main(String[] args) {
		GenerateParentheses slt = new GenerateParentheses();
		ArrayList<String> res = slt.generateParenthesis(3);
		for (String str : res) {
			System.out.println(str);
		}
	}
}
