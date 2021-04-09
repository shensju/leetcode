import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/4/9 23:22
 */
public class Solution0150 {

    /** 0150 Evaluate Reverse Polish Notation **/
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

    /**
     * 时间复杂度：(n)  空间复杂度：O(n)
     * Runtime: 4 ms, faster than 91.92% of Java online submissions for Evaluate Reverse Polish Notation.
     * Memory Usage: 38.8 MB, less than 35.41% of Java online submissions for Evaluate Reverse Polish Notation.
     */
}
