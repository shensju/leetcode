import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shensju
 * @Date: 2021/3/11 22:49
 */
public class Solution0078 {

    /** 0078 Subsets **/
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            temp.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    temp.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

    /**
     * 时间复杂度：O(n * 2^n)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
     * Memory Usage: 39.7 MB, less than 21.52% of Java online submissions for Subsets.
     */
}
