class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, area = 0;

        while(l <= r){
            int h = Math.min(height[l], height[r]);
            int width = r - l;
            area = Math.max(area,h * width);

            if(height[l] < height[r]) l++;
            else r--;
        }

        return area;
    }
}