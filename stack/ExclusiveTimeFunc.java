package stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunc {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        
        int[] ans = new int[n];

        int lastLogTimeStamp = -1;

        for(String log : logs) {
            String[] parts = log.split(":");

            int funcId = Integer.parseInt(parts[0]);
            boolean isStart = "start".equals(parts[1]);
            int timeStamp = Integer.parseInt(parts[2]);

            // inclusive of the start unit:
            if(!isStart) timeStamp += 1;


            // calculation:
            if(!stack.isEmpty()) {
                int currFuncId = stack.peek();
                ans[currFuncId] += timeStamp - lastLogTimeStamp;
            }

            lastLogTimeStamp = timeStamp;

            if(isStart) {
                stack.push(funcId);
            } else {
                stack.pop();
            }
        }

        return ans;
    }
}
