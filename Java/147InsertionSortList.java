// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/insertion-sort-list/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20070531

// Sort a linked list using insertion sort.

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode node = head;
		ListNode cur = null;
		
		while (node.next != null) {
			cur = node.next;
			
			if (cur.val >= node.val) {  // in the end 
				node = node.next;
				continue;
			}
			
			node.next = cur.next;  // delete the node

			if (cur.val <= head.val) {  // in the beginning 
				cur.next = head;
				head = cur;
				continue;
			}

			ListNode pos = findInsertPos(head, cur);

			cur.next = pos.next;
			pos.next = cur;
		}

		return head;
	}

	ListNode findInsertPos(ListNode head, ListNode node) {  // not in the beginning or end
		ListNode pos = head;
		while (head != null && head.val < node.val) {
			pos = head;
			head = head.next;
		}

		return pos;
	}

	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		InsertionSortList slt = new InsertionSortList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		slt.printList(n1);
		ListNode res = slt.insertionSortList(n1);
		slt.printList(res);
	}
}
