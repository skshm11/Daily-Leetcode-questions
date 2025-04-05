class Solution {
public int[][] merge(int[][] intervals) {
    // 1. Sort intervals based on start time
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    
    // 2. Initialize merged list with first interval
    List<int[]> merged = new ArrayList<>();
    merged.add(intervals[0]);
    
    // 3. Iterate through remaining intervals
    for(int i = 1; i < intervals.length; i++) {
        int[] current = intervals[i];
        int[] lastMerged = merged.get(merged.size() - 1);
        
        // 4. Check for overlap
        if(current[0] <= lastMerged[1]) {
            // 5. Merge if overlapping
            lastMerged[1] = Math.max(lastMerged[1], current[1]);
        } else {
            // 6. Add to list if not overlapping
            merged.add(current);
        }
    }
    
    // 7. Convert list to array and return
    return merged.toArray(new int[merged.size()][]);
}

// NOTE: TC- o(n logn) because sorting in the first step takes n logn time 
}