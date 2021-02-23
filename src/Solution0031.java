import java.util.Arrays;

/**
 * @Author: shensju
 * @Date: 2021/2/22 22:46
 */
public class Solution0031 {

    /** 0031 Next Permutation **/
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        return;
                    }
                }
            }
        }
        // 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）
        Arrays.sort(nums);
        return;
    }

    /**
     * 时间复杂度：O(n^2)  空间复杂度：O(1)
     * Runtime: 1 ms, faster than 54.82% of Java online submissions for Next Permutation.
     * Memory Usage: 39.1 MB, less than 76.40% of Java online submissions for Next Permutation.
     */
}
