import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/4/19 23:17
 */
public class Solution0151 {

    /** 0151 Reverse Words in a String **/
    public String reverseWords(String s) {
        s = s.trim();
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 9 ms, faster than 26.53% of Java online submissions for Reverse Words in a String.
     * Memory Usage: 38.8 MB, less than 84.67% of Java online submissions for Reverse Words in a String.
     */

    /**
     * 用栈实现
     */
    public String reverseWords02(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ')
            left++;
        while (left <= right && s.charAt(right) == ' ')
            right--;
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (word.length() != 0 && c == ' ') {
                stack.push(word.toString());
                word.setLength(0);
            } else if (c != ' '){
                word.append(c);
            }
            left++;
        }
        stack.push(word.toString());
        StringBuilder res = new StringBuilder();
        for (int i = stack.size(); i > 0; i--) {
            res.append(stack.pop());
            if (i != 1) res.append(" ");
        }
        return res.toString();
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 4 ms, faster than 83.73% of Java online submissions for Reverse Words in a String.
     * Memory Usage: 38.4 MB, less than 99.77% of Java online submissions for Reverse Words in a String.
     */
}
