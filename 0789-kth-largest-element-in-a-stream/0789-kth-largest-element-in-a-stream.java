class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        
        this.k = k;
        minHeap = new PriorityQueue();

        for(int num : nums){
            if(minHeap.size() < k){
                minHeap.offer(num);
        }else if(num > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
        }
    }
}
    
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.offer(val);
        }else if(val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */