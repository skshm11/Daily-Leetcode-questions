class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;

        for(int num: nums){
            if(hm.containsKey(num - k)){
                ans += hm.get(num - k);
            }   

            if(hm.containsKey(num + k)){
                ans += hm.get(num + k);
            }

            hm.put(num, hm.getOrDefault(num,0) + 1); 

        }

        return ans;
    }
}
// We will use a hashmap to store frequesncy.
// Since we need absolute diff we need to calculate two conditions.
// Add the frequency of the existing value in the result