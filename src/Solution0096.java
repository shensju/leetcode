/**
 * @Author: shensju
 * @Date: 2021/6/15 20:46
 * 0096 Unique Binary Search Trees（不同的二叉搜索树）
 */
public class Solution0096 {

    /**
     * 方法一：动态规划
     * @param n
     * @return
     */
    public int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
    /**
     * 时间复杂度：O(n^2)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
     * Memory Usage: 35.8 MB, less than 35.08% of Java online submissions for Unique Binary Search Trees.
     */


    /**
     * 方法二：卡塔兰树 Cn
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
     * Memory Usage: 35.7 MB, less than 59.60% of Java online submissions for Unique Binary Search Trees.
     */
}
