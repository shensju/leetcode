/**
 * @Author: shensju
 * @Date: 2021/1/5 22:15
 */
public class Solution0011 {

    /**0011 Container With Most Water**/
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
