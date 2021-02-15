/**
 * @Author: shensju
 * @Date: 2021/2/15 15:33
 */
public class Solution0027 {

    /** 0027 Remove Element **/
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     * Memory Usage: 37.4 MB, less than 89.71% of Java online submissions for Remove Element.
     */
}
