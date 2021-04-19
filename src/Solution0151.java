import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
