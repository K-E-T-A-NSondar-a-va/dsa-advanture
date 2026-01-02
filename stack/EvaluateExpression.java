package stack;

import java.util.Stack;

// brillient: solved in one go !!

public class EvaluateExpression {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens) {
            if(isNumeric(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int secondOpr = stack.pop();
                int firstOpr = stack.pop();
                stack.push(calculate(firstOpr, secondOpr, s));
            }
        }

        return stack.pop();
    }

    private static int calculate(int fOpr, int sOpr, String operation) {
        return switch(operation) {
            case "+" -> fOpr + sOpr;
            case "-" -> fOpr - sOpr;
            case "*" -> fOpr * sOpr;
            case "/" -> fOpr / sOpr;
            default -> fOpr + sOpr;
        };
    }

    private static boolean isNumeric(String s) {
        try {
            Integer num = Integer.valueOf(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
