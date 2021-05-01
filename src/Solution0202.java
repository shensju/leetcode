/**
 * @Author: shensju
 * @Date: 2021/5/1 23:01
 */
public class Solution0202 {

    /** 0202 Happy Number **/
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    /**
     * 时间复杂度：O(logn)  空间复杂度：O(1)
     * Runtime: 1 ms, faster than 99.73% of Java online submissions for Happy Number.
     * Memory Usage: 35.3 MB, less than 73.61% of Java online submissions for Happy Number.
     */
}
