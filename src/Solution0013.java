/**
 * @Author: shensju
 * @Date: 2021/1/7 21:53
 */
public class Solution0013 {

    /**0013 Roman to Integer**/
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        if (chars.length == 1) return getValue(chars[0]);
        int count = getValue(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            int value = getValue(chars[i]);
            int preValue = getValue(chars[i -1]);
            count += value;
            if (value > preValue) {
                count -= preValue * 2;
            }
        }
        return count;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }
}
