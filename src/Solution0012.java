/**
 * @Author: shensju
 * @Date: 2021/1/8 21:44
 */
public class Solution0012 {

    /***0012 Integer to Roman*/

    /**方法一：通过除法**/
    public String intToRoman(int num) {
        int[] digits = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int[] ans = getLargestIndex(digits, num);
            if (ans != null) {
                for (int i = 0; i < ans[1]; i++) {
                    result.append(romans[ans[0]]);
                }
                num -= digits[ans[0]] * ans[1];
            }
        }
        return result.toString();
    }

    private int[] getLargestIndex(int[] digits, int num) {
        if (num <= 0) return null;
        for (int i = 0; i < digits.length; i++) {
            if (num / digits[i] > 0 && num / digits[i] < 10) {
                return new int[]{i, num / digits[i]};
            }
        }
        return null;
    }


    /**方法二：通过加减法**/
    public String intToRoman02(int num) {
        int[] digits = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int index = getLargestIndex02(digits, num);
            if (index != -1) {
                result.append(romans[index]);
                num -= digits[index];
            }
        }
        return result.toString();
    }

    private int getLargestIndex02(int[] digits, int num) {
        if (num <= 0) return -1;
        for (int i = 0; i < digits.length; i++) {
            if (num < digits[i]) {
                return --i;
            }
        }
        return digits.length - 1;
    }
}
