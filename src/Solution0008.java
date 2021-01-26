import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shensju
 * @Date: 2021/1/25 22:13
 */
public class Solution0008 {

    /**0008 String to Integer (atoi)**/
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    static class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<>();

        public Automaton() {
            /**
             * 确定有限状态自动机 DFA (Deterministic Finite Automaton)
             *              ''          +/-          number          other
             * start        start       signed       in_number       end
             * signed       end         end          in_number       end
             * in_number    end         end          in_number       end
             * end          end         end          end             end
             */
            table.put("start", new String[]{"start", "signed", "in_number", "end"});
            table.put("signed", new String[]{"end", "end", "in_number", "end"});
            table.put("in_number", new String[]{"end", "end", "in_number", "end"});
            table.put("end", new String[]{"end", "end", "end", "end"});
        }

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + (c - '0');
                // 判断是否溢出
                ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, - (long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') return 0;
            if (c == '+' || c == '-') return 1;
            if (Character.isDigit(c)) return 2;
            return 3;
        }
    }
}
