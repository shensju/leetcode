/**
 * @Author: shensju
 * @Date: 2021/1/3 23:46
 */
public class Solution0009 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int len = (int) (Math.log10(x) + 1);
        if (len < 0) {
            return false;
        }
        int[] arr = new int[len];
        for (int i = 1; i <= len; i++) {
            arr[i-1] = x % 10;
            x /= 10;
        }
        for (int i = 0, j = len - 1; i != j && i < j; i++, j--) {
            if (arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }
}
