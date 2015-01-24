// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19753021

// Given a linked list, remove the nth node from the end of list and return its head.
// For example,
// Given linked list: 1->2->3->4->5, and n = 2.
// After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass. 

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ListNode fast = head;
		ListNode slow = head;

		for (int i = 0; i < n; ++i) {
			fast = fast.next;
		}

		if (fast != null) {
			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
			slow.next = slow.next.next;

			return head;
		} else {
			return head.next;
		}
	}

	void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;

		RemoveNthNodeFromEnd slt = new RemoveNthNodeFromEnd();
		slt.print(a1);

		ListNode res = slt.removeNthFromEnd(a1, 2);
		slt.print(res);
	}
}
