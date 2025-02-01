class Solution {
    public int removeDuplicates(int[] nums) {
        // we will use 2 pointer approach in this ques

        int c = 0;

        for(int i = 1; i< nums.length;i++){
            if(nums[c] != nums[i]){
                c += 1;
                nums[c] = nums[i];
            }
        }

        return c+1;
    }
}