// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22752179

// Given a sorted linked list, delete all duplicates such that each element appear only once.
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3. 

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

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = head;
		ListNode cur = head.next;

		while (cur != null) {
			if (cur.val != pre.val) {
				pre = cur;
				cur = cur.next;
				continue;
			}

			while (cur.next != null && cur.next.val == pre.val) {
				cur = cur.next;
			}

			pre.next = cur.next;
			cur = pre.next;
		}

		return head;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList slt = new RemoveDuplicatesFromSortedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		
		ListNode res = slt.deleteDuplicates(n1);
		
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
