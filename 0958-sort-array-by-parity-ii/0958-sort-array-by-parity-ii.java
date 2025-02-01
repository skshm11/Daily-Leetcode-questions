class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int e = 0, o = 1, n = nums.length;
        int[] ans = new int[n];

        for(int num: nums){
            if(num % 2 == 0){
                ans[e] = num;
                e+=2;
            }else{
                ans[o] = num;
                o+=2;
            }
        }

        return ans;
    }
}