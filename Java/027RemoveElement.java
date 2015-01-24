// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/remove-element/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19759709

// Given an array and a value, 
// remove all instances of that value in place and return the new length.
// The order of elements can be changed. 
// It doesn't matter what you leave beyond the new length.
 
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int index = 0;
        for(int num : A) {
        	if(num != elem) {
        		A[index] = num;
        		++index;
        	}
        }
        
        return index;
    }
    
    public static void main(String[] args) {
		RemoveElement slt = new RemoveElement();
		int[] A = new int[] { 1, 2, 4, 2, 5 };
		System.out.println(slt.removeElement(A, 4));
    }
}
