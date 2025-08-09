class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxConsecutiveOnes = 0;
        int n = nums.length,i=0;

        while(i < n)
        {
            int j=0;
            while(i+j < n && nums[i+j] == 1)
            {
                j++;
            }

            maxConsecutiveOnes = Math.max(maxConsecutiveOnes , j);

            if(j != 0) i+=j;
            else i++;
        }

        return maxConsecutiveOnes;
    }
}