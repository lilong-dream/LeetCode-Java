// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/add-two-numbers/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19544995

// You are given two linked lists representing two non-negative numbers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		int len1 = 0;
		int len2 = 0;

		ListNode head = l1;

		while (head != null) {
			++len1;
			head = head.next;
		}

		head = l2;

		while (head != null) {
			++len2;
			head = head.next;
		}

		ListNode longer = len1 >= len2 ? l1 : l2;
		ListNode shorter = len1 < len2 ? l1 : l2;

		ListNode result = null;
		ListNode sum = null;

		int val = 0;
		int carry = 0;

		while (shorter != null) {
			val = longer.val + shorter.val + carry;
			carry = val / 10;
			val -= carry * 10;
			
			if (sum == null) {
				sum = new ListNode(val);
				result = sum;
			} else {
				sum.next = new ListNode(val);
				sum = sum.next;
			}
			
			longer = longer.next;
			shorter = shorter.next;
		}

		while (longer != null) {
			val = longer.val + carry;
			carry = val / 10;
			val -= carry * 10;
			
			sum.next = new ListNode(val);
			sum = sum.next;
			
			longer = longer.next;
		}

		if (carry != 0) {
			sum.next = new ListNode(carry);
		}

		return result;
	}

	public void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
	}
    
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);

		l1.next = n2;
		n2.next = n3;

		ListNode l2 = new ListNode(5);
		ListNode n4 = new ListNode(6);
		ListNode n5 = new ListNode(4);
		l2.next = n4;
		n4.next = n5;

		AddTwoNumbers slt = new AddTwoNumbers();
		ListNode result = slt.addTwoNumbers(l1, l2);
		slt.print(result);
	}
}
