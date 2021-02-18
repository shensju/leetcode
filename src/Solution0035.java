/**
 * @Author: shensju
 * @Date: 2021/2/18 23:35
 */
public class Solution0035 {

    /** 0035 Search Insert Position **/
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return n;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
     * Memory Usage: 38.3 MB, less than 97.13% of Java online submissions for Search Insert Position.
     */
}
