/**
 * @Author: shensju
 * @Date: 2021/1/16 11:34
 */
public class Solution0043 {

    /**0043 Multiply Strings**/
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        // 保存num1和num2的乘积
        String product = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            // 保存num2的第i位数字与num1相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补0
            for (int j = 0; j < num2.length() - 1 -i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';
            int add = 0;
            for (int j = num1.length() - 1; j >= 0 || add != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                temp.append((n1 * n2 + add) % 10);
                add = (n1 * n2 + add) / 10;
            }
            product = addStrings(product, temp.reverse().toString());
        }
        return product;
    }

    private String addStrings(String str1, String str2) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        StringBuilder sum = new StringBuilder();
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int n1 = i < 0 ? 0 : str1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : str2.charAt(j) - '0';
            sum.append((n1 + n2 + add) % 10);
            add = (n1 + n2 + add) / 10;
            i--;
            j--;
        }
        return sum.reverse().toString();
    }
}
