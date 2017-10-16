import java.util.regex.*;

//My solution
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
        	return 0;
        }
        if (Pattern.matches(" *", s)) {
        	return 0;
        }
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}

/*
An easier solution

public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
} 
*/