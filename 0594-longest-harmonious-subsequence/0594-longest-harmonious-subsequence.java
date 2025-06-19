class Solution {
    public int findLHS(int[] nums) {
        
        TreeMap<Integer,Integer> hm=new TreeMap<>();

        for(int i:nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }

        int start=0,num=0,maxLength=0;
        for(int i:hm.keySet())
        {
            if(start == 0)
            {
                num=i;
                start=1;
                continue;
            }

            if(Math.abs(i-num) == 1)
            {
                maxLength=Math.max(hm.get(num)+hm.get(i) , maxLength);
            }
            num=i;
        }

        return maxLength;
    }
}