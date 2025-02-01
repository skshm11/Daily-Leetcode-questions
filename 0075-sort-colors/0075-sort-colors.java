class Solution {
    public void sortColors(int[] nums) {
        int curr = 0, l = 0, r = nums.length - 1;

        while(curr <= r){
            if(nums[curr] == 0){
                swap(nums, curr,l);
                l++;
                curr++;
            }else if(nums[curr] == 2){
                swap(nums, curr, r);
                r--;
            }else
            {curr++;}
        }
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}