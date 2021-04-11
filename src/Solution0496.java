import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/4/11 23:36
 */
public class Solution0496 {

    /** 0496 Next Greater Element I **/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] result = new int[n1];
        for (int i = 0; i < n1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 4 ms, faster than 51.21% of Java online submissions for Next Greater Element I.
     * Memory Usage: 39.4 MB, less than 24.56% of Java online submissions for Next Greater Element I.
     */
}
