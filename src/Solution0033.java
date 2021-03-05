/**
 * @Author: shensju
 * @Date: 2021/3/5 23:06
 */
public class Solution0033 {

    /** 0033 Search in Rotated Sorted Array **/
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            if (nums[l] <= nums[m]) {
                // 数组左半部分有序
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // 数组右半部分有序
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 时间复杂度：O(logn)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
     * Memory Usage: 38.1 MB, less than 93.45% of Java online submissions for Search in Rotated Sorted Array.
     */
}
