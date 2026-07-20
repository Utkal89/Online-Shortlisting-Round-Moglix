import java.util.*;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else { 
                    int len = i - stack.peek();
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestValidParentheses("(()"));
        System.out.println(sol.longestValidParentheses(")()())"));
        System.out.println(sol.longestValidParentheses(""));
    }
}
