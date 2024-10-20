package indi.shensju.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shensju
 * @date 2024/10/20 15:36
 * 0169 Majority Element 多数元素
 */
public class Solution0169 {

    /** 方法一：计数法，时间复杂度 o(n)，空间复杂度 O(n) **/
    public static int majorityElement01(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) != null) {
                int num = map.get(nums[i]);
                map.put(nums[i], ++num);
            } else {
                map.put(nums[i], 1);
            }
        }
        int count = n >> 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /** 方法二：排序法，时间复杂度 O(nlogn)，空间复杂度 O(1) **/
    public static int majorityElement02(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    /** 方法二：摩尔投票法，时间复杂度 O(n)，空间复杂度 O(1) **/
    public static int majorityElement03(int[] nums) {
        int n = nums.length;
        int count = 1;
        int major = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                if (count - 1 < 0) {
                    major = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return major;
    }
}
