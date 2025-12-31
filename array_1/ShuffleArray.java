package array_1;

// EASY, DSA Advanture Array 2

class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[n*2];

        int count = 0;
        for(int i = 0; i < n; i++) {
            ans[++count] = nums[i];
            ans[++count] = nums[n + i];
        }

        return ans;
    }
}
