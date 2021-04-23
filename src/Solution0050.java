/**
 * @Author: shensju
 * @Date: 2021/4/23 23:30
 */
public class Solution0050 {

    /** 0050 Pow(x, n) **/
    public double myPow(double x, int n) {
        // 为防止n为Integer.MIN_VALUE转为正数会溢出，使用long类型保存参数
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0)
            return 1.0;
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 时间复杂度：O(logn)  空间复杂度：O(logn)
     * Runtime: 1 ms, faster than 98.86% of Java online submissions for Divide Two Integers.
     * Memory Usage: 37.9 MB, less than 27.13% of Java online submissions for Divide Two Integers.
     */
}
