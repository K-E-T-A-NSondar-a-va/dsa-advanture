package array_1;

// EASY, DSA Advanture Array 1

class ArrConcentration {
    public int[] getConcatenation(int[] nums) {
	    int n = nums.length;
        int[] ans = new int[n*2];
	
        for(int i = 0; i < n*2; i++) {
            ans[i] = nums[i%n];
        }

        return ans;

        // other solution:
        // solution 1: using arraycopy method:
        // int n = nums.length;
        // int ans[] = new int[2*n];
        // System.arraycopy(nums,0,ans,0,n);
        // System.arraycopy(nums,0,ans,n,n); // arrcopy(oldArr,oldStartIdx,newArr,newArrStartIdx,NoOfElementAdded) Syntax =
        // return ans;

        // filling two positions at once
        // for(int i=0;i<n;i++)
        // {
        //     res[i]=nums[i];
        //     res[i+n]=nums[i];
        // }
    }
}
