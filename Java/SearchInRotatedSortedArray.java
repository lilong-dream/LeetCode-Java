// Problem:  http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22864861
// 1988lilong@163.com


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