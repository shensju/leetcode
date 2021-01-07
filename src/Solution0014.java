/**
 * @Author: shensju
 * @Date: 2021/1/7 20:21
 */
public class Solution0014 {

    /**0014 Longest Common Prefix**/
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < prefix.length() && j < strs[i].length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j))
                    break;
            }
            prefix = prefix.substring(0, j);
            if ("".equals(prefix)) return "";
        }
        return prefix;
    }
}
