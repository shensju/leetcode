/**
 * @Author: shensju
 * @Date: 2021/4/25 22:47
 */
public class Solution0069 {

    /** 0069 Sqrt(x) **/
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        // 使用二分查找法求解
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long) m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    /**
     * 时间复杂度：O(logn)  空间复杂度：O(1)
     * Runtime: 1 ms, faster than 99.97% of Java online submissions for Sqrt(x).
     * Memory Usage: 35.6 MB, less than 96.91% of Java online submissions for Sqrt(x).
     */
}
