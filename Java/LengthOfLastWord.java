// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/length-of-last-word/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19840937

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