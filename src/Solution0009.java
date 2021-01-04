/**
 * @Author: shensju
 * @Date: 2021/1/3 23:46
 */
public class Solution0009 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x;
        int help = 1;
        while (temp >= 10) {
            temp /= 10;
            help *= 10;
        }
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }
}
