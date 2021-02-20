import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shensju
 * @Date: 2021/2/20 23:29
 */
public class Solution0018 {

    /** 0018 4Sum **/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 枚举a
        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            // 枚举b
            for (int b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                // 枚举d
                int d = n - 1;
                // 枚举c
                for (int c = b + 1; c < n; c++) {
                    if (c > b + 1 && nums[c] == nums[c - 1]) continue;
                    while (c < d && nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    }
                    if (c == d) {
                        break;
                    }
                    if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度：O(n^3)  空间复杂度：O(n)，用于数组排序
     * Runtime: 30 ms, faster than 21.42% of Java online submissions for 4Sum.
     * Memory Usage: 41 MB, less than 16.18% of Java online submissions for 4Sum.
     */
}
