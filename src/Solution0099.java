import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/6/21 22:35
 * 0099 Recover Binary Search Tree（恢复二叉搜索树）
 */
public class Solution0099 {

    /** Definition for a binary tree node **/
    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 方法一：通过对中序遍历得到的结果，进行再处理得到正确的二叉搜索树
     * @param root
     */
    public void recoverTree(TreeNode root) {
        // 得到中序遍历的结果
        List<Integer> nums = inorderTraverse(root);
        // 查找不符合二叉搜索树规则的结点
        int[] twoSwap = findTwoSwap(nums);
        // 交换不符合二叉搜索树规则的结点
        recover(root, 2, twoSwap[0], twoSwap[1]);
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 4 ms, faster than 20.26% of Java online submissions for Recover Binary Search Tree.
     * Memory Usage: 39.5 MB, less than 42.63% of Java online submissions for Recover Binary Search Tree.
     */

    private List inorderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    private int[] findTwoSwap(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }

    /**
     * 方法二
     * @param root
     */
    public void recoverTree2(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predcessor = null;
        while (root != null) {
            if (root.left != null) {
                // predcessor结点是root结点的左子树上的最右侧结点
                predcessor = root.left;
                while (predcessor.right != null && predcessor.right != root) {
                    predcessor = predcessor.right;
                }
                // 首次遍历时，如果predcessor结点的右指针为空，则将其指向root结点
                if (predcessor.right == null) {
                    predcessor.right = root;
                    root = root.left;
                } else {
                    // 第二次遍历，此时root结点的左子树已经处理完成，需要将predcessor结点的右指针置为空
                    if (pred != null && pred.val > root.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    predcessor.right = null;
                    root = root.right;
                }
            } else {
                // root结点的左子树为空时，直接访问root结点的右子树
                if (pred != null && pred.val > root.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 2 ms, faster than 87.03% of Java online submissions for Recover Binary Search Tree.
     * Memory Usage: 39.6 MB, less than 25.57% of Java online submissions for Recover Binary Search Tree.
     */
}
