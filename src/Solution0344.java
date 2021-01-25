/**
 * @Author: shensju
 * @Date: 2021/1/25 22:02
 */
public class Solution0344 {

    /**0344 Reverse String**/
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++; right--;
        }
    }
}
