/**
 * @Author: shensju
 * @Date: 2021/3/7 23:01
 */
public class Solution0088 {

    /** 0088 Merge Sorted Array **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] <= nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    /**
     * 时间复杂度：O(m + n)  空间复杂度：O(m)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
     * Memory Usage: 39.2 MB, less than 46.00% of Java online submissions for Merge Sorted Array.
     */
}
