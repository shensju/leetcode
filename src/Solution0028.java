/**
 * @Author: shensju
 * @Date: 2021/1/13 22:13
 */
public class Solution0028 {

    /**0028 Implement strStr()**/

    /**暴力求解**/
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }
}
