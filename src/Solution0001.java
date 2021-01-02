import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shensju
 * @Date: 2021/1/2 11:12
 */
public class Solution0001 {

    public static void main(String[] args) {
        int[] result = Solution0001.twoSum02(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result != null ? Arrays.toString(result) : "the solutioin does not exist.");
    }

    public static int[] twoSum01(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (x + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }

    public static int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> numberIndex = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (numberIndex.containsKey(complement)) {
                result[0] = numberIndex.get(complement);
                result[1] = i;
                return result;
            }
            numberIndex.put(num, i);
        }
        return result;
    }
}
