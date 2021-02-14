/**
 * @Author: shensju
 * @Date: 2021/2/14 23:34
 */
public class Solution0026 {

    /** 0026 Remove Duplicates from Sorted Array **/
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) nums[++p] = nums[q];
            q++;
        }
        return p + 1;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 40.7 MB, less than 69.01% of Java online submissions for Remove Duplicates from Sorted Array.
     */
}
