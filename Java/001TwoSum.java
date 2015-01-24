// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/two-sum/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19298357

// Given an array of integers, find two numbers such that they add up to a specific target number.
// The function twoSum should return indices of the two numbers such that they add up to the target, 
// where index1 must be less than index2. 
// Please note that your returned answers (both index1 and index2) are not zero-based.
// You may assume that each input would have exactly one solution.
// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2 

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	int[] num = numbers.clone();
        Arrays.sort(num);
        	
        int length = numbers.length;
        int left = 0;
        int right = length - 1;
        int sum = 0;
        
        ArrayList<Integer> index = new ArrayList<Integer>();
        
        while(left < right)
        {
        	sum = num[left] + num[right];
        	
            if(sum == target)
            {
            	for(int i = 0; i < length; ++i)
            	{
            		if(numbers[i] == num[left])
            		{
            			index.add(i+1);
            		}
            		else if(numbers[i] == num[right])
            		{
            			index.add(i+1);
            		}
            		if(index.size() == 2)
            		{
            			break;
            		}
            	}
                break;
            }
            else if(sum > target)
            {
                --right;
            }
            else
            {
                ++left;
            }
        }
        
        int[] result = new int[2];
   
        result[0] = index.get(0);
        result[1] = index.get(1);
        
        return result;
    }
    
    public static void main(String[] args)
    {
    	TwoSum slt = new TwoSum();
    	
    	int[] numbers = {0, 4, 3, 0};
    	int[] index = new int[2]; 	
    	index = slt.twoSum(numbers, 0);
    	
    	System.out.println("index1 = " + index[0] + ", index2 = " + index[1]);
    }
}
