class Solution {
public int minMeetingRooms(int[][] intervals) {
        // Check for empty input
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Min-heap to track end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            
            // If the earliest ending meeting has finished
            if (current[0] >= minHeap.peek()) {
                minHeap.poll(); // Reuse this room
            }
            
            // Add current meeting's end time (either to reused room or new room)
            minHeap.offer(current[1]);
        }
        
        return minHeap.size();
    }
}
// NOTE: Time Complexity
// O(n log n) for sorting the intervals

// O(n log n) for heap operations (each offer/poll operation is O(log n) done n times)

// Total: O(n log n)

// Space Complexity
// O(n) for the heap storage (in worst case when all meetings overlap)