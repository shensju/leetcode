/**
 * @Author: shensju
 * @Date: 2021/4/21 23:36
 */
public class Solution0029 {

    /** 0029 Divide Two Integers **/
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) return dividend > Integer.MIN_VALUE ? -dividend : Integer.MAX_VALUE;
        int a = dividend;
        int b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) sign = -1;
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        int res = div(a, b);
        if (sign > 0)
            return res >= Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        else
            return res >= Integer.MAX_VALUE ? Integer.MIN_VALUE : -res;
    }

    private int div(int a, int b) {
        if (a < b) return 0;
        int tb = b;
        int count = 1;
        while ((tb + tb) <= a) {
            count = count + count;
            tb = tb + tb;
        }
        return count + divide(a - tb, b);
    }

}
