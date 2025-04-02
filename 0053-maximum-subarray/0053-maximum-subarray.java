class Solution {
    public int maxSubArray(int[] nums) {
        // maxSum = Integer.MIN_VALUE to make sure any subarray value even if it's negative is greater than min value
        int maxSum = Integer.MIN_VALUE, sum = 0;

        for(int num: nums){
            sum += num;

            maxSum = Math.max(maxSum, sum);

            // if the sum < 0, this means that including that element makes the subarray negative. So it's better to mnake it 0, and start afresh.
            if(sum < 0) sum = 0; 
        }

        return maxSum;
    }
}