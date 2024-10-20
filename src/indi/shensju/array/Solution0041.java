package indi.shensju.array;

/**
 * @author shensju
 * @date 2024/10/20 16:36
 * 0041 First Missing Positive 缺失的第一个正数
 */
public class Solution0041 {

    /** 方法一：标记法，时间复杂度 O(n)，空间复杂度 O(1) **/
    public int firstMissingPositive01(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /** 方法一：置换法，时间复杂度 O(n)，空间复杂度 O(1) **/
    public int firstMissingPositive02(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
