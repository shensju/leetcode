import java.security.SignatureSpi;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/1/10 16:32
 */
public class Solution0020 {

    /**0020 Valid Parentheses**/
    public boolean isValid(String s) {
        Stack<Character> initStack = new Stack<>();
        Stack<Character> tempStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            initStack.push(chars[i]);
        }
        while(!initStack.isEmpty()) {
            char c = initStack.pop();
            if (tempStack.isEmpty()) {
                tempStack.push(c);
            } else {
                if (match(c, tempStack.peek())) {
                    tempStack.pop();
                } else {
                    tempStack.push(c);
                }
            }
        }
        System.out.println("tempStack : " + tempStack.toString());
        return tempStack.isEmpty();
    }

    private boolean match(char c1, char c2) {
        if (c1 == '(' && c2 == ')') return true;
        else if (c1 == '{' && c2 == '}') return true;
        else if (c1 == '[' && c2 == ']') return true;
        return false;
    }

    /**逆向思维**/
    public boolean isValid02(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
