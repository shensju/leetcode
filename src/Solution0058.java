import java.util.Arrays;

/**
 * @Author: shensju
 * @Date: 2021/1/14 21:16
 */
public class Solution0058 {

    /**0058 Length of Last Word**/
    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int l = -1;
        int r = -1;
        boolean flag = false;
        while (i >= 0) {
            if (!flag && !(s.charAt(i) == 32)){
                r = i;
                flag = true;
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
}
