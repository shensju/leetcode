/**
 * @Author: shensju
 * @Date: 2021/1/17 11:57
 */
public class Solution0067 {

    /**0067 Add Binary**/
    public String addBinary(String a, String b) {
        if ("0".equals(a) && "0".equals(b)) return "0";
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int a1 = i < 0 ? 0 : a.charAt(i) - '0';
            int b1 = j < 0 ? 0 : b.charAt(j) - '0';
            result.append((a1 + b1 + add) % 2);
            add = (a1 + b1 + add) / 2;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
