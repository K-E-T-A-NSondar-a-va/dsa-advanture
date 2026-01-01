package array_1;

import java.util.HashSet;
import java.util.Set;

public class SetMissMatch {
    public int[] findErrorNums(int[] nums) {
        int ans[] = new int[2];

        Set<Integer> set = new HashSet<>();

        for(int i = 1; i <= nums.length; i++) {
            set.add(i);
        }

        for(int i : nums) {
            if(!set.remove(i)) {
                ans[0] = i;
            }
        }

        Integer sec = set.stream().findFirst().orElse(0);
        ans[1] = sec;
        return ans;
    }
}
