import java.util.*;

/**
 * @Author: shensju
 * @Date: 2021/2/5 23:11
 */
public class Solution0015 {

    /** 0015 3Sum **/
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 对数组进行非递减排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; first++) {
            // 需要和上次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; second++) {
                // 需要和上次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果指针重合，退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度：O(n^2)  空间复杂度：O(n)，用于数组排序
     * Runtime: 18 ms, faster than 88.44% of Java online submissions for 3Sum.
     * Memory Usage: 43.3 MB, less than 51.88% of Java online submissions for 3Sum.
     */
}
