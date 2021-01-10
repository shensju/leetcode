import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shensju
 * @Date: 2021/1/10 19:47
 */
public class Solution0003 {

    /**0003 Longest Substring Without Repeating Characters**/
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s) || s.length() == 0) {
            return 0;
        }
        int longest = 0;
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (current.indexOf(String.valueOf(c)) == -1) {
                current.append(String.valueOf(c));
                longest = current.length() > longest ? current.length() : longest;
            } else {
                current.delete(0, current.indexOf(String.valueOf(c)) + 1);
                current.append(String.valueOf(c));
            }
        }
        return longest;
    }

    /**滑动窗口**/
    public static int lengthOfLongestSubstring02(String s) {
        if (s == null || "".equals(s) || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            longest = Math.max(longest, i - left + 1);
        }
        return longest;
    }
}
