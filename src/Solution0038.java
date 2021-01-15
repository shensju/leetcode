/**
 * @Author: shensju
 * @Date: 2021/1/15 23:42
 */
public class Solution0038 {

    /**0038 Count and Say**/
    public String countAndSay(int n) {
        StringBuilder pre = new StringBuilder("1");
        StringBuilder cur = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            pre = cur;
            cur = new StringBuilder();
            int start = 0;
            int end = 0;
            while (end < pre.length()) {
                while (end < pre.length() && (pre.charAt(end) == pre.charAt(start))) end++;
                cur = cur.append(Integer.toString(end - start)).append(pre.charAt(start));
                start = end;
            }
        }
        return cur.toString();
    }
}
