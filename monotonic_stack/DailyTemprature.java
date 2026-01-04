package monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

class DailyTemprature {
    public int[] dailyTemprature(int[] temp) {
        int n = temp.length;
        int ans[] = new int[n];

        Arrays.fill(ans, 0);

        // Approach 1: brute force:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temp[i] <= temp[j]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }

        // Approach 2: monotonic stack:
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }

        return ans;
    }
}
