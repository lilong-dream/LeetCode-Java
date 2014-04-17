// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/merge-two-sorted-lists/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20075857

// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists.

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

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode node = null;
		ListNode head = null;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				if (node == null) {
					node = l1;
					head = node;
				} else {
					node.next = l1;
					node = node.next;
				}

				l1 = l1.next;
			} else {
				if (node == null) {
					node = l2;
					head = node;
				} else {
					node.next = l2;
					node = node.next;
				}

				l2 = l2.next;
			}
		}

		if (l1 != null) {
			node.next = l1;
		} else if (l2 != null) {
			node.next = l2;
		}

		return head;
	}

	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(7);
		a1.next = a2;
		a2.next = a3;

		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(4);
		b1.next = b2;

		MergeTwoSortedLists slt = new MergeTwoSortedLists();
		ListNode res = slt.mergeTwoLists(a1, b1);
		slt.printList(res);
	}
}
