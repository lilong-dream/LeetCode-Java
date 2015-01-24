// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22864861

// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// You are given a target value to search. 
// If found in the array return its index, otherwise return -1.
// You may assume no duplicate exists in the array.

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		int left = 0;
		int right = A.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (A[mid] == target) {
				return mid;
			}

			if (A[mid] >= A[left]) { 
				if (A[mid] > target && A[left] <= target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (A[mid] < target && A[right] >= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 2 };

		SearchInRotatedSortedArray slt = new SearchInRotatedSortedArray();
		System.out.println(slt.search(a, 1));
		System.out.println(slt.search(a, 4));
	}
}
