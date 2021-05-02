import java.util.Arrays;

/**
 * @Author: shensju
 * @Date: 2021/5/2 22:27
 */
public class Solution0207 {

    /** 0207 Contains Duplicate **/
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度：O(nlogn)  空间复杂度：O(logn)
     * Runtime: 4 ms, faster than 96.91% of Java online submissions for Contains Duplicate.
     * Memory Usage: 41.3 MB, less than 97.62% of Java online submissions for Contains Duplicate.
     */
}
