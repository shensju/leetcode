/**
 * @Author: shensju
 * @Date: 2021/1/11 22:45
 */
public class Solution0005 {

    /**0005 Longest Palindromic Substring**/
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) return s;
        int longest = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j - i + 1) > longest && validPalindromic(charArray, i, j)) {
                    longest = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + longest);
    }

    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
