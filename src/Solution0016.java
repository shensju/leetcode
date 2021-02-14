import java.util.Arrays;

/**
 * @Author: shensju
 * @Date: 2021/2/6 15:05
 */
public class Solution0016 {

    /** 0016 3Sum Closest **/
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                // 判断最小值，减少双指针的移动次数
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(min - target) < Math.abs(result - target)) {
                        result = min;
                        break;
                    }
                }
                // 判断最大值，减少双指针的移动次数
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(max - target) < Math.abs(result - target)) {
                        result = max;
                        break;
                    }
                }
                int sum = nums[i] + nums[left] + nums[right];
                // 判断三数之和是否正好等于target
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    right--;
                    // 去重
                    while (left != right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    // 去重
                    while (left != right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度：O(n^2)  空间复杂度：O(n)，用于数组排序
     * Runtime: 2 ms, faster than 99.64% of Java online submissions for 3Sum Closest.
     * Memory Usage: 38.8 MB, less than 42.45% of Java online submissions for 3Sum Closest.
     */
}
