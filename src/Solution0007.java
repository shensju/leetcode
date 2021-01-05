/**
 * @Author: shensju
 * @Date: 2021/1/4 23:23
 */
public class Solution0007 {

    public int reverse01(int x) {
        int zf = 1;
        String str = null;
        if (x < 0) {
            str = String.valueOf(x).substring(1);
            zf = -1;
        } else {
            str = String.valueOf(x);
        }
        StringBuilder temp = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            temp.append(str.charAt(i));
        }
        long result = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != '0') {
                result = Long.valueOf(temp.substring(i)) * zf;
                break;
            }
        }
        return (int) result == result ? (int) result : 0;
    }

    public int reverse02(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return (int) result == result ? (int) result : 0;
    }
}
