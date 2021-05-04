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

    /** 方法一：递归 **/
    public double quickMul(double x, long N) {
        if (N == 0)
            return 1.0;
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 时间复杂度：O(logn)  空间复杂度：O(logn)
     * Runtime: 1 ms, faster than 98.86% of Java online submissions for Pow(x, n).
     * Memory Usage: 37.9 MB, less than 27.13% of Java online submissions Pow(x, n).
     */

    /** 方法二：迭代 **/
    public double quickMul02(double x, long N) {
        double res = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制的最低位为 1，则需要计入贡献
                res *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return res;
    }

    /**
     * 时间复杂度：O(logn)  空间复杂度：O(1)
     * Runtime: 1 ms, faster than 98.85% of Java online submissions for Pow(x, n).
     * Memory Usage: 36.7 MB, less than 83.87% of Java online submissions for Pow(x, n).
     */
}
