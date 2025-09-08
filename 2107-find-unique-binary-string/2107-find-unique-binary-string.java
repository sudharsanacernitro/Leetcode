class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int size = nums[0].length();

        int maxNum =(int) Math.pow(2,size) - 1;

        HashSet<Integer> hs = new HashSet<>();

        for( String num : nums)
        {
            hs.add(Integer.parseInt(num,2));
        }

        String result = "";

        for(int i=maxNum;i>=0;i--)
        {
            if(!hs.contains(i))
            {
                result = Integer.toBinaryString(i);
            }
        }

        while(result.length() != nums[0].length())
        {
            result = "0"+result;
        }

        return result;
    }
}