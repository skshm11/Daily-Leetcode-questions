class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, l = 0, r = nums.length - 1, curr = 0;

        while(curr <= r){
            if(nums[curr] == 0){
                swap(nums, curr, l);
                l++;
                curr++;
            }else if(nums[curr] == 2){
                swap(nums, curr, r);
                r--;
                //curr++;
            }else{
                curr++;
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}