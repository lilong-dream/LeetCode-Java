// Problem:  http://oj.leetcode.com/problems/search-for-a-range/ 
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22893675
// 1988lilong@163.com

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int left = 0;
		int right = A.length - 1;

		int[] result = { -1, -1 };

		while (left <= right) {
			int mid = (left + right) / 2;

			if (A[mid] > target) {
				right = mid - 1;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				result[0] = mid;
				result[1] = mid;

				int i = mid - 1;
				while (i >= 0 && A[i] == target) {
					result[0] = i;
					--i;
				}

				i = mid + 1;
				while (i < A.length && A[i] == target) {
					result[1] = i;
					++i;
				}

				break;
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		int[] A = { 1, 3, 4, 5, 5 };

		SearchForARange slt = new SearchForARange();
		int[] result = slt.searchRange(A, 5);
		System.out.println(result[0] + " " + result[1]);
	}
}