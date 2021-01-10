import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shensju
 * @Date: 2021/1/10 15:46
 */
public class Solution0022 {

    /**0022 Generate Parentheses**/
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    /**方法一：暴力法**/
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (int i = 0; i < current.length; i++) {
            if (current[i] == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    /**方法二：回溯法**/
    public void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
