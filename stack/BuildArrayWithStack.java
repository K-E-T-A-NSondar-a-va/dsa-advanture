package stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BuildArrayWithStack {
    public List<String> buildArray(int[] target, int n) {
        HashSet<Integer> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for(int num : target) {
            set.add(num);
        }

        int count = 0;
        for(int i = 1; i <= n && count < target.length; i++) {
            ans.add("Push");
            count++;
            if(!set.contains(i)) {
                ans.add("Pop");
                count--;
            }
        }

        return ans;


        // More clean approach + simple:
        // ArrayList<String> actions = new ArrayList<>();

        // int i = 1;
        // int j = 0;
        // while (j < target.length && i <= n) {
        //     if (target[j] == i) {
        //         actions.add("Push");
        //         j++;
        //     } else {
        //         actions.add("Push");
        //         actions.add("Pop");
        //     }

        //     i++;
        // }

        // return actions;
    }
}
