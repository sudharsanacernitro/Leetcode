class Solution {
    public int totalHammingDistance(int[] nums) {


        int total=0;

        for(int i=0;i<32;i++)
        {
            int countones=0;
            for(int num:nums)
            {
                 countones+=(num >> i)&1;
            }

            int countZeros=nums.length-countones;

            total+=countones*countZeros;
        }
      
      return total;
    }

   
}