import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/4/10 23:20
 */
public class Solution0232 {

    /** 0232 Implement Queue using Stacks **/
    class MyQueue {
        private int front;
        private Stack<Integer> s1;
        private Stack<Integer> s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (s1.isEmpty())
                front = x;
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (!s2.isEmpty()) {
                return s2.peek();
            }
            return front;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    /**
     * 时间复杂度：O(1)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
     * Memory Usage: 38.6 MB, less than 5.22% of Java online submissions for Implement Queue using Stacks.
     */
}
