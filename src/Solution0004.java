/**
 * @Author: shensju
 * @Date: 2021/2/4 23:06
 */
public class Solution0004 {

    /** 0004 Median of Two Sorted Arrays **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int index1 = 0, index2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (index1 < m && (index2 >= n || nums1[index1] < nums2[index2])) {
                right = nums1[index1++];
            } else {
                right = nums2[index2++];
            }
        }
        if (len % 2 == 0)
            return (left + right) / 2.0;
        return right;
    }

    /**
     * 时间复杂度：O(m + n)  空间复杂度：O(1)
     * Runtime: 2 ms, faster than 99.80% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 40.1 MB, less than 73.26% of Java online submissions for Median of Two Sorted Arrays.
     */
}
