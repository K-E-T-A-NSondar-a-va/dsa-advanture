package monotonic_stack;

import java.util.Stack;

// EASY: brute force allowed, can be optimized using monotonic stack

class PricesWithDiscount {
    public int[] pricesWithDiscount(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        // Approach 1: brute force:
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[i] > prices[j]) {
                    ans[i] -= prices[j];
                    break;
                }
            }
        }

        // Approach 2: monotonic stack:
        Stack<Integer> stack = new Stack<>();

        ans = prices.clone();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                ans[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }

        return ans;
    }
}
