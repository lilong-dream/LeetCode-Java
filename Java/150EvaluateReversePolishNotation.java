// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20204273

// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
// Some examples:
// ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
// ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		String operators = "+-*/";
		Stack<String> s = new Stack<String>();

		for (String str : tokens) {
			if (operators.contains(str)) {
				int num2 = Integer.valueOf(s.pop());
				int num1 = Integer.valueOf(s.pop());

				int index = operators.indexOf(str);
				switch (index) {
				case 0:
					s.push(String.valueOf(num1 + num2));
					break;
				case 1:
					s.push(String.valueOf(num1 - num2));
					break;
				case 2:
					s.push(String.valueOf(num1 * num2));
					break;
				case 3:
					s.push(String.valueOf(num1 / num2));
					break;
				}
			} else {
				s.push(str);
			}
		}

		return Integer.valueOf(s.pop());
	}

	public static void main(String[] args) {
		String[] s = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17",
				"+", "5", "+" };
		EvaluateReversePolishNotation slt = new EvaluateReversePolishNotation();
		System.out.println(slt.evalRPN(s));
	}
}
