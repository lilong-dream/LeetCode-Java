// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/length-of-last-word/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19840937

// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
// return the length of last word in the string.
// If the last word does not exist, return 0.
// Note: A word is defined as a character sequence consists of non-space characters only.
// For example, 
// Given s = "Hello World",
// return 5.
		
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        
        while(i >= 0 && s.charAt(i) == ' ') {
        	--i;
        }
        
        int length = 0;
        while(i >= 0 && s.charAt(i) != ' ') {
        	++length;
        	--i;
        }
        
    	return length;
    }
    
    public static void main(String[] args) {
    	String s = "Hello word ";
    	LengthOfLastWord slt = new LengthOfLastWord();
    	int result = slt.lengthOfLastWord(s);
    	System.out.println(result);
    }
}
