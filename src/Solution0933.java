import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shensju
 * @Date: 2021/4/15 22:55
 */
public class Solution0933 {

    /** 0933 Number of Recent Calls **/
    class RecentCounter {

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < (t - 3000)) {
                queue.poll();
            }
            return queue.size();
        }
    }

    /**
     * 时间复杂度：O(Q)，其中 Q 是 ping 的次数。
     * 空间复杂度：O(W)，其中 W = 3000 是队列中最多存储的 ping 的记录数目。
     * Runtime: 18 ms, faster than 83.81% of Java online submissions for Number of Recent Calls.
     * Memory Usage: 47.1 MB, less than 85.65% of Java online submissions for Number of Recent Calls.
     */
}
