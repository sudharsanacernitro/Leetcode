class Solution {
    public int maxProduct(int[] nums) {
        
        int maxM=nums[0];
       
        int currMax=nums[0],currMin=nums[0];

        for(int i=1 ;i<nums.length;i++)
        {
            int num=nums[i];

            if(num < 0)
            {
                int temp=currMax;
                currMax=currMin;
                currMin=temp;
            }

            currMax=Math.max(num,currMax*num);
            currMin=Math.min(num,currMin*num);

            maxM=Math.max(maxM,currMax);



        }

        return maxM;
    }
}