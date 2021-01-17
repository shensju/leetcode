import java.util.Arrays;

/**
 * @Author: shensju
 * @Date: 2021/1/17 12:20
 */
public class Solution0066 {

    /**0066 Plus One**/
    public int[] plusOne(int[] digits) {
        int[] temp = new int[digits.length + 1];
        temp[digits.length] = 1;
        int i = digits.length - 1;
        int j = digits.length;
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int n1 = i < 0 ? 0 : digits[i];
            int n2 = j < 0 ? 0 : temp[j];
            temp[j] = (n1 + n2 + add) % 10;
            add = (n1 + n2 + add) / 10;
            i--;
            j--;
        }
        if (temp[0] != 0) {
            return temp;
        } else {
            int[] result = new int[temp.length - 1];
            for (int k = 1; k < temp.length; k++) {
                result[k - 1] = temp[k];
            }
            return result;
        }
    }

    public int[] plusOne02(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
