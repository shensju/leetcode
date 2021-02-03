/**
 * @Author: shensju
 * @Date: 2021/1/27 20:41
 */
public class Solution0125 {

    /** 0125 Valid Palindrome **/
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        while(l <= r) {
            while(l < s.length() && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(l >= s.length() || r < 0) break;
            char lc = Character.toLowerCase(s.charAt(l)), rc = Character.toLowerCase(s.charAt(r));
            if(lc != rc) return false;
            l++;
            r--;
        }
        return true;
    }
}
