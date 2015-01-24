// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/sort-list/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20284389

//Sort a linked list in O(n log n) time using constant space complexity.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class SortList {
    public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null) {
			fast = fast.next.next;
			if (fast == null) {
				break;
			}

			slow = slow.next;
		}

		ListNode right = slow.next;
		slow.next = null;

		ListNode left = sortList(head);
		right = sortList(right);

		return merge(left, right);
    }
    
    // Reuse Merge Two Sorted Lists
    public ListNode merge(ListNode left, ListNode right) {
    	MergeTwoSortedLists helper = new MergeTwoSortedLists();
    	return helper.mergeTwoLists(left, right);
    }
    
    public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		SortList slt = new SortList();
		ListNode n1 = new ListNode(8);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		System.out.println("Before sort:");
		slt.printList(n1);
		
		ListNode res = slt.sortList(n1);
		System.out.println("After sort:");
		slt.printList(res);
	}
}
