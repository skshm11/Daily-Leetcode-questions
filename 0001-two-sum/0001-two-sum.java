class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i<nums.length;i++){
            int x = target - nums[i];
            if(hm.containsKey(x)){
                ans[0] = hm.get(x);
                ans[1] = i;
                break;
            }

            hm.put(nums[i], i);
        }

        return ans;
    }
}