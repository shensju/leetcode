import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shensju
 * @Date: 2021/3/31 23:44
 */
public class Solution0225 {

    /** 0225 Implement Stack using Queues **/
    class MyStack {

        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * 时间复杂度：入栈操作O(n)，其余操作都是O(1)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
     * Memory Usage: 36.7 MB, less than 74.54% of Java online submissions for Implement Stack using Queues.
     */
}
