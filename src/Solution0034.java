/**
 * @Author: shensju
 * @Date: 2021/3/2 23:39
 */
public class Solution0034 {

    /** 0034 Find First and Last Position of Element in Sorted Array **/
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        // 给定目标值在数组中的开始位置
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        // 给定目标值在数组中的结束位置
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                // 下一轮搜索区间是 [middle + 1, right]
                left = middle + 1;
            } else { // nums[middle] >= target
                // 下一轮搜索区间是 [left, middle]
                right = middle;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left + 1) / 2;
            if (nums[middle] > target) {
                // 下一轮搜索区间是 [left, middle - 1]
                right = middle - 1;
            } else {
                // 下一轮搜索区间是 [middle, right]
                left = middle;
            }
        }
        return left;
    }

    /**
     * 时间复杂度：O(logn)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * Memory Usage: 42.1 MB, less than 83.87% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     */
}
