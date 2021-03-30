import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/3/30 22:10
 */
public class Solution0155 {

    /** 0155 MinStack **/
    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> min_stack;

        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (min_stack.isEmpty() || val <= min_stack.peek()) {
                min_stack.push(val);
            }
        }

        public void pop() {
            if (stack.pop().equals(min_stack.peek())) {
                min_stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }

    /**
     * 时间复杂度：O(1)  空间复杂度：O(n)  表示辅助栈中包含的n个元素大小的空间
     * Runtime: 4 ms, faster than 92.59% of Java online submissions for Min Stack.
     * Memory Usage: 41 MB, less than 31.64% of Java online submissions for Min Stack.
     */
}
