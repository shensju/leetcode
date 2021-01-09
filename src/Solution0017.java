import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shensju
 * @Date: 2021/1/8 23:34
 */
public class Solution0017 {

    /**0017 Letter Combinations of a Phone Number**/

    private String[] letterMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0 || "".equals(digits) || digits == null) return result;
        findCombination(digits, 0, "");
        return result;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        return;
    }

    // 采用StringBuilder类型处理，提高程序运行效率
    private void findCombination(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, sb.append(letters.charAt(i)));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
