import java.util.Arrays;

/**
 * @Author: shensju
 * @Date: 2021/1/14 21:16
 */
public class Solution0058 {

    /**0058 Length of Last Word**/
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int l = -1;
        int r = -1;
        boolean flag = false;
        while (i >= 0) {
            if (!flag && !(s.charAt(i) == 32)){
                r = i;
                flag = true;
                continue;
            }
            if (flag) {
                if (s.charAt(i) == 32) {
                    l = i;
                    break;
                }
            }
            i--;
        }
        return r - l;
    }

    public int lengthOfLastWord02(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
