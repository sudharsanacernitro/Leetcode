class Solution {
    public int maxArea(int[] height) {
        
        int i=0,j=height.length-1;
        int maxWater=0;
        while(i<j)
        {
            int height_=Math.min(height[i],height[j]);

            int area=(j-i)*height_;
            maxWater=Math.max(maxWater,area);

            if(height[i]<height[j]) i++;
            else j--;
        }

        return maxWater;
    }
}