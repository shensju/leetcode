package indi.shensju.array;

import java.util.Arrays;

/**
 * @author shensju
 * @date 2024/10/19 15:45
 * 0088 Merge Sorted Array 合并两个有序数组
 */
public class Solution0088 {
    /** 方法一：合并后排序，时间复杂度：O((m + n)log(m + n))，空间复杂度 O(1) **/
    public void merge01(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /** 方法二：双指针，从前往后，时间复杂度：O(m + n)，空间复杂度 O(m + n) **/
    public void merge02(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int k = 0;
        for (int i = 0, j = 0; i < m || j < n;) {
            if (i < m && j < n) {
                arr[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
            } else if (i < m) {
                arr[k++] = nums1[i++];
            } else if (j < n) {
                arr[k++] = nums2[j++];
            }
        }
        System.arraycopy(arr, 0, nums1, 0, m + n);
    }

    /** 方法三：双指针，从后往前，时间复杂度：O(m + n)，空间复杂度 O(1) **/
    public void merge03(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0;) {
            if (i >= 0 && j >= 0) {
                nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            } else if (i >= 0) {
                nums1[k--] = nums1[i--];
            } else if (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
