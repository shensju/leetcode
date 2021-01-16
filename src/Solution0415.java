/**
 * @Author: shensju
 * @Date: 2021/1/16 11:06
 */
public class Solution0415 {

    /**0415 Add Strings**/
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder sum = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            sum.append((n1 + n2 + add) % 10);
            add = (n1 + n2 + add) / 10;
            i--;
            j--;
        }
        return sum.reverse().toString();
    }
}
