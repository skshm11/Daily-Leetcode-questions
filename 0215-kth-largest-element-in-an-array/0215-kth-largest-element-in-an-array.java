class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.add(num);

            if(pq.size() > k) pq.poll();
        }

        return pq.peek();
    }

// Notes:
//Each element gets inserted once → n × O(log k)
//Each insertion (offer) into the heap takes O(log m) time, where m is current heap size
//Each removal (poll) from the heap also takes O(log m) time
//Since we maintain the heap size ≤ k, all operations are O(log k)    
}