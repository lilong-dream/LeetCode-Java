// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/3sum/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/21645437

// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
// Find all unique triplets in the array which gives the sum of zero.
// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
// The solution set must not contain duplicate triplets.
// For example, given array S = {-1 0 1 2 -1 -4},
// A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)

import java.util.ArrayList;
import java.util.Arrays;

public class Sum3 {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; ++i) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			
			int j = i + 1;
			int k = num.length - 1;

			while (j < k) {
				if (num[i] + num[j] + num[k] > 0) {
					--k;
				} else if (num[i] + num[j] + num[k] < 0) {
					++j;
				} else {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[j]);
					tmp.add(num[k]);

					result.add(tmp);
					
					--k;
					++j;
					
					while (j < k && num[j] == num[j - 1]) {
						++j;
					}
					while (j < k && num[k] == num[k + 1]) {
						--k;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] num = { -1, 0, 1, 2, -1, -4 };
		
		Sum3 slt = new Sum3();
		ArrayList<ArrayList<Integer>> result = slt.threeSum(num);

		for (ArrayList<Integer> array : result) {
			System.out.println(array);
		}
	}
}
