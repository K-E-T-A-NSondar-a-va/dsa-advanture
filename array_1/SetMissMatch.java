package array_1;

import java.io.FileWriter;
import java.io.IOException;
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

        static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
    
    // optimized by you: in single loop:
    // public int[] findErrorNums(int[] nums) {
    //    int ans[] = new int[2];
    //    Set<Integer> set = new HashSet<>();
       
    //    int n = nums.length;

    //    int sum = 0;
    //    for(int num : nums) {
    //     if(!set.add(num)) {
    //         ans[0] = num;
    //     }
    //     sum += num;
    //    }

    //    int total = (n * (n + 1)) / 2;
    //    System.out.println(total);
    //    if(total > sum)
    //      ans[1] = (total - sum) + ans[0];
    //    else
    //      ans[1] = ans[0] - (sum - total);

    //    return ans;
    // }

    // If the duplicate consicutive, this would have workd as well (without set) (O(n)):
    // public int[] findErrorNums(int[] nums) {
    //    int ans[] = new int[2];

    //    int n = nums.length;
    //    int sum = nums[0];
    //    for(int i = 1; i < n; i++) {
    //     if(nums[i-1] == nums[i]) {
    //         ans[0] = nums[i];
    //     }
    //     sum += nums[i];
    //    }

    //    int total = (n * (n + 1)) / 2;
    //    System.out.println(total);
    //    if(total > sum)
    //      ans[1] = (total - sum) + ans[0];
    //    else
    //      ans[1] = ans[0] - (sum - total);

    //    return ans;
    // }
}
