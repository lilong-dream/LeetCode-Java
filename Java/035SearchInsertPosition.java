// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/search-insert-position/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19768455

// Given a sorted array and a target value, 
// return the index if the target is found. 
// If not, return the index where it would be if it were inserted in order.
// You may assume no duplicates in the array.
// Here are few examples.
// [1,3,5,6], 5 ¡ú 2
// [1,3,5,6], 2 ¡ú 1
// [1,3,5,6], 7 ¡ú 4
// [1,3,5,6], 0 ¡ú 0 

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int left = 0;
		int right = A.length - 1;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			if (A[mid] > target) {
				right = mid - 1;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}

		return left;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] { 1, 3, 5, 6 };
		SearchInsertPosition slt = new SearchInsertPosition();
		System.out.println(slt.searchInsert(A, 0));
	}
}
